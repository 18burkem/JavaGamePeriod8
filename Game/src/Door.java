import java.io.File;

public class Door extends Tile {

	private File room;
	private int key;
	
	
	public Door(String imgLocation, boolean isLocked, File nextRoom, int key) {
		super(imgLocation, !isLocked);
		this.room = nextRoom;
	}
	
	public void setRoomFile(File room){
		this.room = room;
	}
	public File getRoomFile(){
		return room;
	}
	public int getKey(){
		return key;
	}
	public void setKey(int key){
		this.key = key;
	}
	public String toString(){
		return "Leads to: " + room;
	}

	
	public static void main(String[] args){
		Door a = new Door(null, true, new File("test"), 4);
		System.out.println(a);
	}
	
}
