
import java.sql.*;
import java.text.SimpleDateFormat;

import Project.ConnectionProvider;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;


public class addnewdonor extends JFrame {

	private JPanel contentPane;
	private JTextField textFeild_Dname;
	private JTextField textField_DAge;
	private JTextField textFeild_BloodGroup;
	private JTextField textField_address;
	private JTextField textField_Contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addnewdonor frame = new addnewdonor();
					//frame.setLocationRelativeTo(null);
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
	
	
	public addnewdonor() {
		
		
		
	     
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(80,0,1380, 800);
//		pack();
//		setLocationRelativeTo(null);
//		setVisible(true);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 10));
		JLabel DID = new JLabel();
//		DID.setText("9");
		DID.setBounds(500, 93, 78, 17);
		DID.setForeground(Color.YELLOW);
		DID.setFont(new Font("Arial", Font.BOLD, 24));
		contentPane.add(DID);
		
		
//		contentPane.addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentShown(ComponentEvent e) {
				   
//		       contentPane.addComponentListener(this);
				   
				
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					ResultSet rs = st.executeQuery("select max(DID) from donor");
					//System.out.println("Outside if");
					
					if(rs.first())
				{
						//System.out.println("INside if");
						int id = rs.getInt(1);
						
						
						//System.out.println(id);
						id=id+1;
						
						String str = String.valueOf(id);
						
						DID.setText(str);
						
				}
					else
					{
						
						DID.setText("1");
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
			}			
//					}
//		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_AddDonor = new JLabel("Add New Donor");
		label_AddDonor.setForeground(new Color(0, 0, 0));
		label_AddDonor.setBounds(543, 6, 505, 48);
		label_AddDonor.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(label_AddDonor);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 64, 1339, 30);
		contentPane.add(separator_2);
		
		JLabel label_newDonor = new JLabel("New Donor ID");
		label_newDonor.setForeground(new Color(0, 0, 0));
		label_newDonor.setBounds(200, 93, 170, 30);
		label_newDonor.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(label_newDonor);
		
		
		JLabel label_donorname = new JLabel("Donor Name");
		label_donorname.setForeground(new Color(0, 0, 0));
		label_donorname.setBounds(200, 135, 133, 30);
		label_donorname.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(label_donorname);
		
		JLabel label_donorAge = new JLabel("Donor Age");
		label_donorAge.setForeground(new Color(0, 0, 0));
		label_donorAge.setBounds(200, 175, 133, 30);
		label_donorAge.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(label_donorAge);
		
		JLabel label_Bgroup = new JLabel("Blood Group");
		label_Bgroup.setForeground(new Color(0, 0, 0));
		label_Bgroup.setBounds(200, 215, 133, 30);
		label_Bgroup.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(label_Bgroup);
		
		JLabel label_Contact = new JLabel("Contact Number");
		label_Contact.setForeground(new Color(0, 0, 0));
		label_Contact.setBounds(200, 256, 145, 30);
		label_Contact.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(label_Contact);
		
		JLabel label_address = new JLabel("Address");
		label_address.setForeground(new Color(0, 0, 0));
		label_address.setBounds(200, 287, 133, 30);
		label_address.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(label_address);
		
		JLabel label_date = new JLabel("Recovery Date");
		label_date.setForeground(new Color(0, 0, 0));
		label_date.setBounds(200, 432, 145, 21);
		label_date.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(label_date);
		
		textFeild_Dname = new JTextField();
		textFeild_Dname.setBounds(500, 142, 202, 25);
		contentPane.add(textFeild_Dname);
		textFeild_Dname.setColumns(10);
		
		textField_DAge = new JTextField();
		textField_DAge.setBounds(500, 182, 202, 25);
		contentPane.add(textField_DAge);
		textField_DAge.setColumns(10);
		
//		textFeild_BloodGroup = new JTextField();
//		textFeild_BloodGroup.setBounds(500, 222, 202, 19);
//		contentPane.add(textFeild_BloodGroup);
//		textFeild_BloodGroup.setColumns(10);
		JComboBox comboBox_bg = new JComboBox();
		comboBox_bg.setBounds(500, 215, 202,30);
		comboBox_bg.setModel(new DefaultComboBoxModel(new String[] {"A+","A-","B+","B-","O+","O-","AB+","AB-"}));
		contentPane.add(comboBox_bg);
		
		
		textField_address = new JTextField();
		textField_address.setBounds(500, 287, 202, 80);
		contentPane.add(textField_address);
		textField_address.setColumns(10);
		
