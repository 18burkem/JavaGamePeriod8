import java.io.File;

public class Door extends Tile {

	private boolean isLocked;
	
	public Door(String imgLocation, boolean isLocked, File nextRoom, Hitbox h) {
		super(imgLocation, !isLocked, h);
		this.isLocked = isLocked;
	}
	
	public boolean isLocked(){
		return isLocked;
	}
	
	public void unlock(){
		isLocked = false;
		super.setWalkable(true);
	}

}