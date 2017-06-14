import java.io.File;

public class Player extends Character implements Damageable{

	//all info hardcoded and subject to change
	public Player(String name, int x, int y, int health /*TODO: get rid of this */, String imgLocation) {
		super.name = name;
		super.hitbox = new Hitbox(x, x, 2, 2);
		super.health = health;
		super.speed = 1;
		super.imgLocation = imgLocation;
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
	
	
	public static void main(String [] args){
//		Player p = new Player("Test");
		
	}
	
}
