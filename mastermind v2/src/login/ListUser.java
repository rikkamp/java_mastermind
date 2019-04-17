package login;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListUser {
	JFrame screen = new JFrame();
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();
	JPanel container = new JPanel(new GridBagLayout());
	String[] columnNames = {"id", "name", "score"};

	public ListUser() {
		this.screen = screen;
		screen.setVisible(true); 
		screen.setSize(width, height);
		screen.setLayout(null);
		
		// add close listener
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setTitle("Mastermind v2");
		
		// set center container
		container.setBackground(Color.BLUE);
		container.setBounds(width / 2 - 450 , height / 2 - 400 , 900, 800);
//		screen.add(container);
		screen.setVisible(true);
		list();
	}
	
	public static void main(String args[]){
		new ListUser();
	}
	
	public void list () {
		Connection conn = null;
		Statement stmt = null;
		String[][] data = {{}};
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost/java_mastermindv2","root","");
			stmt = conn.createStatement();
			ResultSet row = stmt.executeQuery("SELECT * FROM users");
			ResultSetMetaData md = row.getMetaData();
			while(row.next()) {
				//create id label
				int id = row.getInt(1);
				
				//create name label
				String name = row.getString(2);
				
				// create score label
				int score = row.getInt(3);
				
//				data.({id, name, score});
				
				System.out.println(row.getInt(1)+"  "+row.getString(2)+"  "+row.getInt(3));				
			}
			
			conn.close(); 
			JTable table = new JTable();
			
		}catch(Exception e){ System.out.println(e);}  
		}  
	}
