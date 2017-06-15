import java.io.File;

public class Enemy extends Character implements Damageable{

	private boolean willChase;
	private boolean willPatrol;
	private int chaseDistance;
	private int patrolRight;
	private int patrolDown;
	private int patrolCount;
	private int attackCooldown;
	
	
	
	
	public Enemy(File f) {
		super(f);
		willChase = sc.nextBoolean();sc.nextLine();
		willPatrol = sc.nextBoolean();sc.nextLine();
		if(willChase){
			chaseDistance = sc.nextInt();//sc.nextLine();
			System.out.println(chaseDistance);
		}
		if(willPatrol){
			patrolRight = 100*sc.nextInt();sc.nextLine();
			patrolDown = 100*sc.nextInt();
		}
		
	}
	
	public void attack(){
		
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
	
	public String update(int playerDistance, int playerDirection) {
//		System.out.println(patrolCount+" "+patrolRight+" "+patrolDown);
		if(health<1){
			return "GAHHHH... am ded";
		}
		if(willChase && playerDistance <= chaseDistance){
			direction = playerDirection;
			move();
		} else if(willPatrol){
			if(patrolCount < patrolRight){
				direction = EAST;
			} else if(patrolCount < patrolRight + patrolDown){
				direction = SOUTH;
			} else if(patrolCount < 2*patrolRight+patrolDown){
				direction = WEST;
			} else if(patrolCount < 2*patrolRight+2*patrolDown){
				direction = NORTH;
			} else {
				direction = EAST;
				patrolCount = 0;
			}
			patrolCount+=speed;
			move();
		}
		return null;
	}
	
	public static void main(String args){
		Enemy kendall = new Enemy(new File("resources/Characters/TestEnemy.txt"));
		System.out.println(kendall);
		for(int i = 0; i < 20; i++){
			kendall.update(10, NORTH);
		}
	}

	

}