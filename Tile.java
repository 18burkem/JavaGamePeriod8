import java.io.File;

public class Tile {
	private boolean isWalkable;
	private String imgLocation;

	public Tile(String imgLocation, boolean isWalkable) {
		this.imgLocation = imgLocation;
		this.isWalkable = isWalkable;
	}

	public String getImageLocation() {
		return this.imgLocation;

	}

	public void setImageLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}
	
	public String toString(){
		return "Walkable: " + isWalkable + ", Image Location: " + imgLocation;
	}

	
}
