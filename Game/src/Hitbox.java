import java.awt.Point;
import java.awt.Rectangle;

public class Hitbox extends Rectangle {

	
	public static final int NONE = 0;
	public static final int NORTH = 1;
	public static final int NORTHEAST = 2;
	public static final int EAST = 3;
	public static final int SOUTHEAST = 4;
	public static final int SOUTH = 5;
	public static final int SOUTHWEST = 6;
	public static final int WEST = 7;
	public static final int NORTHWEST = 8;
	
	
	public Hitbox(Rectangle rec) {
		super(rec);
	}

	public Hitbox(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public Point getCenter() {
		return new Point((int) super.getCenterX(), (int) super.getCenterY());
	}
	
	public int getIntX(){
		return super.x;
	}
	public int getIntY(){
		return super.y;
	}
	
	public void move(int deltaX, int deltaY){
		x += deltaX;
		y += deltaY;
	}

	public double distanceFrom(Hitbox h) {
		Rectangle r = super.intersection(h);
		return Math.sqrt(r.getHeight() * r.getHeight() + r.getWidth() * r.getWidth());
	}

	public boolean isTouching(Hitbox h) {
		return super.intersects(h);
	}

	public String toString() {
		return "Width: " + super.getWidth() + " Height: " + super.getHeight() + " X: " + getX() + " Y: " + getY();
	}

	public static void main(String[] args) {
		Hitbox h = new Hitbox(2, 0, 1, 3);
		System.out.println(h);
		System.out.println(h.getCenter());
		Hitbox h2 = new Hitbox(2, 3, 1, 5);
		System.out.println(h.distanceFrom(h2));
		System.out.println(h.isTouching(h2));
		System.out.println(h.getX());
		h.move(5, 0);
		System.out.println(h.getX());
	}

}
