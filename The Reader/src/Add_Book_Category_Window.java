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
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Add_Book_Category_Window extends JFrame {

	private JPanel contentPane;
	JComboBox<Book> comboBox;
	JComboBox<Category> Category;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Book_Category_Window frame = new Add_Book_Category_Window();
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
	public Add_Book_Category_Window()
	
	{
		Database db = Database.getInstance();
		Book []arr= new Book[Database.getInstance().books.size()];
		Category []array= new Category[Database.getInstance().categories.size()];
		/////////load combobox data
		for (int i = 0; i < db.books.size(); i++) 
		{
			arr[i] = db.books.get(i);
		}
		comboBox=new JComboBox<Book>(arr);
		for (int i = 0; i < db.categories.size(); i++) 
		{
		    array[i] = db.categories.get(i);
		}
		Category = new JComboBox<Category>(array);
		
		//////////////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 442);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 235, 115);
		contentPane.add(lblNewLabel);

	
		Category.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		Category.setBounds(29, 164, 223, 30);
		contentPane.add(Category);

		JLabel lblNewLabel_1 = new JLabel("Select Category");
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 126, 192, 27);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Select Book");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(10, 255, 192, 30);
		contentPane.add(lblNewLabel_2);

		
		comboBox.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		comboBox.setBounds(29, 296, 223, 30);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.jpg")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Database db = Database.getInstance();
				Book sent = (Book)comboBox.getSelectedItem();
				Category assigned = (Category)Category.getSelectedItem();
				boolean added=Database.getInstance().addBookCategory(sent, assigned);
				if(added)
				{
					JOptionPane.showMessageDialog(null,"Successfully Added");
				}
				
			}
		});
		btnNewButton.setBounds(480, 0, 89, 94);
		contentPane.add(btnNewButton);
	}
}
