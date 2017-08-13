import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Room2 {

//	Wall
//	Grass
//	Dirt
//	Door
//	Water

	private Scanner sc;
	private Tile[][] tiles;
	public static final String GRASS = "g";
	public static final String WALL = "w";
	public static final String DIRT = "d";
	public static final String WATER = "wa";
	public static final String DOOR = "door";
	
	
	public String toString(){
		String str = "";
		for(int i = 0 ; i < tiles.length ; i++){
			for(int j = 0 ; j < tiles[i].length ; i++){
				if(tiles[i][j].isWalkable())
					str += "t";
				else
					str += "f";
			}
			str += "\n";
		}
		return str; 
	}
	
	public Room2(File f, int rows, int cols) {
		tiles = new Tile[rows][cols];
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int row = 0; row < rows;row++){
			for(int col = 0; col < cols&&sc.hasNextLine();col++){
				String nextLine = sc.nextLine();
				if(nextLine==GRASS)tiles[row][col]= new Tile("//Images//"+GRASS, true);
				else if(nextLine==WALL)tiles[row][col]= new Tile("//Images//"+WALL, true);
				else if(nextLine==DIRT)tiles[row][col]= new Tile("//Images//"+DIRT, true);
				else if(nextLine==WATER)tiles[row][col]= new Tile("//Images//"+WATER, true);
				else if(nextLine==DOOR){
//					tiles[row][col]= new Door("//Images//"+DOOR, sc.nextLine().equals("true"));
				} 
				else System.out.println("Row: "+row+" Column: "+col+" has the Strng \""+nextLine+"\"");
			}
		}
	}
	
	
	public static void main(String[] args){
		Room2 test = new Room2(new File("resources/testroom1.txt"), 3, 3);
		System.out.println(test);
	}

}
