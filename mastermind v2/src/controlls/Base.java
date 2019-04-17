package controlls;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.border.*;

public class Base implements ActionListener {
	JFrame screen = new JFrame();
	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = gd.getDisplayMode().getWidth();
	int height = gd.getDisplayMode().getHeight();
	JPanel container = new JPanel(new GridBagLayout());
	static JLabel input = new JLabel();
	static JLabel Answer = new JLabel();
	static JLabel user = new JLabel();
	public static int[] number;
	boolean tried = false;
	long id;
	long score;
	
	public Base(Long id, String name, Long score) {
		this.score = score;
		this.id = id;
		
		user.setText("hallo "+ name + " uw score is: " + this.score);
		
		user.setFont(user.getFont().deriveFont(24.0f));
		user.setForeground(Color.black);
		user.setVisible(true);
		user.setSize(550, 130);
		
		screen.setLayout(new FlowLayout());
		// create random number
		Random random = new Random();
		number = new int[] {random.nextInt(9), random.nextInt(9), random.nextInt(9), random.nextInt(9)};
		checker();
		// set visibility true and set size to screen.
		screen.setVisible(true); 
		screen.setSize(width, height);
		screen.setLayout(null);
		
		// add listener in order to close the frame when you press the close button.
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set title
		screen.setTitle("Mastermind v2");
		
		// make a container in the center of the screen
		container.setBackground(Color.BLUE);
		container.setBounds(width / 2 - 450 , height / 2 - 400 , 900, 800);
		
		// create input label.
		input.setBackground(Color.WHITE);
		input.setSize(230, 130);
		input.setText("Klik op een nummer");
		input.setLocation(width / 2 - 115 , 0);
		input.setFont(input.getFont().deriveFont(24.0f));
		input.setHorizontalAlignment(JLabel.CENTER);
		
		// add username with score
		
		// create answer field
		Answer.setBackground(Color.WHITE);
		Answer.setText("XXXX");
		Answer.setSize(230, 130);
		Answer.setLocation(width / 2 - 115 , 25);
		Answer.setFont(input.getFont().deriveFont(24.0f));
		Answer.setHorizontalAlignment(JLabel.CENTER);
		
		//add buttons
		
			//create buttons
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton buttonC = new JButton("C");
		JButton button9 = new JButton("9");
		JButton buttonOK = new JButton("OK");
		JButton button0 = new JButton("0");
		
			// give buttons size and font size
		button1.setPreferredSize(new Dimension(50,50));
		button1.setFont(button1.getFont().deriveFont(24.0f));
		
		button2.setPreferredSize(new Dimension(50,50));
		button2.setFont(button1.getFont().deriveFont(24.0f));
		
		button3.setPreferredSize(new Dimension(50,50));
		button3.setFont(button1.getFont().deriveFont(24.0f));
		
		button4.setPreferredSize(new Dimension(50,50));
		button4.setFont(button1.getFont().deriveFont(24.0f));
		
		button5.setPreferredSize(new Dimension(50,50));
		button5.setFont(button1.getFont().deriveFont(24.0f));
		
		button6.setPreferredSize(new Dimension(50,50));
		button6.setFont(button1.getFont().deriveFont(24.0f));
		
		button7.setPreferredSize(new Dimension(50,50));
		button7.setFont(button1.getFont().deriveFont(24.0f));
		
		button8.setPreferredSize(new Dimension(50,50));
		button8.setFont(button1.getFont().deriveFont(24.0f));
		
		button9.setPreferredSize(new Dimension(50,50));
		button9.setFont(button1.getFont().deriveFont(24.0f));
		
		buttonC.setPreferredSize(new Dimension(50,50));
		buttonC.setFont(button1.getFont().deriveFont(24.0f));
		
		buttonOK.setPreferredSize(new Dimension(50,50));
		buttonOK.setFont(button1.getFont().deriveFont(24.0f));
		
		button0.setPreferredSize(new Dimension(50,50));
		button0.setFont(button1.getFont().deriveFont(24.0f));
		
		//add listeners
		button1.addActionListener(this);

		button2.addActionListener(this);
		
		button3.addActionListener(this);
		
		button4.addActionListener(this);
		
		button5.addActionListener(this);
		
		button6.addActionListener(this);
		
		button7.addActionListener(this);
		
		button8.addActionListener(this);
		
		button9.addActionListener(this);
		
		button0.addActionListener(this);
		
		buttonC.addActionListener(this);
		
		buttonOK.addActionListener(this);
		
		//validator
		
		//handler
		
		// add everything to the screen
		container.setLayout(new GridLayout(4, 3, 100, 100));
		container.setBorder(new EmptyBorder(25, 25, 25, 25));
		container.add(button1);
		container.add(button2);
		container.add(button3);
		container.add(button4);
		container.add(button5);
		container.add(button6);
		container.add(button7);
		container.add(button8);
		container.add(button9);
		container.add(buttonC);
		container.add(button0);
		container.add(buttonOK);
		screen.add(user);
		screen.add(Answer);
		screen.add(input);
		screen.add(container);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void checker () {
		if (number[0] == 0) {
			Random random = new Random();
			number[0] = random.nextInt(9);
			checker();
		}
	}
	
	public static void restart () {
		Random random = new Random();
		number = new int[] {random.nextInt(9), random.nextInt(9), random.nextInt(9), random.nextInt(9)};
		input.setText("Klik op een nummer");
		Answer.setText("XXXX");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(input.getText() == "Klik op een nummer") {
			input.setText("");
		}
		// add number if there are not 4 yet
			
			JButton button = null;
		
		if(e.getSource() instanceof JButton) {
			button = (JButton)e.getSource();
		}
		
		if(button != null) {
			
			if(button.getText() != "OK" && button.getText() != "C") {
				if (tried) {
					input.setText("");
					tried = false;
				}
				if(input.getText().length() < 4) {
					input.setText(input.getText() + button.getText());
				}
			}
			
			// check function
			if(button.getText() == "C") {
				// remove last item function
				if(input.getText().length() > 0) {
					input.setText(input.getText().substring(0, input.getText().length() - 1));
				}
			}
			
			if(button.getText() == "OK") {
				// remove last item function
				if (input.getText().length() == 4) {
					tried = true;
					Game spel = new Game();
					char[] answer = spel.checker(Integer.parseInt(input.getText()),number);
					if(answer[0] == 'C' && answer[1] == 'C' && answer[2] == 'C' && answer[3] == 'C') {
						System.out.println("geluk");
						String answerText = String.valueOf(answer);
						Answer.setText(answerText);
						spel.popup(this.id);
						this.score =+ 1;
					} else {
						String answerText = String.valueOf(answer);
						Answer.setText(answerText);
					}
				}
			}
		}
	}
}
