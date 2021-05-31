import java.sql.*;
import Project.ConnectionProvider;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class updateDonor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_donorname;
	private JTextField textField_donorID;
	private JTextField textField_Age;
	private JTextField textField_Bgroup;
	private JTextField textField_Contact;
	private JTextField textField_Address;
	private JTextField textField_Gender;
	private JTextField textField_Date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateDonor frame = new updateDonor();
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
	public updateDonor() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80,0,1380, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE DONOR DETAILS");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(483, 34, 492, 103);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 125, 1327, 50);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Donor ID:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(240, 170, 126, 44);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SHOW DETAILS");
		btnNewButton.setIcon(new ImageIcon(this.getClass().getResource("/search.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String donorID =  textField_donorID.getText();
				try {
					
					Connection con = ConnectionProvider.getCon();
					Statement st= con.createStatement();
					ResultSet rs= st.executeQuery("select * from donor where DID='"+donorID+"'");
					if(rs.next())
					{
						textField_donorname.setText(rs.getString(2));
						textField_Age.setText(rs.getString(3));
						textField_Bgroup.setText(rs.getString(4));
						textField_Contact.setText(rs.getString(5));
						textField_Address.setText(rs.getString(6));
						textField_Gender.setText(rs.getString(7));
						textField_Date.setText(rs.getString(8));
						textField_donorID.setEditable(false);
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Donor ID doesn't exist");
					}
				}
				catch(Exception e2) {}
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(781, 153, 251, 45);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 224, 1327, 50);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Donor Name:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(240, 250, 126, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Donor Age:");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(240, 300, 115, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Blood Group:");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(240, 350, 126, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contact Number:");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(240, 400, 150, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(240, 450, 150, 32);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gender:");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_7.setBounds(240, 500, 150, 32);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Recovery Date:");
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_8.setBounds(240, 550, 150, 32);
		contentPane.add(lblNewLabel_8);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(29, 614, 1327, 50);
		contentPane.add(separator_2);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String donorId= textField_donorID.getText();
				String name = textField_donorname.getText();
				String age = textField_Age.getText();
				String Blood_group= textField_Bgroup.getText();
				String Contact = textField_Contact.getText();
				String Address = textField_Address.getText();
				String Gender = textField_Gender.getText();
				String Date = textField_Date.getText();
				if(Integer.parseInt(age)<18)
				  {
					  JOptionPane.showMessageDialog(null,"Please update donor with valid age");
					  
				  }
				else
				{
					try {
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("update donor set D_Name='"+name+"',Age='"+age+"',Blood_Group='"+Blood_group+"',Phone='"+Contact+"',Address='"+Address+"',Gender='"+Gender+"',Date='"+Date+"' where DID='"+donorId+"'");
						JOptionPane.showMessageDialog(null,"Successfully Updated");
						setVisible(false);
						new updateDonor().setVisible(true);
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null,"Connection Error");
						
					}
					
				}
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(220, 674, 170, 45);
		btnNewButton_1.setIcon(new ImageIcon(this.getClass().getResource("/save.png")));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("RESET");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new updateDonor().setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(683, 674, 140, 45);
		btnNewButton_2.setIcon(new ImageIcon(this.getClass().getResource("/Reset2.png")));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(1121, 674, 140, 45);
		btnNewButton_3.setIcon(new ImageIcon(this.getClass().getResource("/resize-16074145811000732013clo.png")));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(-29, -11, 1409, 925);
		lblNewLabel_9.setIcon(new ImageIcon(this.getClass().getResource("/background.jpg")));
		contentPane.add(lblNewLabel_9);
		
		textField_donorname = new JTextField();
		textField_donorname.setBounds(500, 250, 200, 25);
		contentPane.add(textField_donorname);
		textField_donorname.setColumns(10);
		
		textField_donorID = new JTextField();
		textField_donorID.setBounds(500, 185, 200, 25);
		contentPane.add(textField_donorID);
		textField_donorID.setColumns(10);
		
		textField_Age = new JTextField();
		textField_Age.setBounds(500, 300, 200, 25);
		contentPane.add(textField_Age);
		textField_Age.setColumns(10);
		
		textField_Bgroup = new JTextField();
		textField_Bgroup.setBounds(500, 350, 200, 25);
		contentPane.add(textField_Bgroup);
		textField_Bgroup.setColumns(10);
		
		textField_Contact = new JTextField();
		textField_Contact.setBounds(500, 400, 200, 25);
		contentPane.add(textField_Contact);
		textField_Contact.setColumns(10);
		
		textField_Address = new JTextField();
		textField_Address.setBounds(500, 450, 200, 25);
		contentPane.add(textField_Address);
		textField_Address.setColumns(10);
		
		textField_Gender = new JTextField();
		textField_Gender.setBounds(500, 500, 200, 25);
		contentPane.add(textField_Gender);
		textField_Gender.setColumns(10);
		
		textField_Date = new JTextField();
		textField_Date.setBounds(500, 550, 200, 25);
		contentPane.add(textField_Date);
		textField_Date.setColumns(10);
	}
}
