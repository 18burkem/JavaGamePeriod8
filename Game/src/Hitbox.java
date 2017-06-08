import java.awt.Point;
import java.awt.Rectangle;

public class Hitbox extends Rectangle {

	public Hitbox(Rectangle rec) {
		super(rec);
	}

	public Hitbox(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public Point getCenter() {
		return new Point((int) super.getCenterX(), (int) super.getCenterY());
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
	}

}
