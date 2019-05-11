import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
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
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JInternalFrame;

public class UserProfile extends JFrame {

	private JPanel contentPane;
	static JButton btnMyBooks;
	static JButton reference;
	/**
	 * Launch the application.
	 */
	public static UserProfile frame = new UserProfile(The_Reader.LoggedInUser);

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void Display_friends(User u) // function that takes a user and display Names and books of the friends
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane jsp = new JScrollPane(panel, v, h);
		jsp.setBounds(reference.getLocation().x, reference.getLocation().y, 500, 250);
		JOptionPane.showMessageDialog(null, u.followers.size());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (int i = 0; i < u.followers.size(); i++) {
			// System.out.println(u.followers.size());
			JButton Book1 = new JButton(u.followers.get(i).name);
			Book1.setOpaque(false);
			Book1.setContentAreaFilled(false);
			Book1.setBorderPainted(false);
			User u2 = u.followers.get(i);
			Book1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					viewFriend_Window up = new viewFriend_Window(u2);
					up.setVisible(true);
					frame.dispose();
				}
			});
			panel.add(Book1);

		}
		frame.getContentPane().add(jsp);
		// frame.setSize(200, 300);
		// frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void Display_Created_Articles(User u) {
		JFrame frame = new JFrame("Created Articles");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		JLabel label = new JLabel(" Articles  ");
		panel.add(label);
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (int i = 0; i < u.createdArticles.size(); i++) {

			JButton article1 = new JButton(u.createdArticles.get(i).name);
			article1.setOpaque(false);
			article1.setContentAreaFilled(false);
			article1.setBorderPainted(false);
			article1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// View_my_Book_Window vb=new View_my_Book_Window (b);
					// vb.setVisible(true);
				}
			});
			panel.add(article1);

		}
		frame.getContentPane().add(panel);
		frame.setSize(200, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void Display_Read_Books(User u) // function that takes a user and display Publications Read By the
													// User
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane jsp = new JScrollPane(panel, v, h);
		jsp.setBounds(reference.getLocation().x, reference.getLocation().y, 500, 250);

		// JOptionPane.showMessageDialog(null, u.Read_Books.get(0).Name);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (int i = 0; i < u.readBooks.size(); i++) {
			Book b = u.readBooks.get(i);
			JButton Book1 = new JButton(u.readBooks.get(i).name);
			Book1.setOpaque(false);
			Book1.setContentAreaFilled(false);
			Book1.setBorderPainted(false);
			Book1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					View_my_Book_Window vb = new View_my_Book_Window(b);
					vb.setVisible(true);
				}
			});
			panel.add(Book1);

		}
		frame.getContentPane().add(jsp);
		// frame.setSize(200, 300);
		// frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public UserProfile(User u) {

		User U1 = new User("Ahmed", "Ahmed_123", "12345");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 214, 106);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home h = new Home();
				h.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(214, 82, 115, 33);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		contentPane.add(btnNewButton);

		JButton btnMyBooks = new JButton("My Books");
		btnMyBooks.setForeground(Color.DARK_GRAY);
		btnMyBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Display_Read_Books(u);
				/*
				 * DefaultListModel<String> l1 = new DefaultListModel<>();
				 * l1.addElement("The Secret"); l1.addElement("History Of Egypt");
				 * l1.addElement("The Fault In Our Stars"); JList<String> list = new
				 * JList<>(l1); JFrame f= new JFrame("My Books Pannel"); JPanel panel=new
				 * JPanel(); panel.setSize(400,400); panel.setBackground(Color.gray); JButton
				 * b1=new JButton("Back"); b1.setBounds(50,100,80,30); b1.setOpaque(false);
				 * b1.setContentAreaFilled(false); b1.setBorderPainted(false); panel.add(b1);
				 * panel.add(list); f.getContentPane().add(panel); f.setSize(400,400);
				 * f.getContentPane().setLayout(null); f.setVisible(true);
				 */
			}
		});
		btnMyBooks.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnMyBooks.setOpaque(false);
		btnMyBooks.setContentAreaFilled(false);
		btnMyBooks.setBorderPainted(false);
		btnMyBooks.setBounds(311, 79, 140, 39);
		contentPane.add(btnMyBooks);

		JButton btnFriends = new JButton("Friends");
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Display_friends(u);
			}
		});
		btnFriends.setForeground(Color.DARK_GRAY);
		btnFriends.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnFriends.setOpaque(false);
		btnFriends.setContentAreaFilled(false);
		btnFriends.setBorderPainted(false);
		btnFriends.setBounds(427, 77, 140, 42);
		contentPane.add(btnFriends);

		JLabel welcomelabel = new JLabel("Welcome  " + u.name);
		welcomelabel.setForeground(Color.DARK_GRAY);
		welcomelabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		welcomelabel.setBounds(10, 125, 319, 33);
		contentPane.add(welcomelabel);

		JButton btnNewButton_1 = new JButton("Follow Category");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println(Database.getInstance().categories.size());
				String a = JOptionPane.showInputDialog(null, "Enter Category Name");
				Category c = Database.getInstance().getCategory(a);
				boolean followed = Database.getInstance().addUserCategory(The_Reader.LoggedInUser, c);
				System.out.println(followed);
				if (!followed) {
					JOptionPane.showMessageDialog(null, "Successfully Followed ");
				}
			}
		});
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(-16, 227, 204, 42);
		contentPane.add(btnNewButton_1);

		JButton btnSignout = new JButton("Sign Out");
		btnSignout.setForeground(Color.DARK_GRAY);
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				The_Reader reader = new The_Reader();
				reader.main(null);
			}
		});
		btnSignout.setOpaque(false);
		btnSignout.setContentAreaFilled(false);
		btnSignout.setBorderPainted(false);
		btnSignout.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnSignout.setBounds(23, 280, 123, 39);
		contentPane.add(btnSignout);

		JButton btnNewButton_2 = new JButton("Go !");
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(537, 82, 99, 33);
		contentPane.add(btnNewButton_2);

		JButton btnNoti;
		btnNoti = new JButton();
		btnNoti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
		boolean notify=false;
		for(int i=0;i<u.notifications.size();i++)
		{
			if(u.notifications.get(i).IsSeen()==true)
			{
				btnNoti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notify2.jpg")));
				notify=true;
				
			}
			
		}
		if(!notify)
			{
				btnNoti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noti1.png")));
			}
		btnNoti.setBorderPainted(false);
		btnNoti.setFocusPainted(false);
		btnNoti.setContentAreaFilled(false);
		btnNoti.setBounds(772, 0, 79, 80);
		contentPane.add(btnNoti);

		JButton newsfeed = new JButton("");
		newsfeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				NewsFeed news = new NewsFeed();
				news.setVisible(true);
			}
		});
		newsfeed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newsfeed.jpg")));
		newsfeed.setBorderPainted(false);
		newsfeed.setFocusPainted(false);
		newsfeed.setContentAreaFilled(false);
		newsfeed.setBounds(687, 0, 93, 71);
		contentPane.add(newsfeed);

		JButton btnCreateArticle = new JButton("Create Article");
		btnCreateArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Create_Article_Window cr = new Create_Article_Window();
				cr.setVisible(true);
				frame.dispose();
			}
		});
		btnCreateArticle.setOpaque(false);
		btnCreateArticle.setForeground(Color.DARK_GRAY);
		btnCreateArticle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnCreateArticle.setContentAreaFilled(false);
		btnCreateArticle.setBorderPainted(false);
		btnCreateArticle.setBounds(0, 169, 159, 42);
		contentPane.add(btnCreateArticle);

		reference = new JButton();
		reference.setBorderPainted(false);
		reference.setFocusPainted(false);
		reference.setContentAreaFilled(false);
		reference.setBounds(297, 169, 70, 23);
		contentPane.add(reference);

	}
}
