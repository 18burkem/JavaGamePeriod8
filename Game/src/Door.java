import java.io.File;

public class Door extends Tile {

	private boolean isLocked;
	private File nextRoom;
	
	public Door(String imgLocation, boolean isLocked, Hitbox h, File nextRoom) {
		super(imgLocation, !isLocked, h);
		this.isLocked = isLocked;
		this.nextRoom = nextRoom;
	}
	
	public boolean isLocked(){
		return isLocked;
	}
	
	public void unlock(){
		isLocked = false;
		super.setWalkable(true);
	}
	
	public File getNextRoom(){
		return nextRoom;
	}
	
	public void setNextRoom(File f){
		this.nextRoom = f;
	}

}
