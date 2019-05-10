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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class View_Book_Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static View_Book_Window frame = new View_Book_Window(UserProfile.b);
	private JTextField BookName;
	private JTextField Author;
	private JTextField textField;
	private JTextField link;
	private JTextField textField_1;
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
    public void add_book(Book b,User u)
    {
    	u.Read_Books.add(b);
    }
	/**
	 * Create the frame.
	 */
	public View_Book_Window(Book b) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 499);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 241, 113);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.jpg")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				add_book(UserProfile.b,UserProfile.u);
			}
		});
		btnNewButton.setBounds(732, 11, 111, 91);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
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
		button.setBounds(219, 80, 115, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("My Books");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				UserProfile.Display_Read_Books(UserProfile.u);
			}
		});
		button_1.setOpaque(false);
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(344, 77, 140, 39);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("My Profile");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				UserProfile up=new UserProfile(UserProfile.u);
						up.setVisible(true);
						frame.dispose();
			}
		});
		button_2.setOpaque(false);
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(508, 75, 140, 42);
		contentPane.add(button_2);
		
		BookName = new JTextField(b.Name);
		BookName.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		BookName.setBounds(20, 142, 288, 33);
		contentPane.add(BookName);
		BookName.setColumns(10);
		
		Author = new JTextField(b.Author);
		Author.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		Author.setBounds(20, 204, 288, 33);
		contentPane.add(Author);
		Author.setColumns(10);
		
		textField = new JTextField(b.Date_published.toString());
		textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		textField.setBounds(20, 262, 288, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		link = new JTextField(b.Hyperlink);
		link.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		link.setBounds(332, 142, 220, 33);
		contentPane.add(link);
		link.setColumns(10);
		
		JLabel lblCategory = new JLabel("Categories :");
		lblCategory.setForeground(Color.DARK_GRAY);
		lblCategory.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblCategory.setBounds(577, 148, 129, 22);
		contentPane.add(lblCategory);
		
		DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement(b.categories.get(0).Name);
        JList<String> list = new JList<>(l1);
		list.setFont(new Font("Traditional Arabic", Font.PLAIN, 16));
		list.setBounds(704, 148, 129, 188);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		contentPane.add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Description:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(332, 204, 146, 32);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(332, 232, 362, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Comments:");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(20, 322, 151, 33);
		contentPane.add(lblNewLabel_2);
	}
}
