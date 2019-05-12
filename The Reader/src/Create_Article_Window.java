import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.time.format.DateTimeFormatter ;
import java.text.SimpleDateFormat ;
import java.time.LocalDate ;
import java.time.LocalTime ;
import java.time.LocalDateTime ;
import java.time.Clock ;
import java.util.Date ;

import java.util.Calendar ;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class Create_Article_Window extends JFrame {

	private JPanel contentPane;
	private JTextField article_name;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_Article_Window frame = new Create_Article_Window();
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
	public Create_Article_Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 503);
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
		
		JButton btn_add = new JButton("New button");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				
				LocalDateTime now = LocalDateTime.now(); 
				java.util.Date date=new java.util.Date();  
				Database db=Database.getInstance();
				Article article=new Article(db.getNextArticleId(),article_name,date,The_Reader.LoggedInUser,"")
			}
		});
		btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.jpg")));
		btn_add.setBorderPainted(false);
		btn_add.setFocusPainted(false);
		btn_add.setContentAreaFilled(false);
		btn_add.setBounds(750, 0, 112, 85);
		contentPane.add(btn_add);
		
		JLabel lblNewLabel_1 = new JLabel("Article Name :");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 171, 202, 32);
		contentPane.add(lblNewLabel_1);
		
		article_name = new JTextField();
		article_name.setBounds(157, 171, 337, 27);
		contentPane.add(article_name);
		article_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Upload File :");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(10, 288, 167, 32);
		contentPane.add(lblNewLabel_2);
		//JFileChooser files =new JFileChooser(FileSystemView.getFileSystemView()); 
		//files.showSaveDialog(null);
		
		JButton btn_browse = new JButton("");
		contentPane.add(btn_browse);
		btn_browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				 //files.setVisible(true);
				 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
				  
		            // set the selection mode to directories only 
		             
		            
		            // resctrict the user to selec files of all types 
		            j.setAcceptAllFileFilterUsed(false); 
		  
		            // set a title for the dialog 
		            j.setDialogTitle("Select a .txt file"); 
		            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt"); 
		            j.addChoosableFileFilter(restrict);
		            // invoke the showsOpenDialog function to show the save dialog 
		            int r = j.showOpenDialog(null); 
		  
		            if (r == JFileChooser.APPROVE_OPTION) { 
		                // set the label to the path of the selected directory 
		            	textField.setText(j.getSelectedFile().getAbsolutePath()); 
		            } 
			}
		});
		btn_browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/browse.png")));
		btn_browse.setBorderPainted(false);
		btn_browse.setFocusPainted(false);
		btn_browse.setContentAreaFilled(false);
		btn_browse.setBounds(501, 288, 59, 23);
		
		textField = new JTextField();
		textField.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 18));
		textField.setBounds(157, 288, 337, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		  
		
		
	}
}
