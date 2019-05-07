import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JInternalFrame;

public class UserProfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile frame = new UserProfile();
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
	public UserProfile() {
		User U1= new User("Ahmed","Ahmed_123","12345");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 214, 106);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		btnNewButton.setBounds(212, 70, 115, 33);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		contentPane.add(btnNewButton);
		
		JButton btnMyBooks = new JButton("My Books");
		btnMyBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				 DefaultListModel<String> l1 = new DefaultListModel<>();  
		          l1.addElement("The Secret");  
		          l1.addElement("History Of Egypt");
		          l1.addElement("The Fault In Our Stars");
		             JList<String> list = new JList<>(l1);
				   JFrame f= new JFrame("My Books Pannel");    
			        JPanel panel=new JPanel();  
			        panel.setSize(400,400);    
			        panel.setBackground(Color.gray);  
			        JButton b1=new JButton("Back");     
			        b1.setBounds(50,100,80,30);       
			        b1.setOpaque(false);
					b1.setContentAreaFilled(false);
					b1.setBorderPainted(false);
			        panel.add(b1);
			        panel.add(list); 
			        f.getContentPane().add(panel);  
			                f.setSize(400,400);    
			                f.getContentPane().setLayout(null);    
			                f.setVisible(true);    
			}
		});
		btnMyBooks.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		btnMyBooks.setOpaque(false);
		btnMyBooks.setContentAreaFilled(false);
		btnMyBooks.setBorderPainted(false);
		btnMyBooks.setBounds(295, 67, 140, 39);
		contentPane.add(btnMyBooks);
		
		JButton btnFindBooks = new JButton("Find Books");
		btnFindBooks.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		btnFindBooks.setOpaque(false);
		btnFindBooks.setContentAreaFilled(false);
		btnFindBooks.setBorderPainted(false);
		btnFindBooks.setBounds(409, 67, 150, 39);
		contentPane.add(btnFindBooks);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		btnFriends.setOpaque(false);
		btnFriends.setContentAreaFilled(false);
		btnFriends.setBorderPainted(false);
		btnFriends.setBounds(519, 65, 140, 42);
		contentPane.add(btnFriends);
		
		JComboBox comboBox = new JComboBox();
		comboBox .setOpaque(false);
		comboBox.addItem("Explore");
		 comboBox.addItem("Action and adventure");  
		 comboBox.addItem("Art");  
		 comboBox.addItem("Drama");  
		 comboBox.addItem("Children"); 
		 comboBox.addItem("Biography");
		 comboBox.addItem("Health");
		 comboBox.addItem("Fantasy");
		 comboBox.addItem("Grapic Novel");
		 comboBox.addItem("Romance");
		 comboBox.addItem("History");
		comboBox .setEditable(true);
		comboBox.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		comboBox.setBounds(646, 70, 195, 32);
		contentPane.add(comboBox);
		
		JLabel welcomelabel = new JLabel("Welcome  " + U1.Name);
		welcomelabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		welcomelabel.setBounds(10, 125, 150, 33);
		contentPane.add(welcomelabel);
		
		JButton btnNewButton_1 = new JButton("Inbox");
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(22, 184, 99, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnSignout = new JButton("Sign Out");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{   
			    contentPane.setVisible(false);
				The_Reader reader=new The_Reader();
				reader.main(null);
			}
		});
		btnSignout.setOpaque(false);
		btnSignout.setContentAreaFilled(false);
		btnSignout.setBorderPainted(false);
		btnSignout.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSignout.setBounds(10, 256, 123, 39);
		contentPane.add(btnSignout);
		
		JButton btnNewButton_2 = new JButton("Go !");
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		btnNewButton_2.setBounds(742, 113, 99, 33);
		contentPane.add(btnNewButton_2);
		
		
		
		
		
	
		
		
	}
}