		textField_Contact = new JTextField();
		textField_Contact.setBounds(500, 254, 202, 25);
		contentPane.add(textField_Contact);
		textField_Contact.setColumns(10);
		
		JLabel label_gender = new JLabel("Gender");
		label_gender.setForeground(new Color(0, 0, 0));
		label_gender.setBounds(204, 376, 129, 30);
		label_gender.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(label_gender);
		
		JComboBox comboBox_Gender = new JComboBox();
		comboBox_Gender.setBounds(500, 383, 202, 27);
		comboBox_Gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		contentPane.add(comboBox_Gender);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 504, 1301, 30);
		contentPane.add(separator);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(500, 420, 202, 25);
		contentPane.add(dateChooser);
		
		JButton button_Save = new JButton("Save");
		button_Save.setBounds(280, 632, 170, 45);
		button_Save.setIcon(new ImageIcon(this.getClass().getResource("/save.png")));
		button_Save.setFont(new Font("Arial", Font.BOLD, 14));
		button_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				//System.out.print("Saved");
				String donorId= DID.getText();
				String name =textFeild_Dname.getText();
				String age = textField_DAge.getText();
//				String Blood_group= textFeild_BloodGroup.getText();
				String Blood_group = (String)comboBox_bg.getSelectedItem();
				String Contact = textField_Contact.getText();
				String Address = textField_address.getText();	
				String gender = (String)comboBox_Gender.getSelectedItem();
				SimpleDateFormat dFormat = new SimpleDateFormat("YYYY-MM-dd");
     			//Date DOB = dFormat.format(dateChooser.getDate());
				if(name.isEmpty() || age.isEmpty() || Blood_group.isEmpty() || Contact.isEmpty() || Address.isEmpty() || gender.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter all the details first");
				}
				else {
					
					  if(Integer.parseInt(age)<18)
					  {
						  JOptionPane.showMessageDialog(null,"Please enter donor with valid age");
						  
					  }
					  else
					  {
						  try {
								Connection con = ConnectionProvider.getCon();
								Statement st = con.createStatement();
								st.executeUpdate("insert into donor values('"+donorId+"','"+name+"','"+age+"','"+Blood_group+"','"+Contact+"','"+Address+"','"+gender+"','"+dFormat.format(dateChooser.getDate())+"')");
								JOptionPane.showMessageDialog(null, "Succesfully Updated");
								
								new addnewdonor().setVisible(true);
								setVisible(false);
								
								
								
								//addition end
								}
							catch(Exception e2) {
								
								JOptionPane.showMessageDialog(null,"Please enter all the details first");
							
						}
						  
					  }
					
					
				
				}
				
				}
			
		});
		contentPane.add(button_Save);
		
		JButton button_Reset = new JButton("Reset");
		button_Reset.setIcon(new ImageIcon(this.getClass().getResource("/Reset2.png")));
		button_Reset.setBounds(727, 632, 170, 45);
		button_Reset.setFont(new Font("Arial", Font.BOLD, 14));
		button_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new addnewdonor().setVisible(true);
			}
		});
		contentPane.add(button_Reset);
		
		JButton button_Close = new JButton("Close");
		button_Close.setIcon(new ImageIcon(this.getClass().getResource("/resize-16074145811000732013clo.png")));
		button_Close.setBounds(1096, 632, 170, 45);
		button_Close.setFont(new Font("Arial", Font.BOLD, 14));
		Home h = new Home();
		button_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				h.update();
				new Home().setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(button_Close);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(this.getClass().getResource("/background.jpg")));
		lblNewLabel_10.setBounds(-26, -18, 1468, 924);
		contentPane.add(lblNewLabel_10);
		
		
		
		
	}
}
