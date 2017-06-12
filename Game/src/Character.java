import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Character {

	
	private Scanner sc;
	protected String name;
	protected Hitbox hitbox;
	protected int health;
	protected int speed;
	protected String imgLocation;
	protected int direction;
	
	
	public Character(File f){
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun) {
			kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun.printStackTrace();
		}
		name = sc.nextLine();
		hitbox = new Hitbox(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());sc.nextLine();
		health = sc.nextInt();sc.nextLine();
		speed = (int) sc.nextDouble();sc.nextLine();
		imgLocation = sc.nextLine();
	}
	
	public void move(int direction){
		switch(direction){
		case Hitbox.NORTHEAST: 
		case Hitbox.EAST:
			break;
		case Hitbox.SOUTHEAST:
			break;
		case Hitbox.SOUTH: 
			break;
		case Hitbox.SOUTHWEST:
			break;
		case Hitbox.WEST:
			break;
		case Hitbox.NORTHWEST: 
			break;
		default: hitbox.move(0, 0);
		}
	
				
	}
	
	public abstract Hitbox getHitbox();
	
	public abstract void setHitbox(Hitbox hitbox);
	
	public String toString(){
		return "Name: "+name+"\tHealth: "+health+"\tSpeed: "+speed+"\tImgLocation: "+imgLocation;
	}
}
