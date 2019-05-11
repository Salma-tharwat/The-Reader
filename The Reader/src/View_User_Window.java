import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_User_Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static View_User_Window frame = new View_User_Window(new User("Ahmed","Ahmd","1234"));
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					  
					  frame.setVisible(true);
					
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View_User_Window(User u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 497);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 261, 106);
		contentPane.add(lblNewLabel);
		
		JButton btn_add = new JButton("New button");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				for(int i=0;i<Database.getInstance().users.size();i++)
				{
					if(Database.getInstance().users.get(i).equals(The_Reader.LoggedInUser))
					{
						Database.getInstance().users.get(i).followers.add(u);
						Database.getInstance().addUserFollower(u,Database.getInstance().users.get(i));
					}
				}
				
				JOptionPane.showMessageDialog(null,"You Followed "+u.name+" Sucessfully");
				
			}
		});
		btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.jpg")));
		btn_add.setBorderPainted(false);
		btn_add.setFocusPainted(false);
		btn_add.setContentAreaFilled(false);
		btn_add.setBounds(664, 0, 106, 93);
		contentPane.add(btn_add);
		
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h=new Home();
				h.setVisible(true);
			    frame.dispose();
				
			}
		});
		button.setOpaque(false);
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(234, 77, 115, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("My Books");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				UserProfile.Display_Read_Books(The_Reader.LoggedInUser);
			}
		});
		button_1.setOpaque(false);
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(347, 74, 140, 39);
		contentPane.add(button_1);
		
		JButton button_3 = new JButton("My Profile");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				UserProfile up=new UserProfile(The_Reader.LoggedInUser);
				up.setVisible(true);
				frame.dispose();
			}
		});
		button_3.setOpaque(false);
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(487, 72, 140, 42);
		contentPane.add(button_3);
		
		JLabel label = new JLabel("Name:");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(10, 137, 102, 33);
		contentPane.add(label);
		
		textField = new JTextField(u.name);
		textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(79, 137, 233, 33);
		contentPane.add(textField);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				JOptionPane.showMessageDialog(null,u.followers.size());
			}
		});
		button_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/searchfriends.png")));
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		button_4.setBounds(10, 221, 233, 226);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/searchbooks.jpg")));
		button_5.setFocusPainted(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setBounds(266, 221, 233, 226);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6 .setIcon(new javax.swing.ImageIcon(getClass().getResource("/articles.png")));
		button_6.setFocusPainted(false);
		button_6.setContentAreaFilled(false);
		button_6.setBorderPainted(false);
		button_6.setBounds(504, 221, 266, 226);
		contentPane.add(button_6);
	}
}
