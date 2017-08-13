import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelBuilder extends JFrame {

	private JPanel contentPane;
	private int currentTile;
	private int currentCharacter;
	private HashSet<Point> selectedTiles = new HashSet<Point>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilder frame = new LevelBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelBuilder() {
		
		ArrayList<Tile> tileList = new ArrayList<Tile>();
		tileList.add(new Tile("resources/Images/g.png", true, null));
		tileList.add(new Tile("resources/Images/w.png", false, null));
		tileList.add(new Tile("resources/Images/d.png", true, null));
		tileList.add(new Tile("resources/Images/wa.png", false, null));
		tileList.add(new Tile("resources/Images/s.png", true, null));
		tileList.add(new Door("resources/Images/door"+true+".png", true, null, new File("resources/Rooms/blank.txt")));
		tileList.add(new Door("resources/Images/door"+false+".png", false, null, new File("resources/Rooms/blank.txt")));

		ArrayList<Character> characterList = new ArrayList<Character>();
		characterList.add(new RandWalker(null));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 805, 879);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel middlePane = new JPanel();
		contentPane.add(middlePane, BorderLayout.CENTER);
		middlePane.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		JButton nextTile = new JButton("Next Tile");
		JLabel tileName = new JLabel(tileList.get(currentTile%tileList.size()).toString());
		JTextField doorLocation = new JTextField("resources/Rooms/blank.txt");
		nextTile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentTile++;
				tileName.setText(tileList.get(currentTile%tileList.size()).toString());
			}
		});
		doorLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tileList.remove(tileList.size()-1);tileList.remove(tileList.size()-2);
				tileList.add(new Door("resources/Images/door"+true+".png", true, null, new File(doorLocation.getText())));
				tileList.add(new Door("resources/Images/door"+false+".png", false, null, new File(doorLocation.getText())));
			}
		});
		buttonPanel.add(nextTile);
		buttonPanel.add(tileName);
		buttonPanel.add(doorLocation);
		
		JPanel buttonPanel2 = new JPanel();
		middlePane.add(buttonPanel2, BorderLayout.SOUTH);
		JButton nextCharacter = new JButton("Next Character");
		JLabel characterName = new JLabel(characterList.get(currentCharacter%characterList.size()).toString());
		JTextField characterLocation = new JTextField("300 300");
		nextCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentCharacter++;
				characterName.setText(characterList.get(currentCharacter%characterList.size()).toString());
			}
		});
		characterLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}
		});
		buttonPanel2.add(nextCharacter);
		buttonPanel2.add(characterName);
		buttonPanel2.add(characterLocation);
		
		RoomPanel roomPanel = new RoomPanel();
		roomPanel.loadRoom(new File("resources/Rooms/blank.txt"));
		middlePane.add(roomPanel, BorderLayout.CENTER);
		roomPanel.repaint();
		roomPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				roomPanel.setTile(arg0.getY()/Tile.TILE_SIZE, arg0.getX()/Tile.TILE_SIZE, tileList.get(currentTile%tileList.size()));
				repaint();
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				for(Point p: selectedTiles){
					roomPanel.setTile(p.y, p.x, tileList.get(currentTile%tileList.size()));
				}
				selectedTiles.clear();
				repaint();
			}
		});
		roomPanel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				selectedTiles.add(new Point(arg0.getX()/Tile.TILE_SIZE, arg0.getY()/Tile.TILE_SIZE));
			}
			
		});
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		JLabel folderReminder = new JLabel("Folder:");
		topPanel.add(folderReminder);
		JTextField folder = new JTextField("resources/Rooms/Generated/");
		topPanel.add(folder);
		JLabel nameReminder = new JLabel("Name:");
		topPanel.add(nameReminder);
		JTextField name = new JTextField("no .txt required");
		topPanel.add(name);
		JButton saveRoom = new JButton("Save Room");
		topPanel.add(saveRoom);
		
		saveRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PrintWriter writer = new PrintWriter(folder.getText()+name.getText()+".txt", "UTF-8");
					for(int row = 0; row < Room.SIDE_LENGTH;row++){
						for(int col = 0; col < Room.SIDE_LENGTH;col++){
							if(!roomPanel.getRoom().getTile(col, row).getTileID().contains("door"))
								writer.println(roomPanel.getRoom().getTile(col, row).getTileID());
							else {
								writer.println("door");
								writer.println(roomPanel.getRoom().getTile(col, row).getTileID().substring(4));
								writer.println(((Door) (roomPanel.getRoom().getTile(col, row))).getNextRoom().toString());
							}
						}
					}
					writer.close();
				} catch (FileNotFoundException | UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
