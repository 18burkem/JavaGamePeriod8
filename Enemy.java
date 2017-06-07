import java.io.File;

public class Enemy extends Character implements Damageable{

	
	
	
	
	public Enemy(File f) {
		super(f);
		
	}

	public void move(int direction) {
		
	}
	
	public Hitbox getHitbox(){
		return super.hitbox;
	}

	public void setHitbox(Hitbox hitbox){
		
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
	
	public static void main(String arg00000s){
		Enemy kendall = new Enemy()
	}

}
