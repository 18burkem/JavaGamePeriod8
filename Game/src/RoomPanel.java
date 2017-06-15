import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RoomPanel extends JPanel {
	private Room currentRoom;

	public void loadRoom(File f) {
		currentRoom = new Room(f, 8, 8, Display.player);
	}

	public Room getRoom(){
		return currentRoom;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				try {
					g2.drawImage(ImageIO.read(new File(currentRoom.getTile(row, col).getImageLocation())), null,
							row * 100, col * 100);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			g2.drawImage(ImageIO.read(new File(currentRoom.getPlayer().getImageLocation())), null,
					currentRoom.getPlayer().getHitbox().x, currentRoom.getPlayer().getHitbox().y );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
