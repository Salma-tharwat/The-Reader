import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class View_Article_Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Article_Window frame = new View_Article_Window(new Article());
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
	public View_Article_Window(Article a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 493);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/22.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 0, 248, 106);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Article Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(27, 153, 195, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField(a.name);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(153, 154, 276, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Choose Download Folder:");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(10, 256, 248, 31);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		textField_1.setBounds(249, 255, 342, 33);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btn_browse = new JButton("");
		contentPane.add(btn_browse); 
		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		btn_browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				  
		            // set a title for the dialog 
		            
		            j.setAcceptAllFileFilterUsed(false); 
		            // set the selection mode to directories only 
		            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		           // j.addChoosableFileFilter(restrict);
		            // invoke the showsOpenDialog function to show the save dialog 
		            int r = j.showOpenDialog(null); 
		  
		            if (r == JFileChooser.APPROVE_OPTION) { 
		                // set the label to the path of the selected directory 
		            	textField_1.setText(j.getSelectedFile().getAbsolutePath()); 
		            } 
			}
		});
		btn_browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/browse.png")));
		btn_browse.setBorderPainted(false);
		btn_browse.setFocusPainted(false);
		btn_browse.setContentAreaFilled(false);
		btn_browse.setBounds(592, 262, 59, 23);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				boolean downloaded =FileHandler.writePDF(a.content, j.getSelectedFile().getAbsolutePath());
				if(downloaded)
				{
					JOptionPane.showMessageDialog(null, "You Download will Start Shortly");
				}
				
			}
		});
		btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/download.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(640, 230, 108, 83);
		contentPane.add(btnNewButton);
	}

}
