import java.io.File;

public class Tile {
	public static final int TILE_SIZE = 100;
	
	private boolean isWalkable;
	private String imgLocation;
	private Hitbox h;

	public Tile(String imgLocation, boolean isWalkable, Hitbox h) {
		this.imgLocation = imgLocation;
		this.isWalkable = isWalkable;
		this.h = h;
	}

	public String getImageLocation() {
		return this.imgLocation;
	}
	
	public String getTileID() {
		return imgLocation.substring(imgLocation.lastIndexOf('/')+1, imgLocation.length()-4);
	}

	public void setImageLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}
	
	public String toString(){
		return "Walkable: " + isWalkable + ", Image Location: " + imgLocation + ", Hitbox: " + h;
	}
	
	public void setWalkable(boolean isWalkable){
		this.isWalkable = isWalkable;
	}
	
	public boolean isWalkable(){
		return isWalkable;
	}

	
}
