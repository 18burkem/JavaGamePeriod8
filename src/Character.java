import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character {
	
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Enemy> npcList = new ArrayList<Enemy>();
	private Boss boss;
	
	public static final int NONE = 0;
	public static final int NORTH = 1;
	public static final int NORTHEAST = 2;
	public static final int EAST = 3;
	public static final int SOUTHEAST = 4;
	public static final int SOUTH = 5;
	public static final int SOUTHWEST = 6;
	public static final int WEST = 7;
	public static final int NORTHWEST = 8;
	
	protected Scanner sc;
	protected String name;
	protected Hitbox hitbox;
	protected int health;
	protected int speed;
	protected int diagonalSpeed = (int)(speed * Math.sqrt(2));
	protected String imgLocation;
	protected int direction = NORTH;
	
	public Character(){}
	
	public Character(File f){
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun) {
			kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun.printStackTrace();
		}
		name = sc.nextLine();
		hitbox = new Hitbox(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());sc.nextLine();
		health = sc.nextInt();sc.nextLine();
		speed = sc.nextInt();sc.nextLine();
		imgLocation = sc.nextLine();
		
	}
	
	public void move(){
		switch(direction){
		case NORTH: hitbox.move(0, speed); break;
		case NORTHEAST: hitbox.move(diagonalSpeed, diagonalSpeed); break;
		case EAST: hitbox.move(speed, 0); break;
		case SOUTHEAST: hitbox.move(diagonalSpeed, -diagonalSpeed); break;
		case SOUTH: hitbox.move(0, -speed); break;
		case SOUTHWEST: hitbox.move(-diagonalSpeed, -diagonalSpeed); break;
		case WEST: hitbox.move(-speed, 0); break;
		case NORTHWEST: hitbox.move(-diagonalSpeed, diagonalSpeed); break;	
		}
	}
	
	public abstract String update(int playerDistance, int playerDirection);
	
	public Hitbox getHitbox(){
		return hitbox;
	}
	
	public void setHitbox(Hitbox hitbox){
		this.hitbox = hitbox;
	}
	
	public File getImg(){
		return new File(imgLocation+"/"+direction+".png");
	}
	
	public String toString(){
		return "Name: "+name+"\tHealth: "+health+"\tSpeed: "+speed+"\tImgLocation: "+imgLocation;
	}
}
