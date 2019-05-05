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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class Add_Book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Book frame = new Add_Book();
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
	public Add_Book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 247, 106);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 135, 120, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPublisher = new JLabel("Publisher:");
		lblPublisher.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		lblPublisher.setBounds(10, 201, 120, 40);
		contentPane.add(lblPublisher);
		
		JLabel lblDatePublished = new JLabel("Date Published:");
		lblDatePublished.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		lblDatePublished.setBounds(10, 273, 139, 40);
		contentPane.add(lblDatePublished);
		
		JLabel lblSellerLink = new JLabel("Seller Link:");
		lblSellerLink.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		lblSellerLink.setBounds(10, 335, 120, 40);
		contentPane.add(lblSellerLink);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(94, 139, 303, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(94, 205, 303, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(138, 273, 259, 31);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(104, 339, 291, 31);
		contentPane.add(textField_3);
		
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
      JList<String> list = new JList<>(l1);
		list.setBounds(466, 170, 153, 228);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		contentPane.add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Select Categories");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(480, 141, 139, 28);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		btnNewButton.setBounds(337, 23, 204, 48);
		contentPane.add(btnNewButton);
	}
}
