//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//public class TestDisplay extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TestDisplay frame = new TestDisplay();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public TestDisplay() {
//		Room testRoom = new Room(new File("resources/resources/testroom1.txt"),3,3);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel(){
//			public void paint(Graphics g){
//				Graphics2D g2 = (Graphics2D)g;
//				for(int row = 0;row<3;row++){
//					for(int col = 0;col<3;col++){
//						System.out.println(testRoom.getTile(row, col).getImageLocation());
//						try {
//							g2.drawImage(ImageIO.read(new File(testRoom.getTile(row, col).getImageLocation())), null, row*this.getHeight()/3, col*this.getWidth());
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//		};
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		
//		
//	}
//
//}
