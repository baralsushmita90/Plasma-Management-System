import java.sql.*;
import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import java.awt.EventQueue;
//import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
//import java.awt.BorderLayout;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
public void update()
{
	/*JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(138, 121, 1219, 459);
	scrollPane.setOpaque(false);
	scrollPane.setBorder(BorderFactory.createEmptyBorder());
    scrollPane.getViewport().setOpaque(false);
	table = new JTable();
	table.setFont(new Font("Tahoma", Font.PLAIN, 15));
	table.setOpaque(false);
	
	table.setBackground(new Color(255, 255, 255));
	table.setModel(new DefaultTableModel(
			new Object[][] {
			},			new String[] {
				"DID", "D_Name", "Age", "Blood_Group", "Phone", "Address", "Recovery_Date", "Gender"
			}
		));
	

    // Configures table's column width.
    

	scrollPane.setViewportView(table);*/
	try
    {
    	//Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con= ConnectionProvider.getCon();
        System.out.println("done");
     
        
        
        PreparedStatement st=con.prepareStatement("select * from donor");
        ResultSet rs=st.executeQuery();
        
        table.setRowHeight(30);
		//table.getColumnModel().getColumn(0).setPreferredWidth(5);
		//table.getColumnModel().getColumn(4).setPreferredWidth(80);
        
        table.setModel(DbUtils.resultSetToTableModel(rs));
        int[] columnsWidth = {
        		75, 200, 75, 150, 120, 350, 125, 125
        		 
        		 
            };
        int i=0;
        for (int width : columnsWidth) {
            TableColumn column = table.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
        JTableHeader header = table.getTableHeader();
        Font headerFont= new Font("Verdana",Font.BOLD,17);
        header.setFont(headerFont);
        //header.setBackground(Color.getHSBColor(159, 0.5, 0.6));
        
    }
       /* JButton print = new JButton("Print");
        print.setFont(new Font("Tahoma", Font.BOLD, 15));
        print.setBounds(400, 636, 180, 49);
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
        
        JButton delete = new JButton("Delete Donor");
        delete.setFont(new Font("Tahoma", Font.BOLD, 15));
        delete.setBounds(900, 636, 180, 49);
        delete.setIcon(new ImageIcon(this.getClass().getResource("/delete.png")));
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
        getContentPane().setLayout(null);
        getContentPane().add(print);
        getContentPane().add(delete);
        getContentPane().add(lblNewLabel);
        getContentPane().add(scrollPane);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/background.jpg")));
        lblNewLabel_1.setBounds(0, -40, 1603, 806);
        getContentPane().add(lblNewLabel_1);
        
      
        
       
		
   }*/catch(Exception e )
    {
	System.out.println(e);
	
    }
    
	
}

	/**
	 * Create the frame.
	 */
	public Home() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600, 1000);
		
		JMenuBar donorMenuBar = new JMenuBar();
		donorMenuBar.setBackground(new Color(102, 205, 170));
		
		setJMenuBar(donorMenuBar);
		
		JMenu donor = new JMenu("Donor");

		donor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		donor.setIcon(new ImageIcon(this.getClass().getResource("/donor.png")));
		donorMenuBar.add(donor);
		
		JMenuItem addDonor = new JMenuItem("Add New Donor");
		addDonor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		addDonor.setFont(new Font("Segoe UI", Font.BOLD, 16));
		addDonor.setIcon(new ImageIcon(this.getClass().getResource("/adddonor.png")));
		
		donor.add(addDonor);
	    addDonor.addActionListener(new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent e) {
	    		setVisible(false);
	    		new addnewdonor().setVisible(true);
	    	}
	    	
	    });
		
		
		JSeparator separator = new JSeparator();
		donor.add(separator);
		
		JMenuItem updateDonor = new JMenuItem("Update Details");
		updateDonor.setFont(new Font("Segoe UI", Font.BOLD, 16));
		updateDonor.setIcon(new ImageIcon(this.getClass().getResource("/Reset2.png")));
		updateDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new updateDonor().setVisible(true);
			}
		});
		updateDonor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		donor.add(updateDonor);
		
		JMenu searchdonor = new JMenu("Search Donor");
		searchdonor.setBackground(new Color(240, 240, 240));
		searchdonor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		searchdonor.setIcon(new ImageIcon(this.getClass().getResource("/search2.png")));
		donorMenuBar.add(searchdonor);
		
		JMenuItem byloc = new JMenuItem("Search by Location");
		byloc.setIcon(new ImageIcon(this.getClass().getResource("/location.png")));
		byloc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		byloc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
	    		new SearchDonorbyloc().setVisible(true);
				
			}
		});
		byloc.setFont(new Font("Segoe UI", Font.BOLD, 16));
		searchdonor.add(byloc);
		
		JSeparator separator1 = new JSeparator();
		searchdonor.add(separator1);
		
		JMenuItem bybloodgrp = new JMenuItem("Search by Blood Group");
		
		bybloodgrp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		bybloodgrp.setIcon(new ImageIcon(this.getClass().getResource("/bloodgroup.png")));
		bybloodgrp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchDonorbyBG().setVisible(true);
			}
		});
		bybloodgrp.setFont(new Font("Segoe UI", Font.BOLD, 16));
		searchdonor.add(bybloodgrp);
		
		lblNewLabel = new JLabel("All Donor Details");
		lblNewLabel.setBounds(490, 11, 489, 92);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 121, 1219, 459);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
	    scrollPane.getViewport().setOpaque(false);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setOpaque(false);
		
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},			new String[] {
					"DID", "D_Name", "Age", "Blood_Group", "Phone", "Address", "Recovery_Date", "Gender"
				}
			));
		

	    // Configures table's column width.
	    

		scrollPane.setViewportView(table);
		update();
        JButton print = new JButton("Print");
        print.setFont(new Font("Tahoma", Font.BOLD, 15));
        print.setBounds(400, 636, 180, 49);
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
        
        JButton delete = new JButton("Delete Donor");
        delete.setFont(new Font("Tahoma", Font.BOLD, 15));
        delete.setBounds(900, 636, 180, 49);
        delete.setIcon(new ImageIcon(this.getClass().getResource("/delete.png")));
 		delete.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				int row=table.getSelectedRow();
 			
 				if(row==-1)
 					 JOptionPane.showMessageDialog(null, "Select a row first");
 				else
 				{
 					int a=JOptionPane.showConfirmDialog(null, "Do you really want to delete the selected row","Select",JOptionPane.YES_NO_OPTION);
 					if(a==0) {
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
// 					  System.exit(0);
// 					else {
// 						System.exit(0);
// 					}
 					
 				}
 			}
 		});
        getContentPane().setLayout(null);
        getContentPane().add(print);
        getContentPane().add(delete);
        getContentPane().add(lblNewLabel);
        getContentPane().add(scrollPane);
      
		
		/*JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1605, 769);
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/background.jpg")));
		getContentPane().add(lblNewLabel);
		*/
		JSeparator separator_1 = new JSeparator();
		donor.add(separator_1);
		
		
		JMenuItem deletedonors = new JMenuItem("Delete donors");
		deletedonors.setFont(new Font("Segoe UI", Font.BOLD, 16));
		deletedonors.setIcon(new ImageIcon(this.getClass().getResource("/delete.png")));
		deletedonors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to delete donors?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					try
			        {
			        	//Class.forName("com.mysql.cj.jdbc.Driver");  
			            Connection con= ConnectionProvider.getCon();
			              
			           
			            Statement stmt=con.createStatement();  
			     		stmt.executeUpdate("delete From donor  WHERE  DATEDIFF(CURRENT_DATE, Date) >90;");
			     		JOptionPane.showMessageDialog(null, "Successfull");
			     		
			     		new Home().setVisible(true);
			     		setVisible(false);
			        	
			        }catch(Exception el)
			        {
			        	System.out.println(el);
			        	
			        }
				}
				 
			}
			
		});
		deletedonors.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		donor.add(deletedonors);
		
		JMenu mnNewMenu = new JMenu("Ventilator");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 18));
		mnNewMenu.setIcon(new ImageIcon(this.getClass().getResource("/Ventilator.png")));
		donorMenuBar.add(mnNewMenu);
		
		JMenuItem ventilator_menuItem = new JMenuItem("Show Ventilator Count");
		ventilator_menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		ventilator_menuItem.setIcon(new ImageIcon(this.getClass().getResource("/venti.png")));
		ventilator_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
		        {
		        	//Class.forName("com.mysql.cj.jdbc.Driver");  
		            Connection con= ConnectionProvider.getCon();
		            System.out.println("done");
		         
		            
		            
		            PreparedStatement st=con.prepareStatement("select count(*) from Ventilator");
		            ResultSet rs=st.executeQuery();
		            int total=0;
		            while(rs.next())
		            {
		            	total=rs.getInt(1);
		            	
		            }
		            st=con.prepareStatement("select count(*) from Patient,Ventilator where Patient.PID=Ventilator.PID and Disease='COVID' ");
		             rs=st.executeQuery();
		            int ac=0;
		           while(rs.next())
		            {
		            	 ac=rs.getInt(1);
		            	
		            }
		          
		          int t=(int)(0.50*total);
		          if(ac==t)
		          {
		        	  JOptionPane.showMessageDialog(null, "No Ventilator available");
		          }
		          else
		          {
		        	  System.out.println("total "+total);
		        	  System.out.println("Acquired by COVID "+ac);
		        	  System.out.println("total  reserved="+t);
		        	  System.out.println("Availabe "+(t-ac));
		        	  JOptionPane.showMessageDialog(null, "Total Ventilators "+total+"\nAvailable for COVID patients "+(t-ac));
		        	  
		          }
		        	  
		          
		           
		            
		            //table.setModel(DbUtils.resultSetToTableModel(rs));
		            
		            
		        	
		        }catch(Exception e5 )
		        {
		        	System.out.println(e5);
		        	
		        }
				
			}
			
		});
		ventilator_menuItem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu.add(ventilator_menuItem);
		
		

		
		
		
		
	}
}
