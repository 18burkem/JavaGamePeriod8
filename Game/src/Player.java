import java.io.File;

public class Player extends Character implements Damageable{

	public static final int DEFAULT_PLAYER_SPEED = 6;
	
	//all info hardcoded and subject to change
	public Player(Hitbox h, int health, int speed) {
		super(h, health, speed ,  "resources/Images/player.png");
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