import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JButton relative = new JButton();

	/**
	 * Launch the application.
	 */
	public static Home frame = new Home();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public void Search(String Name)
	{
		//JFrame frame = new JFrame("Results");  
		JPanel panel = new JPanel();
		panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ));
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
        JScrollPane jsp=new JScrollPane(panel,v,h);
        jsp.setBounds(relative.getLocation().x, relative.getLocation().y,500, 250);
		for(int i=0;i<20;i++)
		{
			 JButton result1 = new JButton(Name);
			 result1.setOpaque(false);
			 result1.setContentAreaFilled(false);
			 result1.setBorderPainted(false);
			 panel.add(result1);
			
			 result1.addActionListener(new ActionListener()
			 {  
					 public void actionPerformed(ActionEvent e)
					 {  
						 UserProfile up=new UserProfile(new User("Salma Tharwat ","Salma123","1235"));
						 up.setVisible(true);
						 Home.frame.dispose();
					 }  
			 }
			 ); 
		}
		     frame.getContentPane().add(jsp);
			//frame.setSize(500, 250 );  
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			frame.setVisible(true); 
		}
			
	
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 526);
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
		
		JLabel lblSearchBooks = new JLabel("Search:");
		lblSearchBooks.setForeground(Color.DARK_GRAY);
		lblSearchBooks.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblSearchBooks.setBounds(45, 155, 173, 39);
		contentPane.add(lblSearchBooks);
		
		textField = new JTextField();
		textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		textField.setBounds(126, 155, 377, 30);
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
		
		DefaultListModel<String> searchResults = new DefaultListModel<>();
		
		JButton button_1 = new JButton("My Books");
		button_1.setOpaque(false);
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(335, 70, 140, 39);
		contentPane.add(button_1);
		
		JButton button_3 = new JButton("Friends");
		button_3.setOpaque(false);
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(458, 68, 140, 42);
		contentPane.add(button_3);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile up=new UserProfile(new User("Ahmed","Ahmd","1234"));
				up.setVisible(true);
				frame.dispose();
			}
		});
		btnMyProfile.setOpaque(false);
		btnMyProfile.setForeground(Color.DARK_GRAY);
		btnMyProfile.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnMyProfile.setContentAreaFilled(false);
		btnMyProfile.setBorderPainted(false);
		btnMyProfile.setBounds(585, 68, 140, 42);
		contentPane.add(btnMyProfile);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Valid Data ");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Search(textField.getText());
			}
		});
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/find.jpg")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(0, 344, 140, 106);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(125, 187, 127, 39);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookbtn.png")));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(570, 151, 55, 39);
		contentPane.add(btnNewButton_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usersbtn.jpg")));
		button_2.setBorderPainted(false);
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(513, 151, 49, 39);
		contentPane.add(button_2);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/articlebtn.png")));
		button_4.setBorderPainted(false);
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setBounds(624, 151, 49, 39);
		contentPane.add(button_4);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/all.png")));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBounds(683, 151, 49, 34);
		contentPane.add(btnNewButton_2);
		
	    
	    relative.setBorderPainted(false);
		relative.setFocusPainted(false);
		relative.setContentAreaFilled(false);
		relative.setBounds(182, 225, 89, 23);
		contentPane.add(relative);
	}
}
