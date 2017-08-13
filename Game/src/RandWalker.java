
public class RandWalker extends Enemy {

	private int turnCounter = 0;

	public RandWalker(Hitbox h) {
		super(h, 1, 3, "resources/Images/rand_walker.png");
		randomizeDirection();
	}

	public void randomizeDirection() {
		int x = (int) (Math.round(Math.random()) + 1);
		if (Math.random() > .5)
			x *= -1;
		setDirection(x);
	}

	public void move(Room r) {
		turnCounter++;
		if(turnCounter > 20){
			randomizeDirection();
			turnCounter = 0;
		}
		if (canWalk(r)) {
			switch (direction) {
			case NORTH:
				hitbox.move(0, -speed);
				break;
			case EAST:
				hitbox.move(speed, 0);
				break;
			case SOUTH:
				hitbox.move(0, speed);
				break;
			case WEST:
				hitbox.move(-speed, 0);
				break;
			}
		} else {
			switch (direction) {
			case NORTH:
				hitbox.move(0, speed);
				break;
			case EAST:
				hitbox.move(-speed, 0);
				break;
			case SOUTH:
				hitbox.move(0, -speed);
				break;
			case WEST:
				hitbox.move(speed, 0);
				break;

			}
			direction = 0;
		}
		
	}

}