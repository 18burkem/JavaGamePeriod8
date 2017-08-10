import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character {

	public static final int NONE = 0;
	public static final int NORTH = 1;
	public static final int EAST = 2;
	public static final int SOUTH = -1;
	public static final int WEST = -2;

	protected Scanner sc;
	protected Hitbox hitbox;
	protected int health;
	protected int speed;
	protected String imgLocation;
	protected int direction = NONE;

	

	public Character(Hitbox h, int health, int speed, String imgLocation) {
		hitbox = h;
		this.health = health;
		this.speed = speed;
		this.imgLocation = imgLocation;
	}

	public String toString() {
		return "Health: " + health + "\tSpeed: " + speed + "\tImgLocation: " + imgLocation
				+ ", Hitbox: " + hitbox;
	}

	public void move(Room r) {
		if (canWalk(r)) {
			switch (direction) {
			case NORTH:
				hitbox.move(0, -speed);
				break;
			case EAST:
				hitbox.move(speed, 0);
				break;
			case SOUTH:
				hitbox.move(0, speed);
				break;
			case WEST:
				hitbox.move(-speed, 0);
				break;
			}
		} else {
			switch (direction) {
			case NORTH:
				hitbox.move(0, speed);
				break;
			case EAST:
				hitbox.move(-speed, 0);
				break;
			case SOUTH:
				hitbox.move(0, -speed);
				break;
			case WEST:
				hitbox.move(speed, 0);
				break;

			}
			direction = 0;
		}
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}

	public File getImg() {
		return new File(imgLocation);
	}

	public int getX() {
		return hitbox.x;
	}

	public int getY() {
		return hitbox.y;
	}

	public boolean canWalk(Room r) {
		Tile[] touching = getTouchingTiles(r);
		for (int i = 0; i < touching.length; i++) {
			if (!touching[i].isWalkable())
				return false;
		}
		return true;
	}

	public Tile[] getTouchingTiles(Room r) {
		return new Tile[] {
				r.getTile(hitbox.getIntY() / 100, hitbox.getIntX() / 100),
				r.getTile((int) hitbox.getMaxY() / 100, hitbox.getIntX() / 100),
				r.getTile((int) hitbox.getMaxY() / 100, (int) hitbox.getMaxX() / 100),
				r.getTile(hitbox.getIntY() / 100, (int) hitbox.getMaxX() / 100) 
			};
	}

	public void setDirection(int dir) {
		direction = dir;
	}

	public int getDirection() {
		return direction;
	}
	
	public void place(int x, int y){
		hitbox.x = x;
		hitbox.y = y;
	}

}
