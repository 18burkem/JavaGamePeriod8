import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Display {

	private JFrame frame;
	public static Player player;
	public static int dmgDelay = 0;
	//TODO: build dmgDelay into player
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		player = new Player(new Hitbox(420, 420, 60, 60), 6, Player.DEFAULT_PLAYER_SPEED);
		frame = new JFrame();
		frame.setBounds(300, 50, 805, 879);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		JPanel healthPanel = new JPanel(){
			public void paint(Graphics g){
				Graphics2D g2 = (Graphics2D)g;
				try {
					g2.drawImage(ImageIO.read(new File("resources/Images/health_" + player.getHealth() +  ".png")), null, 25, 10);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Problem reading in health images");
				}
			}
		};
		healthPanel.setOpaque(false);
		healthPanel.setBackground(new Color(255, 255, 255));
		healthPanel.setPreferredSize(new Dimension(frame.getWidth(), 50));
		healthPanel.repaint();
		frame.getContentPane().add(healthPanel, BorderLayout.NORTH);
		
		
		RoomPanel roomPanel = new RoomPanel();
		roomPanel.loadRoom(new File("resources/Rooms/TestRooms/room_tl.txt"));
		
		roomPanel.repaint();
		
		frame.getContentPane().add(roomPanel, BorderLayout.CENTER);
		
		frame.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_DOWN){
					player.setDirection(Character.SOUTH);
				}
				else if(arg0.getKeyCode() == KeyEvent.VK_UP){
					player.setDirection(Character.NORTH);
				}
				else if(arg0.getKeyCode() == KeyEvent.VK_LEFT){
					player.setDirection(Character.WEST);
				}
				else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT){
					player.setDirection(Character.EAST);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				player.setDirection(0);
				
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
	
			}
			
		});
		
		Timer t = new Timer(17, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(dmgDelay != 0) dmgDelay--;
				player.move(roomPanel.getRoom());
				for(Character c : roomPanel.getRoom().getCharacters()){ 
					c.move(roomPanel.getRoom());
					if(c instanceof RandWalker && dmgDelay == 0 && c.getHitbox().isTouching(player.getHitbox())){
						player.recieveDamage(1);
						dmgDelay = 25;
					}
				}
				roomPanel.repaint();
				healthPanel.repaint();
			}
			
		});
		t.start();
	}

}
