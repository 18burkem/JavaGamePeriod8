import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Character {
	
	protected final int NONE = 0;
	protected final int NORTH = 1;
	protected final int NORTH_EAST = 2;
	protected final int EAST = 3;
	protected final int SOUTH_EAST = 4;
	protected final int SOUTH = 5;
	protected final int SOUTH_WEST = 6;
	protected final int WEST = 7;
	protected final int NORTH_WEST = 8;
	
	private Scanner sc;
	protected String name;
	protected Hitbox hitbox;
	protected int health;
	protected double speed;
	protected String imgLocation;
	
	
	public Character(File f){
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun) {
			kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun.printStackTrace();
		}
		name = sc.nextLine();
		hitbox = new Hitbox(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());sc.nextLine();
		health = sc.nextInt();sc.nextLine();
		speed = sc.nextDouble();sc.nextLine();
		imgLocation = sc.nextLine();
	}
	
	public abstract void move(int direction);
	
	public abstract Hitbox getHitbox();
	
	public abstract void setHitbox(Hitbox hitbox);
	
	public String toString(){
		return "Name: "+name+"\tHealth: "+health+"\tSpeed: "+speed+"\tImgLocation: "+imgLocation;
	}
}
