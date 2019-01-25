package Indir;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;
public class sqliteConnection {
	
	
	
Connection conn=null; 
	
	public static Connection dbConnector() {
		
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Indir\\Desktop\\CaffeManagementSystem\\CoffeMSystem\\Drinks.db");
			JOptionPane.showMessageDialog(null,"Database is connected");
			return conn;
			
		}catch(Exception l) {
			JOptionPane.showMessageDialog(null,"Database is not connected");
			return null;  
			
		}
		
	}

}
