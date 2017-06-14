import java.io.File;

public class Enemy extends Character implements Damageable{

	private boolean willChase;
	private boolean willPatrol;
	private int chaseDistance;
	private int patrolRight;
	private int patrolDown;
	
	
	
	
	public Enemy(File f) {
		super(f);
		willChase = sc.nextBoolean();
		if(willChase){
			chaseDistance = sc.nextInt();
		}
		if(willPatrol){
			patrolRight = sc.nextInt();
			patrolDown = sc.nextInt();
		}
		
	}
	
	public void attack(Hitbox r){
		if(hitbox.distanceFrom(r) < 20)
			return;
		//TODO do this.
	}
	
	public void patrol(int rows, int cols){
		hitbox.setLocation(0, 0);//figure out where to move when and movement as a whole
	}
	
	public void chase(){
		
	}

	public void move(int direction) {
		if(willChase){
			chase();
		}
		if(willPatrol){
			patrol();
		}
	}
	
	public void patrol(){
		
	}
	
	public Hitbox getHitbox(){
		return super.hitbox;
	}

	public void setHitbox(Hitbox hitbox){
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
	
	public String toString(){
		return super.toString()+"";
	}
	
	public static void main(String arg00000s){
		Enemy kendall = new Enemy(new File("Files/TestCharacter.txt"));
		System.out.println(kendall);
	}

}
