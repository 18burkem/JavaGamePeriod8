import java.io.File;

public class Tile {
	private boolean isWalkable;
	private String imgLocation;
	private Hitbox h;
	public static final int TILESIZE = 100;
	
	public Tile(String imgLocation, boolean isWalkable, Hitbox hitbox) {
		this.imgLocation = imgLocation;
		this.isWalkable = isWalkable;
		h = hitbox;
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
	
	public void setWalkable(boolean isWalkable){
		this.isWalkable = isWalkable;
	}
	
	public boolean isWalkable(){
		return isWalkable;
	}
	
	public Hitbox getHitbox(){
		return h;
	}
	
}
