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
		player = new Player("TEST", 150, 500, 6, "resources/Images/player.png");
		frame = new JFrame();
		frame.setBounds(300, 50, 800, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		JPanel panel = new JPanel(){
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
		
		panel.setPreferredSize(new Dimension(frame.getWidth(), 50));
		panel.repaint();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		
		RoomPanel roomPanel = new RoomPanel();
		roomPanel.loadRoom(new File("resources/testroom.txt"));
		roomPanel.repaint();
		
		frame.getContentPane().add(roomPanel, BorderLayout.CENTER);
		
		frame.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
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
		
		System.out.println(roomPanel.getRoom().getTile(3,4).getHitbox());
		
		Timer t = new Timer(17, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				roomPanel.repaint();
				player.move();
			}
			
		});
		t.start();
	}

}
