import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SignUp extends JFrame
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static SignUp frame = new SignUp();
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
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
	public SignUp()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 435);
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

		JButton SignUpButtn = new JButton("SignUp");
		SignUpButtn.setForeground(Color.DARK_GRAY);
		SignUpButtn.setFocusPainted(false);
		SignUpButtn.setContentAreaFilled(false);
		SignUpButtn.setBorderPainted(false);
		SignUpButtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(passwordField.getText().equals("") || passwordField_1.getText().equals("") || textField.getText().equals("") || textField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Valid Data ");
					SignUp sp=new SignUp();
					sp.setVisible(true);
					frame.dispose();
				}
				else if(!passwordField.getText().equals(passwordField_1.getText()))
				{
					JOptionPane.showMessageDialog(null, "passwords does not match ");
					SignUp sp=new SignUp();
					sp.setVisible(true);
					frame.dispose();
				}
				else
				{
					User u=new User(textField.getText(),textField_1.getText(),passwordField.getText().toString());
					boolean added=Database.getInstance().addUser(u);
					Database.getInstance().users.add(u);
					if(added)
					{
						JOptionPane.showMessageDialog(null, "Welcome to The Reader !! ..");
				The_Reader.LoggedInUser=u;
				UserProfile up=new UserProfile(u);
				up.setVisible(true);
				frame.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "try again");
					}
				}
				
				
			}
		});
		SignUpButtn.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		SignUpButtn.setBounds(412, 35, 128, 35);
		contentPane.add(SignUpButtn);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(25, 143, 106, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Traditional Arabic", Font.PLAIN, 22));
		lblUserName.setBounds(25, 207, 106, 40);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Traditional Arabic", Font.PLAIN, 22));
		lblPassword.setBounds(25, 264, 106, 40);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Traditional Arabic", Font.PLAIN, 22));
		lblConfirmPassword.setBounds(25, 317, 189, 40);
		contentPane.add(lblConfirmPassword);
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		textField.setBounds(134, 150, 274, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(134, 207, 274, 29);
		contentPane.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		passwordField.setBounds(134, 272, 274, 29);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		passwordField_1.setBounds(194, 324, 214, 29);
		contentPane.add(passwordField_1);
		
	}
}
