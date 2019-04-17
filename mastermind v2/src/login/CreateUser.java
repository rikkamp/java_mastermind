package login;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import controlls.Base;

public class CreateUser {
	JFrame screen = new JFrame();
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();
	JPanel container = new JPanel(new GridBagLayout());
	JPanel wrapper = new JPanel();
	JTextField input = new JTextField();
	JLabel text = new JLabel("Uw naam");
	JButton confirm = new JButton("confirm");
	Long score = (long) 0;

	public CreateUser() {
		//set screen visible
		screen.setVisible(true); 
		screen.setSize(width, height);
		screen.setLayout(null);
		
		// add close listener
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setTitle("Mastermind v2");
		
		// set center container
		container.setBackground(Color.BLUE);
		container.setBounds(width / 2 - 450 , height / 2 - 400 , 900, 800);
		
		wrapper.setBackground(Color.BLUE);
		wrapper.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		wrapper.setVisible(true);
		
		//get user name
		text.setText("Uw username");
		text.setForeground(Color.white);
		text.setFont(text.getFont().deriveFont(24.0f));
		
		//set styling of input field
		input.setPreferredSize(new Dimension (300, 50));
		
		// add event listener
		confirm.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	String name = input.getText();
		    	create(name);
		    }
		});
		
		// add everything to sceen
		container.setLayout(new GridLayout(1, 3, 100, 100));
		container.setBorder(new EmptyBorder(25, 25, 25, 25));
		wrapper.add(text);
		wrapper.add(input);
		wrapper.add(confirm);
		container.add(wrapper);
		screen.add(container);
	}
	
	public static void main(String args[]){
		new CreateUser();
	}
	
	public void create (String name) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mysql://localhost/java_mastermindv2","root","");
			stmt = conn.prepareStatement("INSERT INTO users (name, score) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, name);
			stmt.setInt(2, 0);
			ResultSet rs = stmt.getGeneratedKeys();
			int affectedRows = stmt.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
			    	new Base(generatedKeys.getLong(1), name, score);
			    	screen.setVisible(false);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
			}
			catch (Exception e) {
		         // log this error
		      }
			finally {
			      try {
			         if (stmt != null) { stmt.close(); }
			      }
			      catch (Exception e) {
			         // log this error
			      }
			      try {
			         if (conn != null) { conn.close(); }
			      }
			      catch (Exception e) {
			         // log this error
			      }
		   }
		}
	}
	
