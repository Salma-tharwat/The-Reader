import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class View_Article_Window extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JButton relative;
	/**
	 * Launch the application.
	 */
	public static View_Article_Window frame = new View_Article_Window(new Article());
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
	public void Display_Comments(Article a)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane jsp = new JScrollPane(panel, v, h);
		jsp.setBounds(relative.getLocation().x, relative.getLocation().y, 500, 250);
		JButton result = new JButton("");
		result.setOpaque(false);
		result.setContentAreaFilled(false);
		result.setBorderPainted(false);
		panel.add(result);
		for (int i = 0; i < Database.getInstance().articles.size(); i++) {
			Article current = Database.getInstance().articles.get(i);
			if (current.equals(a))
			{
				for(int j=0;j<a.comments.size();j++)
				{
					Comment c=a.comments.get(j);
					JButton Comment = new JButton(current.comments.get(j).content);
					Comment.setFont(new Font("Traditional Arabic", Font.PLAIN | Font.ITALIC, 18));
					Comment.setOpaque(false);
					Comment.setContentAreaFilled(false);
					Comment.setBorderPainted(false);
				    panel.add(Comment);
				
				    Comment.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						
					}
				});
				    JButton reply= new JButton("Reply");
				    reply.setFont(new Font("Traditional Arabic", Font.PLAIN | Font.ITALIC, 18));
					reply.setOpaque(false);
					reply.setContentAreaFilled(false);
					reply.setBorderPainted(false);
				    reply.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							String reply=JOptionPane.showInternalInputDialog(null, "reply");
							c.replies.add(new Comment());
							for(int g=0;g<c.replies.size();g++)
							{
								JButton Reply2 = new JButton(c.replies.get(g).content);
								Reply2.setFont(new Font("Traditional Arabic", Font.PLAIN | Font.ITALIC, 18 ));
								Reply2.setBackground(SystemColor.activeCaption);
								//Reply2.setOpaque(false);
								//Reply2.setContentAreaFilled(false);
								//Reply2.setBorderPainted(false);
							    panel.add(Comment);
							}
						}
					});
				    
				}
				
			}

		}
		frame.getContentPane().add(jsp);
		// frame.setSize(500, 250 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
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
		lblNewLabel_1.setBounds(107, 153, 141, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField(a.name);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textField.setBounds(264, 154, 276, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Choose Download Folder:");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(0, 211, 248, 31);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
		textField_1.setBounds(236, 210, 342, 33);
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
		btn_browse.setBounds(585, 211, 59, 31);
		
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
		btnNewButton.setBounds(630, 187, 108, 83);
		contentPane.add(btnNewButton);
		Database db=Database.getInstance();
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String comment=JOptionPane.showInputDialog(null, "Give Your Comment");
				db.addArticleComment(a, new Comment());
			}
		});
		btnNewButton_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/commen1.png")));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(550, 132, 89, 67);
		contentPane.add(btnNewButton_1);
		
		relative = new JButton("");
	     relative.setBorderPainted(false);
		relative.setFocusPainted(false);
		relative.setContentAreaFilled(false);
		relative.setBounds(67, 286, 89, 23);
		contentPane.add(relative);
	}

}
