
public abstract class Projectile {
	private Hitbox hitBox;
	private int direction;
	private double speed;
	
	public Projectile(Hitbox hitbox, int direction, double speed) {
		this.hitBox = hitbox;
		this.direction = direction;
		this.speed = speed;
	}
	
	public boolean isFlying(){
		return this.speed > 0;
	}
	
	public boolean isResting(){
		return !isFlying();
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public double getSpeed(){
		return this.speed;
	}
	
	public void updateLocation(){
		switch(direction){
		case 1: 
		}
	}
}
