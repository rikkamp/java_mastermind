import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class yeet extends JFrame
implements ActionListener{
	private JFrame frame = new JFrame("Mastermind");
	private int width = 500;
	private JTextField input = new JTextField(4);
	private JLabel melding = new JLabel();
	private int height = 500;
	
	public yeet() {
		setSize(this.width + 100, this.height + 100);
	}
	
	public static void main(String[] args) {
		yeet screen = new yeet();
		screen.createGUI();
		screen.setVisible(true);
	}

	private void createGUI() {
		Container screen = this.getContentPane();
		// TODO Auto-generated method stub
       this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Container window = frame.getContentPane();
       window.setLayout(new FlowLayout());
       JButton send = new JButton("Send");
       send.addActionListener(this);
       JPanel section = new JPanel();
       section.add(input); // Adds Button to content pane of frame
       section.add(melding); // Adds Button to content pane of frame
       section.add(send); // Adds Button to content pane of frame
       screen.add(section);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String dieantwoord = "U yeete: " + input.getText();
		melding.setText(dieantwoord);
	}

}
