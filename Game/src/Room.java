import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {

//	Wall
//	Grass
//	Dirt
//	Door
//	Water

	private int row;
	private int col;
	private Scanner sc;
	private Tile[][] tiles;
	private final String GRASS = "g";
	private final String WALL = "w";
	private final String DIRT = "d";
	private final String WATER = "wa";
	private final String DOOR = "door";
	
	
	public Room(File f, int rows, int cols) {
		this.row = row;
		this.col = col;
		tiles = new Tile[rows][cols];
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun) {
			kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun.printStackTrace();
		}
		for(int row = 0; row < rows;row++){
			for(int col = 0; col < cols&&sc.hasNextLine();col++){
				String nextLine = sc.nextLine();
				if(nextLine.matches(GRASS))tiles[row][col]= new Tile("Images/"+GRASS, true);
				else if(nextLine.matches(WALL))tiles[row][col]= new Tile("Images/"+WALL, false);
				else if(nextLine.matches(DIRT))tiles[row][col]= new Tile("Images/"+DIRT, true);
				else if(nextLine.matches(WATER))tiles[row][col]= new Tile("Images/"+WATER, false);
				else if(nextLine.matches(DOOR)){
					boolean isLocked = sc.nextBoolean();
					tiles[row][col]= new Door("Images/"+DOOR+isLocked, isLocked, new File(sc.nextLine()));
				}
				else System.out.println("Row: "+row+" Column: "+col+" has the String \""+nextLine+"\"");
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
		return str;
	}
	
	public static void main(String[] gusFailedTheFinal){
		Room test = new Room(new File("Files/TestRoom.txt"), 3, 3);
		System.out.println(test);
		System.out.println(test.isWalkable(2, 2));
	}

}
