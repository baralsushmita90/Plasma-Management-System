
import Project.ConnectionProvider;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class AllDonors extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Connection con;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllDonors frame = new AllDonors();
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
	void update()
	{
		scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 172, 1269, 413);
		
		table= new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},			new String[] {
					"DID", "D_Name", "Age", "Blood_Group", "Phone", "Address", "Recovery_Date", "Gender"
				}
			));
		scrollPane.setViewportView(table);
		
		try
        {
        	//Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con= ConnectionProvider.getCon();
            System.out.println("done");
         
            
            
            PreparedStatement st=con.prepareStatement("select * from donor");
            ResultSet rs=st.executeQuery();
            
            table.setRowHeight(30);
			table.getColumnModel().getColumn(0).setPreferredWidth(5);
			table.getColumnModel().getColumn(4).setPreferredWidth(80);
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
           
    		
	   }catch(Exception e )
        {
    	System.out.println(e);
    	
        }
		
	}
	public AllDonors() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1380, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		 JLabel lblNewLabel = new JLabel("All Donor Details");
		 lblNewLabel.setBounds(536, 85, 400, 40);
		 lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
		
		update(); //populating table
		
		 JButton delete= new JButton("Delete Donor");
		 delete.setBounds(539, 646, 170, 45);
		 delete.setIcon(new ImageIcon(this.getClass().getResource("/Reset2.png")));
 		delete.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				int row=table.getSelectedRow();
 			
 				if(row==-1)
 					 JOptionPane.showMessageDialog(null, "Select a row first");
 				else
 				{
 					int col=Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
 					System.out.println(col);
 				    
					try {
						Connection con = ConnectionProvider.getCon();
						Statement stmt = con.createStatement();
						stmt.executeUpdate("delete From donor  WHERE  DID="+col);
						update();
	 			           
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
 			     	 
 					
 				}
 			}
 		});
 		 
		
        
        JButton print = new JButton("Print");
        print.setBounds(183, 646, 170, 45);
        print.setIcon(new ImageIcon(this.getClass().getResource("print.png")));
        print.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					table.print(JTable.PrintMode.FIT_WIDTH);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        	
        });
        
        JButton close = new JButton("Close");
        close.setBounds(907, 646, 170, 45);
        close.setIcon(new ImageIcon(this.getClass().getResource("/resize-16074145811000732013clo.png")));
        close.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(0, 0, 1480, 819);
        lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/background.jpg")));
        contentPane.setLayout(null);
        contentPane.add(lblNewLabel);
        contentPane.add(scrollPane);
        contentPane.add(print);
        contentPane.add(delete);
        contentPane.add(close);
        contentPane.add(lblNewLabel_1);
       
        
        
		
	}
}
