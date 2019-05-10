import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static StartPage frame = new StartPage();
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
	public StartPage()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 488);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image img= new ImageIcon(this.getClass().getResource("/start.png")).getImage();
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Admin_Panel a=new Admin_Panel();
				a.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setFont(new Font("Vladimir Script", Font.BOLD | Font.ITALIC, 60));
		btnNewButton.setBounds(10, 147, 268, 53);
		contentPane.add(btnNewButton);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				The_Reader login=new The_Reader();
				login.frame.setVisible(true);
				frame.dispose();
				
			}
		});
		btnUser.setForeground(Color.GRAY);
		btnUser.setFont(new Font("Vladimir Script", Font.BOLD | Font.ITALIC, 60));
		btnUser.setFocusPainted(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(false);
		btnUser.setBounds(-15, 255, 268, 81);
		contentPane.add(btnUser);
		
		JLabel lblNewLabel_1 = new JLabel("The Reader");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Vladimir Script", Font.BOLD | Font.ITALIC, 70));
		lblNewLabel_1.setBounds(175, 37, 434, 99);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(34, 11, 817, 427);
		contentPane.add(lblNewLabel);
	}
}
