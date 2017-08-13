
public class Location {
	private double x;
	private double y;

	public Location(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString(){
		return "X: " + x + " Y: " + y;
	}
	
	
}
