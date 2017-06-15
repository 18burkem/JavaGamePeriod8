import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RoomPanel extends JPanel {
	private Room currentRoom;
	private Player player = new Player("kirk lazurus", 500, 500, 6, "resources/Images/Player.png");

	public RoomPanel(){
		
	}
	
	public void loadRoom(File f) {
		currentRoom = new Room(f, 8, 8);
	}

	public Room getRoom(){
		return currentRoom;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
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
		for(Character c: currentRoom.getCharacters()){
			String speach = c.update(1, Character.NORTH);
			try {
			g2.drawImage(ImageIO.read(c.getImg()), null, c.getX(), c.getY());
			} catch (IOException e) {
					e.printStackTrace();
			}
			if(speach != null)g2.drawString(speach, c.getX(), c.getY()+10);
		}
	}

}