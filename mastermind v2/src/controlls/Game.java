package controlls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.stream.IntStream;

import javax.swing.*;

public class Game {
	
	public Game() {
		// TODO Auto-generated constructor stub
	}

	
	public char[] checker(int value, int[] number) {
		char answer[] = new char[] {'X', 'X', 'X', 'X'};
		for ( int i = 0; i<number.length; i++) {
			String num = Integer.toString(value);
			int part = Integer.parseInt(num.substring(i, i + 1));
			boolean contains = IntStream.of(number).anyMatch(x -> x == part);
			if(part == number[i]) {
				answer[i] = 'C';
			} else if(contains) {
				answer[i] = 'I';
			} else {
				answer[i] = 'X';
			}
		}
		return answer;
	}
	
	public void popup (long id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost/java_mastermindv2","root","");
			stmt = conn.prepareStatement("UPDATE users Set score = score + 1 WHERE id = ?");
			stmt.setLong(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
	         // log this error
		}
		
    	int dialogButton = JOptionPane.showConfirmDialog (null, "Wil je nog een keer?","GELUKT!",JOptionPane.YES_NO_OPTION);
    	if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    	    System.out.println("ja");
    	    Base.restart();
    	} else {
    		System.out.println("Nee");
    	    // no option
    		System.exit(1);
    	}
    }
}
