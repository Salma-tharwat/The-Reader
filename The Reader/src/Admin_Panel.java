import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Panel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Admin_Panel frame = new Admin_Panel();
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
	public Admin_Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 236, 106);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Panel");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 44));
		lblNewLabel_1.setBounds(333, 36, 421, 57);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Add_Book addb=new Add_Book();
				addb.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add book.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(38, 152, 242, 187);
		contentPane.add(btnNewButton);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		button_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add Category.jpg")));
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(514, 152, 242, 187);
		contentPane.add(button_1);
		
		JButton btn_1 = new JButton();
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				StartPage sp=new StartPage();
				sp.setVisible(true);
				frame.dispose();
			}
		});
		btn_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png")));
		btn_1.setFocusPainted(false);
		btn_1.setContentAreaFilled(false);
		btn_1.setBorderPainted(false);
		btn_1.setBounds(566, -27, 285, 187);
		contentPane.add(btn_1);
		
		 
		 
		 
		
	}
}
