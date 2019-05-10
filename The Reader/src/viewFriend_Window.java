import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class viewFriend_Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewFriend_Window frame = new viewFriend_Window(new User("Ahmed","Ahmd","1234"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void displayUser(User U2)
	{
		
	}

	/**
	 * Create the frame.
	 */
	public viewFriend_Window(User u2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 244, 106);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Home");
		button.setOpaque(false);
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(219, 76, 115, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("My Books");
		button_1.setOpaque(false);
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(311, 73, 140, 39);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Find Books");
		button_2.setOpaque(false);
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(432, 73, 150, 39);
		contentPane.add(button_2);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserProfile up=new UserProfile(UserProfile.u);
				up.setVisible(true);
			}
		});
		btnMyProfile.setOpaque(false);
		btnMyProfile.setForeground(Color.DARK_GRAY);
		btnMyProfile.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnMyProfile.setContentAreaFilled(false);
		btnMyProfile.setBorderPainted(false);
		btnMyProfile.setBounds(559, 71, 140, 42);
		contentPane.add(btnMyProfile);
		
		JButton btn_unfollow = new JButton("");
		btn_unfollow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png")));
		btn_unfollow.setBorderPainted(false);
		btn_unfollow.setFocusPainted(false);
		btn_unfollow.setContentAreaFilled(false);
		btn_unfollow.setBounds(728, 0, 97, 78);
		contentPane.add(btn_unfollow);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 140, 102, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField(u2.Name);
		textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		textField.setBounds(77, 139, 233, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn_SearchFriends = new JButton("");
		btn_SearchFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile.Display_friends(u2);
			}
		});
		btn_SearchFriends .setIcon(new javax.swing.ImageIcon(getClass().getResource("/searchfriends.png")));
		btn_SearchFriends .setBorderPainted(false);
		btn_SearchFriends .setFocusPainted(false);
		btn_SearchFriends .setContentAreaFilled(false);
		btn_SearchFriends .setBounds(0, 211, 233, 226);
		contentPane.add(btn_SearchFriends );
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile.Display_Read_Books(u2);
			}
		});
		button_3 .setIcon(new javax.swing.ImageIcon(getClass().getResource("/searchbooks.jpg")));
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(288, 211, 233, 226);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile.Display_Created_Articles(u2);
			}
		});
		button_4 .setIcon(new javax.swing.ImageIcon(getClass().getResource("/articles.png")));
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBounds(559, 211, 266, 226);
		contentPane.add(button_4);
		UserProfile.Display_friends(u2);
	
		
	
	}
}
