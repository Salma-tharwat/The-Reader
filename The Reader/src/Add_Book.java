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
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class Add_Book extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	JTextArea textArea;
	public static Add_Book frame = new Add_Book();
	/**
	 * Launch the application.
	 */
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
		lblDatePublished.setBounds(10, 268, 139, 40);
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
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(104, 339, 291, 31);
		contentPane.add(textField_3);
		
		JSpinner  s1 = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
		JSpinner s2 = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1)); 
		JSpinner  s = new JSpinner();
		JButton btnNewButton = new JButton("Add Book");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Date d=new Date(Integer.parseInt(s1.getValue().toString()),Integer.parseInt(s2.getValue().toString()),Integer.parseInt(s.getValue().toString()));
				Book b = new Book(0,textField.getText(),d,textField_1.getText(), textField_3.getText(), textArea.getText());
				boolean added =Database.getInstance().addBook(b);
				Database.getInstance().books.add(b);
				if(added)
				{
					JOptionPane.showMessageDialog(null, "Book Added");
					Admin_Panel ap=new Admin_Panel();
					ap.setVisible(true);
					frame.dispose();
				}
				else
				{

					JOptionPane.showMessageDialog(null, "Try Again");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		btnNewButton.setBounds(195, 11, 204, 48);
		contentPane.add(btnNewButton);
	
         
		s1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		s1.setBounds(195, 273, 50, 31);
		contentPane.add(s1);
        // create a JSpinner with list values 
		
        
		s2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		s2.setBounds(255, 273, 50, 31);
		contentPane.add(s2);
		
		
		s.setValue(2000); 
		s.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		s.setBounds(315, 273, 82, 31);
		contentPane.add(s);
		
		JLabel lblNewLabel_2 = new JLabel("Description:");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(419, 138, 129, 35);
		contentPane.add(lblNewLabel_2);
		
		 textArea = new JTextArea();
		textArea.setBounds(429, 168, 173, 207);
		contentPane.add(textArea);
		
		
	}
}
