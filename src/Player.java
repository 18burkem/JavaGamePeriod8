import java.io.File;

public class Player extends Character implements Damageable{

	//all info hardcoded and subject to change
	public Player(String name) {
		super.name = name;
		super.hitbox = new Hitbox(2, 2, 2, 2);
		super.health = 20;
		super.speed = 1;
		super.imgLocation = "resources/Images/Player";
	}

	public void move() {
		//update
	}
	
	public Hitbox getHitbox() {
		return super.hitbox;
	}

	public void setHitbox(Hitbox hitbox) {
		super.hitbox = hitbox;
	}

	public int getHealth() {
		return super.health;
	}

	public void setHealth(int health) {
		super.health = health;
	}

	public void recieveDamage(int damage) {
		super.health -= damage;
	}
	
}
