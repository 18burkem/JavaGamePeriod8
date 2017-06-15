import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {

	private int row;
	private int col;
	private Scanner sc;
	private Tile[][] tiles;
	private ArrayList<Character> characterList = new ArrayList<Character>();
	private final String GRASS = "g";
	private final String WALL = "w";
	private final String DIRT = "d";
	private final String WATER = "wa";
	private final String DOOR = "door";
	private final String ENEMY = "e";
	private final String BOSS = "b";
	private final String NPC = "n";
	
	
	public Room(File f, int rows, int cols) {
		this.row = rows;
		this.col = cols;
		tiles = new Tile[rows][cols];
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun) {
			kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun.printStackTrace();
		}
		for(int row = 0; row < rows;row++){
			for(int col = 0; col < cols&&sc.hasNextLine();col++){
				String nextLine = sc.nextLine();
				if(nextLine.matches(GRASS))tiles[row][col]= new Tile("resources/Images/"+GRASS+".png", true);
				else if(nextLine.matches(WALL))tiles[row][col]= new Tile("resources/Images/"+WALL+".png", false);
				else if(nextLine.matches(DIRT))tiles[row][col]= new Tile("resources/Images/"+DIRT+".png", true);
				else if(nextLine.matches(WATER))tiles[row][col]= new Tile("resources/Images/"+WATER+".png", false);
				else if(nextLine.matches(DOOR)){
					boolean isLocked = sc.nextBoolean();
					tiles[row][col]= new Door("resources/Images/"+DOOR+isLocked+".png", isLocked, new File(sc.nextLine()));
				}
				else System.out.println("Row: "+row+" Column: "+col+" has the String \""+nextLine+"\"");
			}
		}
		sc.nextLine();
		while(sc.hasNextLine()){
			String nextLine = sc.nextLine();
			if(nextLine.matches(ENEMY)){
				characterList.add(new Enemy(new File(sc.nextLine())));
			} else if(nextLine.matches(BOSS)){
				characterList.add(new Boss(new File(sc.nextLine())));
			} else if(nextLine.matches(NPC)){
				characterList.add(new NPC(new File(sc.nextLine())));
			}
		}
	}
	
	public boolean isWalkable(int row, int col){
		if(row>-1&&row<this.row&&col>-1&&col<this.col){
			return tiles[row][col].isWalkable();
		}
		return false;
	}
	
	public String toString(){
		String str = "";
		for(Tile[] tileRow: tiles){
			for(Tile tile: tileRow){
				str += tile.toString() + "\t";
			}
			str+= "\n";
		}
		str += characterList.toString();
		return str;
	}
	
	public Tile getTile(int row, int col){
		return tiles[row][col];
	}
	
	public ArrayList<Character> getCharacters(){
		return characterList;
	}
	
	public static void main(String[] gusFailedTheFinal){
		Room test = new Room(new File("resources/Rooms/TestRoom.txt"), 3, 3);
//		System.out.println(test);
		for(Character c: test.getCharacters()){
			System.out.println(c.hitbox);
			System.out.println(c.update(1, Character.EAST));
			System.out.println(c.hitbox);
		}
	}

}
