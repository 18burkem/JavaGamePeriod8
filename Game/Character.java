import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character {

	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Enemy> npcList = new ArrayList<Enemy>();
	private Boss boss;

	public final static int NONE = 0;
	public final static int NORTH = 1;
	public final static int NORTHEAST = 2;
	public final static int EAST = 3;
	public final static int SOUTHEAST = 4;
	public final static int SOUTH = 5;
	public final static int SOUTHWEST = 6;
	public final static int WEST = 7;
	public final static int NORTHWEST = 8;

	protected Scanner sc;
	protected String name;
	protected Hitbox hitbox;
	protected int health;
	protected int speed;
	protected int diagonalSpeed = (int) (speed * Math.sqrt(2));
	protected String imgLocation;
	protected int direction;

	public Character() {
	}

	public Character(File f) {
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun) {
			kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun.printStackTrace();
		}
		name = sc.nextLine();
		hitbox = new Hitbox(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		sc.nextLine();
		health = sc.nextInt();
		sc.nextLine();
		speed = sc.nextInt();
		sc.nextLine();
		imgLocation = sc.nextLine();

		while (sc.hasNextLine() && sc.nextLine() != "") {
			enemyList.add(new Enemy(new File(sc.nextLine())));
		}

	}

	public void move() {
		switch (direction) {
		case NORTH:
			hitbox.changeLocation(0, -speed);
			break;
		case NORTHEAST:
			hitbox.changeLocation(diagonalSpeed, -diagonalSpeed);
			break;
		case EAST:
			hitbox.changeLocation(speed, 0);
			break;
		case SOUTHEAST:
			hitbox.changeLocation(diagonalSpeed, diagonalSpeed);
			break;
		case SOUTH:
			hitbox.changeLocation(0, speed);
			break;
		case SOUTHWEST:
			hitbox.changeLocation(-diagonalSpeed, diagonalSpeed);
			break;
		case WEST:
			hitbox.changeLocation(-speed, 0);
			break;
		case NORTHWEST:
			hitbox.changeLocation(-diagonalSpeed, -diagonalSpeed);
			break;
		}
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		this.hitbox = hitbox;
	}

	public String getImageLocation() {
		return this.imgLocation;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection(){
		return direction;
	}

	public int getX(){
		return hitbox.x;
	}
	
	public int getY(){
		return hitbox.y;
	}
	
	public String toString() {
		return "Name: " + name + "\tHealth: " + health + "\tSpeed: " + speed + "\tImgLocation: " + imgLocation;
	}

	public abstract String update(int i, int north2);
	
}
