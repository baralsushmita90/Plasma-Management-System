
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel userLabel,passwordLabel;
	private JPasswordField passwordField;
	private JTextField userText;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
//					frame.setLocationRelativeTo(null);
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80,0,1380, 800);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
			
	   JPanel panel=new JPanel();
	   panel.setBorder(new TitledBorder(null, "", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
			
	   panel.setBackground(new Color(209, 242, 235));
	   panel.setBounds(571,160,515,460);
	   contentPane.add(panel);
	   panel.setLayout(null);
			   
			   
			   
	   userLabel= new JLabel("Username");
	   userLabel.setBounds(56, 100, 104, 21);
	   panel.add(userLabel);
	   userLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
			    
	   userText = new JTextField();
	   userText.setBounds(202, 99, 236, 30);
	   panel.add(userText);
				
	   passwordLabel = new JLabel("Password");
	    passwordLabel.setBounds(56, 200, 104, 18);
	    panel.add(passwordLabel);
	    passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(202, 198, 236, 30);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBackground(new Color(255, 255, 240));
		loginButton.setIcon(new ImageIcon(this.getClass().getResource("/login.png")));
		loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
//		loginButton.setBorder(new RoundedBorder(10));
		loginButton.setBounds(58, 331, 150, 50);
		panel.add(loginButton);
		
		JButton cancelButton = new JButton("Close");
		cancelButton.setBackground(new Color(255, 255, 240));
		cancelButton.setIcon(new ImageIcon(this.getClass().getResource("/resize-16074145811000732013clo.png")));
		cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		cancelButton.setBounds(292, 331, 150, 50);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close the application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				  System.exit(0);
			}
			
		});
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(userText.getText().equals("admin") && passwordField.getText().equals("123"))
				{
					setVisible(false);
					new Home().setVisible(true);
				}
				else
				  JOptionPane.showMessageDialog(null, "Invalid Username or password");
					
				
			}
		});
        ImageIcon img=new ImageIcon(this.getClass().getResource("/background.jpg"));
	   
	   JPanel panel_1 = new JPanel();
	   panel_1.setBackground(new Color(102, 205, 170));
	   panel_1.setBounds(92, 160, 482, 460);
	   contentPane.add(panel_1);
	   panel_1.setLayout(null);
	   
	   JLabel lblNewLabel_1 = new JLabel("MANAGEMENT");
	   lblNewLabel_1.setForeground(new Color(255, 255, 224));
	   lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 45));
	   lblNewLabel_1.setBounds(51, 122, 367, 40);
	   panel_1.add(lblNewLabel_1);
	   
	   JLabel lblNewLabel = new JLabel("COVID");
	   lblNewLabel.setForeground(new Color(255, 255, 224));
	   lblNewLabel.setBounds(51, 50, 243, 40);
	   lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 45));
	   panel_1.add(lblNewLabel);
	   
	   JLabel lblNewLabel_2 = new JLabel("SYSTEM");
	   lblNewLabel_2.setBackground(new Color(119, 136, 153));
	   lblNewLabel_2.setForeground(new Color(255, 255, 224));
	   lblNewLabel_2.setFont(new Font("Bookman Old Style", Font.BOLD, 45));
	   lblNewLabel_2.setBounds(48, 190, 233, 49);
	   panel_1.add(lblNewLabel_2);
	   
	   JLabel needle = new JLabel("New label");
	   needle.setBounds(28, 122, 444, 329);
	   panel_1.add(needle);
	   needle.setIcon(new ImageIcon(this.getClass().getResource("/needle3.png")));
	   
	   JLabel lblNewLabel_3 = new JLabel("New label");
	   lblNewLabel_3.setBounds(-15, 0, 1474, 789);
	   contentPane.add(lblNewLabel_3);
	   lblNewLabel_3.setIcon(new ImageIcon(this.getClass().getResource("/background.jpg")));
       
       
       
      
		
	    
		
		
		
		
		
	}
}
