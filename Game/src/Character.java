import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character {
	
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	private ArrayList<Enemy> npcList = new ArrayList<Enemy>();
	private Boss boss;
	
	protected final int NONE = 0;
	protected final int NORTH = 1;
	protected final int NORTHEAST = 2;
	protected final int EAST = 3;
	protected final int SOUTHEAST = 4;
	protected final int SOUTH = 5;
	protected final int SOUTHWEST = 6;
	protected final int WEST = 7;
	protected final int NORTHWEST = 8;
	
	protected Scanner sc;
	protected String name;
	protected Hitbox hitbox;
	protected int health;
	protected int speed;
	protected int diagonalSpeed = (int)(speed * Math.sqrt(2));
	protected String imgLocation;
	protected int direction;
	
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
		
		while(sc.hasNextLine()&&sc.nextLine()!=""){
			enemyList.add(new Enemy(new File(sc.nextLine())));
		}
		
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
	
	public Hitbox getHitbox(){
		return hitbox;
	}
	
	public void setHitbox(Hitbox hitbox){
		this.hitbox = hitbox;
	}
	
	public String getImageLocation(){
		return this.imgLocation;
	}
	
	public String toString(){
		return "Name: "+name+"\tHealth: "+health+"\tSpeed: "+speed+"\tImgLocation: "+imgLocation;
	}
}
