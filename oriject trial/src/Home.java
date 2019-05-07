import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 489);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 252, 106);
		contentPane.add(lblNewLabel);
		
		JLabel lblSearchBooks = new JLabel("Search Books:");
		lblSearchBooks.setForeground(Color.DARK_GRAY);
		lblSearchBooks.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblSearchBooks.setBounds(45, 155, 173, 39);
		contentPane.add(lblSearchBooks);
		
		textField = new JTextField();
		textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		textField.setBounds(183, 155, 320, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Home");
		button.setOpaque(false);
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(229, 73, 115, 33);
		contentPane.add(button);
		
		DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("Action and adventure");  
        l1.addElement("Art");  
        l1.addElement("Drama");  
        l1.addElement("Children"); 
        l1.addElement("Biography");
        l1.addElement("Health");
        l1.addElement("Fantasy");
        l1.addElement("Grapic Novel");
        l1.addElement("Romance");
        l1.addElement("History");
      JList<String> list = new JList<>(l1);
		list.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		list.setBounds(587, 172, 209, 267);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		contentPane.add(list);
		
		JButton button_1 = new JButton("My Books");
		button_1.setOpaque(false);
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(335, 70, 140, 39);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Find Books");
		button_2.setOpaque(false);
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(467, 73, 150, 39);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Friends");
		button_3.setOpaque(false);
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(584, 71, 140, 42);
		contentPane.add(button_3);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.setOpaque(false);
		btnMyProfile.setForeground(Color.DARK_GRAY);
		btnMyProfile.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnMyProfile.setContentAreaFilled(false);
		btnMyProfile.setBorderPainted(false);
		btnMyProfile.setBounds(700, 68, 140, 42);
		contentPane.add(btnMyProfile);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(0, 228, 218, 222);
		contentPane.add(btnNewButton);
	}
}
