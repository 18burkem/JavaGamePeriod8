import java.awt.Rectangle;

//TODO: switch everything over to work with rectangles and points! Also double check design doc
public class Hitbox extends Rectangle{
	private Location location;
	
	
	public Hitbox(Rectangle d, Location l){
		super(d);
		location = l;
	}
	
	public Hitbox(int width, int height, double x, double y){
		super(width, height);
		location = new Location(x, y);
	}
	
	
	public void setLocation(Location location){
		this.location = location;
	}
	public Location getCenter(){
		return new Location((double)super.getWidth() / 2 + location.getX(),(double)super.getHeight() / 2 + location.getY());
	}
	
	//TODO fix the following 2 methods
	public double distanceFrom(Hitbox h){
		return Math.sqrt(((getCenter().getX() - h.getCenter().getX()) * (getCenter().getX() - h.getCenter().getX())) +   ((getCenter().getY() - h.getCenter().getY()) * (getCenter().getY() - h.getCenter().getY())));
	}
	public boolean isTouching(Hitbox h){
		return super.intersects(h);
	}
	
	
	
	
	public String toString(){
		return "Width: " + super.getWidth() + " Height: " + super.getHeight() + " X: " + location.getX() + " Y: " + location.getY();
	}
	
	
	public static void main(String [] args){
		Hitbox h = new Hitbox(1, 1, 10.0, 0);
		System.out.println(h);
		System.out.println(h.getCenter());
		Hitbox h2 = new Hitbox(1, 1, 10, 20);
		System.out.println(h.distanceFrom(h2));
		System.out.println(h.isTouching(h2));
	}
	
}
