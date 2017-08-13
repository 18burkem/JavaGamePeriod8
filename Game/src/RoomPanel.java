import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RoomPanel extends JPanel {
	private Room currentRoom;

	public RoomPanel() {

	}

	public void loadRoom(File f) {
		currentRoom = new Room(f, Room.SIDE_LENGTH, Room.SIDE_LENGTH);
	}

	public Room getRoom() {
		return currentRoom;
	}
	
	public void setTile(int row, int col, Tile t){
		currentRoom.setTile(row, col, t);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		for (int row = 0; row < Room.SIDE_LENGTH; row++) {
			for (int col = 0; col < Room.SIDE_LENGTH; col++) {

				try {
					g2.drawImage(ImageIO.read(new File(currentRoom.getTile(col, row).getImageLocation())), null,
							row * Tile.TILE_SIZE, col * Tile.TILE_SIZE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(Display.player != null){
			try {
				g2.drawImage(ImageIO.read(new File("resources/Images/player.png")), null, Display.player.getX(),
						Display.player.getY());
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (Tile t : Display.player.getTouchingTiles(currentRoom)) {
				if (t instanceof Door && !((Door) t).isLocked()) {
					loadRoom(((Door) t).getNextRoom());
					if (Display.player.getHitbox().getY() < 300) {
						Display.player.place(420, 620);
						break;
					}
					if (Display.player.getHitbox().getX() > 600) {
						Display.player.place(120, 420);
						break;
					}
					if (Display.player.getHitbox().getX() < 300) {
						Display.player.place(620, 420);
						break;
					}
					if (Display.player.getHitbox().getY() > 600) {
						Display.player.place(420, 120);
						break;
					}
					// note: with current solution, break statements are necessary
					// because two corners touching the same door will cause the
					// player to be moved to the wrong side of the map
				}
			}
		}
		for (Character c : currentRoom.getCharacters()) {
			if (c instanceof RandWalker) {
				try {
					
					g2.drawImage(ImageIO.read(c.getImg()), null, c.getX(), c.getY());

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// g2.drawRect(c.getX(), c.getY(), 40, 40);

			// String speach = c.update(1, Character.NORTH);
			// try {
			// g2.drawImage(ImageIO.read(c.getImg()), null, c.getX(), c.getY());
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			// if(speach != null)g2.drawString(speach, c.getX(), c.getY()+10);
			// }
			// }
		}
	}
}