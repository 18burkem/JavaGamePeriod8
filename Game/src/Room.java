import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {

	public static final int SIDE_LENGTH = 8;

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
	private final String SAND = "s";
//	private final String ENEMY = "e";
//	private final String BOSS = "b";
//	private final String NPC = "n";

	public Room(File f, int rows, int cols) {
		this.row = rows;
		this.col = cols;
		tiles = new Tile[rows][cols];
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun) {
			kendallThinksThereIsSomethingWrongWithThisSinceThereIsNoPun.printStackTrace();
		}
		
		//looping through each tile in the file and filling in the room column by column
		for (int col = 0; col < cols && sc.hasNextLine(); col++) {
			for (int row = 0; row < rows; row++) {


				String nextLine = sc.nextLine();
				//handling all non-door tiles, easy to expand upon
				if (nextLine.matches(GRASS))
					tiles[row][col] = new Tile("resources/Images/" + GRASS + ".png", true,
							new Hitbox(col * Tile.TILE_SIZE, row * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE));
				else if (nextLine.matches(WALL))
					tiles[row][col] = new Tile("resources/Images/" + WALL + ".png", false,
							new Hitbox(col * Tile.TILE_SIZE, row * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE));
				else if (nextLine.matches(DIRT))
					tiles[row][col] = new Tile("resources/Images/" + DIRT + ".png", true,
							new Hitbox(col * Tile.TILE_SIZE, row * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE));
				else if (nextLine.matches(SAND))
					tiles[row][col] = new Tile("resources/Images/" + SAND + ".png", true,
							new Hitbox(col * Tile.TILE_SIZE, row * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE));
				else if (nextLine.matches(WATER))
					tiles[row][col] = new Tile("resources/Images/" + WATER + ".png", false,
							new Hitbox(col * Tile.TILE_SIZE, row * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE));
					
				
				//handling doors, which are written into files in a certain way
				//example:
				// door
				// false (false = not locked, true = locked)
				// file/path/to/next/room
				else if (nextLine.matches(DOOR)) {
					boolean isLocked = new Boolean(sc.nextLine());
					File nextRoom = new File(sc.nextLine());
					tiles[row][col] = new Door("resources/Images/" + DOOR + isLocked + ".png", isLocked,
							new Hitbox(col * Tile.TILE_SIZE, row * Tile.TILE_SIZE, Tile.TILE_SIZE, Tile.TILE_SIZE),
							nextRoom);
				} else
					//prints to the console what went wrong in case specified tile type is not supported
					System.out.println("Row: " + row + " Column: " + col + " has the String \"" + nextLine + "\"");
			}
		}
		
		//handling enemies, which get placed into the array of characters
//		sc.nextLine();
		while (sc.hasNextLine()) {
			String nextLine = sc.nextLine();
			if (nextLine.matches("randWalker")) {
				characterList.add(new RandWalker(new Hitbox(Integer.parseInt(sc.nextLine()),Integer.parseInt(sc.nextLine()),
						40,
						40)));
//				characterList.add(new Enemy(new File(sc.nextLine())));
				// } else if(nextLine.matches(BOSS)){
				// characterList.add(new Boss(new File(sc.nextLine())));
				// } else if(nextLine.matches(NPC)){
				// characterList.add(new NPC(new File(sc.nextLine())));
			}
		}
	}

	public boolean isWalkable(int row, int col) {
		if (row > -1 && row < this.row && col > -1 && col < this.col) {
			return tiles[row][col].isWalkable();
		}
		return false;
	}

	public String toString() {
		String str = "";
		for (Tile[] tileRow : tiles) {
			for (Tile tile : tileRow) {
				str += tile.toString() + "\t";
			}
			str += "\n";
		}
		str += characterList.toString();
		return str;
	}

	public Tile getTile(int row, int col) {
		return tiles[row][col];
	}

	public int getRows() {
		return row;
	}

	public int getCols() {
		return col;
	}

	public ArrayList<Character> getCharacters() {
		return characterList;
	}

}
