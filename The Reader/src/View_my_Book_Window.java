import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
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
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;

public class View_my_Book_Window extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					java.sql.Date d=new java.sql.Date(2, 5, 2010);
					View_my_Book_Window frame = new View_my_Book_Window (new Book(1, "Champions", d, "Abo Treka", "", "Sports Book"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/////////////////////////////////
	///////////////////////// dummy data to test
	User u=new User("ahmed","ah123","1234");
	private JTextField Name;
	private JTextField Date;
	private JTextField Author;
	private JTextField Link;
	private JTextField textField_4;
	///////////////////////function that Display Book
	public void displayBook(Book b)
	{
		
		Name = new JTextField(b.name);
		Name.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 24));
		Name.setBounds(10, 139, 277, 29);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Date = new JTextField(b.datePublished.toString());
		Date.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		Date.setBounds(10, 245, 277, 33);
		contentPane.add(Date);
		Date.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Comments:");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(10, 344, 140, 33);
		contentPane.add(lblNewLabel_2);
		
	
		JLabel lblNewLabel_3 = new JLabel("Categories:");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(608, 141, 140, 24);
		contentPane.add(lblNewLabel_3);
		
		DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement(b.categories.get(0).name);
        JList<String> list = new JList<>(l1);
		list.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		list.setBounds(618, 168, 129, 168);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		contentPane.add(list);
		
		Author = new JTextField(b.author);
		Author.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		Author.setBounds(10, 189, 277, 33);
		contentPane.add(Author);
		Author.setColumns(10);
		
		Link = new JTextField(b.hyperlink);
		Link.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		Link.setBounds(322, 138, 247, 33);
		contentPane.add(Link);
		Link.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Description:");
		lblNewLabel_6.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setForeground(Color.DARK_GRAY);
		lblNewLabel_6.setBounds(10, 307, 140, 29);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField(b.description);
		textField_4.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		textField_4.setBounds(135, 303, 404, 37);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		
		
		
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
	public View_my_Book_Window(Book b)
	{
		b.categories.add(new Category("Sports"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 223, 106);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Home");
		button.setOpaque(false);
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(228, 73, 115, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("My Books");
		button_1.setOpaque(false);
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(325, 70, 140, 39);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Friends");
		button_2.setOpaque(false);
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(451, 68, 140, 42);
		contentPane.add(button_2);
		
		JButton btnMyProfie = new JButton("My Profie");
		btnMyProfie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile u=new UserProfile(new User("Ahmed","Ahmd","1234"));
				u.setVisible(true);
			}
		});
		btnMyProfie.setOpaque(false);
		btnMyProfie.setForeground(Color.DARK_GRAY);
		btnMyProfie.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnMyProfie.setContentAreaFilled(false);
		btnMyProfie.setBorderPainted(false);
		btnMyProfie.setBounds(558, 68, 140, 42);
		contentPane.add(btnMyProfie);
		displayBook(b);
		
		
	}
}
