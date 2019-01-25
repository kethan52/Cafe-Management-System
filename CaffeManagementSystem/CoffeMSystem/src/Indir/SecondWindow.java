package Indir;

import java.awt.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.event.*;


public class SecondWindow extends JFrame{

	Connection connection=null;
	
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox box;
	private JButton load;
	private JLabel search;
	private JTextField searchField;
	
	public void searchData(JTextField searchField)
	{
		searchField.addKeyListener(new KeyAdapter()
				{
			@Override
			public void keyReleased(KeyEvent arg0) {  
				
				try {
					
					
					String selection=(String)box.getSelectedItem();  
					String query="Select Staropramen,Heineken,Tuborg,Budweiser,DraftBeer,Coffe,HotC,Tea,Jack,BrandyApple,BrandyPlum,BrandyPear,WineG,WineB,Cola,Total,Tax,Date,Time from D where "+selection+"=?";  
					 
					PreparedStatement pst=connection.prepareStatement(query);
					 pst.setString(1, searchField.getText());  
					ResultSet rs=pst.executeQuery();  
					table.setModel(DbUtils.resultSetToTableModel(rs));  
					
					pst.close();
					rs.close();
					
				}catch(Exception n) {
					n.printStackTrace();
				}
			}
			});
	}
	
	
	
	public void loadData(JButton load)
	{
		load.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							connection=sqliteConnection.dbConnector();
							
String query="select Staropramen,Heineken,Tuborg,Budweiser,DraftBeer,Coffe,HotC,Tea,Jack,BrandyApple,BrandyPlum,BrandyPear,WineG,WineB,Cola,Total,Tax,Date,Time from D"; 
							PreparedStatement pst=connection.prepareStatement(query);
							ResultSet rs=pst.executeQuery();  
		
							
							
							table.setModel(DbUtils.resultSetToTableModel(rs));  
							
							pst.close();
							rs.close();
							
							
							
						}catch(Exception w) {
							w.printStackTrace();
						}
						
					}
			
				}
				
				);
	}
		
		
	
	
	public SecondWindow()
	{
		JFrame frame = new JFrame("Caffe Management System");
		frame.getContentPane().setLayout(null);
		frame.setSize(1000,700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new java.awt.Color(51,153,255));
		
		
		table = new JTable();
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(150, 100,650,550);
		
		box = new JComboBox();
		box.addItem("Date");
		box.addItem("Time");
		box.setSize(100, 20);
		box.setLocation(150, 76);
		
		load = new JButton("Load");
		load.setSize(100,20);
		load.setLocation(699,76);
		
		search = new JLabel("Search");
		search.setSize(100,40);
		search.setLocation(280,65);
		search.setFont(search.getFont().deriveFont(15.0f));
		
		
		searchField = new JTextField("Enter date or time");
		searchField.setSize(315,20);
		searchField.setLocation(350,76);
		
		loadData(load);
		searchData(searchField);
		
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(box);
		frame.getContentPane().add(load);
		frame.getContentPane().add(search);
		frame.getContentPane().add(searchField);
		
		frame.setVisible(true);
	}
	
}
