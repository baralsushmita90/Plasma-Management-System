import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import java.awt.Color;

public class SearchDonorbyBG extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDonorbyBG frame = new SearchDonorbyBG();
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
	public SearchDonorbyBG() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80,0,1380, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel bloodgrp = new JLabel("SEARCH DONOR BY BLOOD GROUP");
		bloodgrp.setForeground(new Color(119, 136, 153));
		bloodgrp.setBounds(416, 25, 547, 31);
		bloodgrp.setHorizontalAlignment(SwingConstants.CENTER);
		bloodgrp.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel bg = new JLabel("Blood Group");
		bg.setForeground(new Color(119, 136, 153));
		bg.setBounds(388, 68, 198, 19);
		bg.setFont(new Font("Tahoma", Font.BOLD, 20));
		bg.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(584, 66, 259, 31);
		textField.setColumns(10);
		
		JButton print = new JButton("PRINT");
		print.setBounds(367, 709, 170, 45);
		print.setIcon(new ImageIcon(this.getClass().getResource("/print.png")));
		print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					table.print(JTable.PrintMode.FIT_WIDTH);
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		print.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton search = new JButton("SEARCH");
		search.setBounds(893, 68, 170, 45);
		search.setIcon(new ImageIcon(this.getClass().getResource("/search.png")));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String blood_grp = textField.getText();
				
				if(blood_grp.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Enter Blood Group First");
				}
				else
				{
					try
					{
						//Class.forName("com.mysql.cj.jdbc.Driver");  
						Connection con=ConnectionProvider.getCon();
						//here javaproject is database name, root is username and riyagoel is password  
						
						Statement stmt=con.createStatement();  
						ResultSet rs=stmt.executeQuery("SELECT * FROM donor WHERE Blood_Group LIKE '%"+blood_grp+"%';");
						
						if(!rs.isBeforeFirst())
						{
							JOptionPane.showMessageDialog(null,"No Records Found");
							textField.setText("");
						}
							
						else
						{
							table.setModel(DbUtils.resultSetToTableModel(rs));
							 int[] columnsWidth = {
				                      75, 200, 75, 150, 120, 350, 150, 125
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
							textField.setText("");
							con.close();
						}

						table.setRowHeight(30);
						table.getColumnModel().getColumn(0).setPreferredWidth(5);
						table.getColumnModel().getColumn(4).setPreferredWidth(80);
						

						
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,e1);
					}
				}
				
			}
		});
		search.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton close = new JButton("CLOSE");
		close.setIcon(new ImageIcon(this.getClass().getResource("/resize-16074145811000732013clo.png")));
		close.setBounds(839, 709, 170, 45);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
			}
		});
		close.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.setLayout(null);
		contentPane.add(print);
		contentPane.add(search);
		contentPane.add(close);
		contentPane.add(bg);
		contentPane.add(textField);
		contentPane.add(bloodgrp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(43, 126, 1269, 527);
		  
		contentPane.add(scrollPane);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},			new String[] {
				"DID", "D_Name", "Age", "Blood_Group", "Phone", "Address", "Recovery_Date", "Gender"
			}
		));
		
		
		


          try
          {
	

        	  Connection con=ConnectionProvider.getCon();

        	  Statement stmt=con.createStatement();  
        	  ResultSet rs=stmt.executeQuery("SELECT * FROM donor;");
        	  //table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
        	    table.setRowHeight(30);
				table.getColumnModel().getColumn(0).setPreferredWidth(5);
				table.getColumnModel().getColumn(4).setPreferredWidth(80);
        	  table.setModel(DbUtils.resultSetToTableModel(rs));
        	  int[] columnsWidth = {
        			  75, 200, 75, 150, 120, 350, 150, 125
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
        	  con.close();  
          }
          catch(Exception e1)
          {
        	  JOptionPane.showMessageDialog(null,e1);
          }
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-90, -20, 1470, 837);
		ImageIcon img=new ImageIcon(this.getClass().getResource("/background.jpg"));
  	    lblNewLabel.setIcon(img);
		contentPane.add(lblNewLabel);
	}
}
