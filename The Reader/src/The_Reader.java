import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class The_Reader {

	public JFrame frame;
	private JTextField usernametxt;
	private JPasswordField Passwordtxt;
	public static User LoggedInUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					The_Reader window = new The_Reader();
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
	public The_Reader() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 628, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBackground(SystemColor.info);
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 0, 284, 183);
		frame.getContentPane().add(label);
		
		JButton login = new JButton("Login");
	      login.addActionListener(new ActionListener()
	      {
			public void actionPerformed(ActionEvent e)
			{
				boolean loggedin=false;
				for(int i=0;i<Database.getInstance().users.size();i++)
				{
					if(usernametxt.getText().equals(Database.getInstance().users.get(i).userName) && Passwordtxt.getText().equals(Database.getInstance().users.get(i).password))
							{
						        LoggedInUser=Database.getInstance().users.get(i);
						       JOptionPane.showMessageDialog(null, "Logged In Sucessfully !!");
						       loggedin=true;
						       frame.dispose();
				              UserProfile  sup=new UserProfile(LoggedInUser);
				               sup.setVisible(true);
				               
				               break;
							}
				}
				if(!loggedin)
				{
					JOptionPane.showMessageDialog(null, "UserName or Password Incorrect");
				}
			}
	      });
		login.setForeground(Color.DARK_GRAY);
		login.setFocusPainted(false);
		login.setContentAreaFilled(false);
		login.setBorderPainted(false);
		login.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		login.setBounds(294, 25, 123, 42);
		frame.getContentPane().add(login);
		
		JButton signup = new JButton("SignUp");
	    signup.setFocusPainted(false);
		signup.setContentAreaFilled(false);
		signup.setBorderPainted(false);
		signup.setForeground(Color.DARK_GRAY);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SignUp sup=new SignUp();
				sup.setVisible(true);
			}
		});
		signup.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		signup.setBounds(454, 25, 123, 42);
		frame.getContentPane().add(signup);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.PLAIN, 22));
		lblNewLabel.setBounds(61, 182, 139, 42);
		frame.getContentPane().add(lblNewLabel);
		
		usernametxt = new JTextField();
		usernametxt.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		usernametxt.setBounds(172, 182, 184, 33);
		frame.getContentPane().add(usernametxt);
		usernametxt.setColumns(10);
		
		JLabel passwordlbl = new JLabel("Password:");
		passwordlbl.setFont(new Font("Traditional Arabic", Font.PLAIN, 22));
		passwordlbl.setBounds(61, 272, 102, 27);
		frame.getContentPane().add(passwordlbl);
		
		Passwordtxt = new JPasswordField();
		Passwordtxt.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		Passwordtxt.setBounds(172, 266, 184, 33);
		frame.getContentPane().add(Passwordtxt);
	}
}
