import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Panel;

public class SUperTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtResourcesrooms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SUperTest frame = new SUperTest();
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
	public SUperTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		txtResourcesrooms = new JTextField();
		txtResourcesrooms.setText("resources/Rooms");
		panel.add(txtResourcesrooms);
		txtResourcesrooms.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		panel.add(btnSave);
		
		Panel panel_1 = new Panel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		Panel panel_2 = new Panel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		Panel panel_3 = new Panel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);
	}

}
