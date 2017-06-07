import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Room {

//	Wall
//	Grass
//	Dirt
//	Door
//	Water

	private Scanner sc;
	private Tile[][] tiles;
	private final String GRASS = "g";
	private final String WALL = "w";
	private final String DIRT = "d";
	private final String WATER = "wa";
	private final String DOOR = "door";
	
	
	public Room(File f, int rows, int cols) {
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
					tiles[row][col]= new Door("Images/"+DOOR, sc.nextLine().equals("true"), new File("test"), 4);
				}
				else System.out.println("Row: "+row+" Column: "+col+" has the Strng \""+nextLine+"\"");
			}
		}
	}
	
	public String toString(){
		String str = "";
		for(Tile[] tileRow: tiles){
			for(Tile tile: tileRow){
				if(tile.isWalkable()){
					str += "T";
				}
				else
					str += "F";
			}
			str+= "\n";
		}
		return str;
	}
	
	public static void main(String[] gusFailedTheFinal){
		Room test = new Room(new File("resources/testroom1.txt"), 7, 7);
		System.out.println(test);
	}

}
