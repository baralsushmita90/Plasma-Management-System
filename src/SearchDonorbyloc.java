import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.Color;

public class SearchDonorbyloc extends JFrame {

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
					SearchDonorbyloc frame = new SearchDonorbyloc();
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
	public SearchDonorbyloc() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80,0,1380, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel heading = new JLabel("SEARCH DONOR BY LOCATION");
		heading.setForeground(new Color(119, 136, 153));
		heading.setBounds(414, 10, 504, 35);
		heading.setFont(new Font("Tahoma", Font.BOLD, 30));
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel address = new JLabel("Address");
		address.setForeground(new Color(119, 136, 153));
		address.setBounds(387, 66, 117, 19);
		address.setFont(new Font("Tahoma", Font.BOLD, 20));
		address.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(568, 66, 236, 27);
		textField.setColumns(10);
		
		JButton print = new JButton("PRINT");
		print.setIcon(new ImageIcon(this.getClass().getResource("/print.png")));
		print.setBounds(245, 699, 170, 45);
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
		print.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton search = new JButton("SEARCH");
		search.setIcon(new ImageIcon(this.getClass().getResource("/search.png")));
		search.setBounds(872, 61, 170, 45);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String location = textField.getText();
				if(location.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Please enter Address first!!");
					
				}
				else
				{
					try
					{
						//Class.forName("com.mysql.cj.jdbc.Driver");  
						Connection con=ConnectionProvider.getCon();
						//here javaproject is database name, root is username and riyagoel is password  
						
						Statement stmt=con.createStatement();  
						ResultSet rs=stmt.executeQuery("SELECT * FROM donor WHERE Address LIKE '%"+location+"%';");
						
						if(!rs.isBeforeFirst())
						{
							JOptionPane.showMessageDialog(null,"No Records Found");
							textField.setText("");
						}
							
						else
						{
							table.setModel(DbUtils.resultSetToTableModel(rs));
							int[] columnsWidth = {
									75, 200, 75, 150, 120, 350, 150, 150
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
//						while(rs.next())
//						{
//							//model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
//							System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7)+"  "+rs.getString(8)); 
//						}
						
						//System.out.println(ret);
							
//						table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
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
		search.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton close = new JButton("CLOSE");
		close.setIcon(new ImageIcon(this.getClass().getResource("/resize-16074145811000732013clo.png")));
		close.setBounds(748, 699, 170, 45);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
			}
		});
		close.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setLayout(null);
		contentPane.add(heading);
		contentPane.add(address);
		contentPane.add(textField);
		contentPane.add(print);
		contentPane.add(search);
		contentPane.add(close);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setOpaque(false);
		scrollPane.setBounds(50, 116, 1285, 500);
		contentPane.add(scrollPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setOpaque(false);
		
		table = new JTable();
		table.setBorder(null);
		table.setOpaque(false);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"DID", "D_Name", "Age", "Blood_Group", "Phone", "Address", "Gender", "Date"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
//		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		
   
     	table.setRowHeight(30);
//	    table.getColumnModel().getColumn(0).setPreferredWidth(5);
//		table.getColumnModel().getColumn(5).setPreferredWidth(100);


		try
		{

			Connection con=ConnectionProvider.getCon();

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM donor;");
			//table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
//			table.setRowHeight(30);
//			table.getColumnModel().getColumn(0).setPreferredWidth(5);
//			table.getColumnModel().getColumn(4).setPreferredWidth(80);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			int[] columnsWidth = {
					75, 200, 75, 150, 120, 350, 150, 150
					
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
		lblNewLabel.setBounds(-60, 0, 1458, 800);
		ImageIcon img=new ImageIcon(this.getClass().getResource("/background.jpg"));
  	    lblNewLabel.setIcon(img);
  	    contentPane.add(lblNewLabel);
	}
}
