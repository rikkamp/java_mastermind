import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Random;

public class MasterMind extends JFrame implements ActionListener {
	private JFrame frame = new JFrame("Mastermind");
	private JLabel text, result;
	private JTextField input;
	private JButton submit, start, reset;
	private int[] number;
	
	public MasterMind() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds((int) screenSize.getWidth() - 200, 0 , 200, 100);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		MasterMind screen = new MasterMind();
		screen.createGame();
		screen.setVisible(true);
	}
	
	private void createGame () {
		//basis screen
		Container window = this.getContentPane();
		window.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JPanel head = new JPanel();
		// text
		int[] number;
		Random random = new Random();
		number = new int[] {random.nextInt(9), random.nextInt(9), random.nextInt(9), random.nextInt(9)};
		text = new JLabel();
		text.setText("<html><body>Hallo en welkom bij mastermind."
				+ "<br>"
				+ "<br>"
				+ "Het spel werkt zeer makkelijk. Je kan hieronder een 4 cijferig getal invoeren \r\n"
				+ "Bij het opstarten van dit spel is er een 4 cijferig nummer gemaakt <br>"
				+ "Als je het goed hebt komt er een C in het scherm. <br>"
				+ "Als je het fout hebt komt er een X in je scherm. <br>"
				+ "Als het getal wel terug komt in de reeks maar niet op de goede plek komt er een I. </body></html>");
		// start button
		start = new JButton("beginnen");
		start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				text.setVisible(false);
				start.setVisible(false);
				submit = new JButton("opsturen");
				input = new JTextField(25);
				result = new JLabel("Nog niets ingevuld");
				c.gridy = 1;
				window.add(input, c);
				c.gridy = 2;
				window.add(result, c);
				c.gridy = 3;
				window.add(submit, c);
				
				submit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int inputValue = Integer.parseInt(input.getText());
						char[] answer = game(inputValue, number);
						String text = new String(answer);
						if(answer[0] == 'C' && answer[1] == 'C' && answer[2] == 'C' && answer[3] == 'C') {
							result.setText("gelukt wilt u nog eens ?");
							c.gridy = 3;
							reset= new JButton("Reset");
							window.add(reset, c);
							reset.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									reset.setVisible(false);
									submit.setVisible(false);
									input.setVisible(false);
									result.setVisible(false);
									createGame();
								}
							});
						} else {
							result.setText(text);
						}
					}
					
				});
			}
			
		});
		
		// toevoegen aan scherm
		c.gridy = 0;
		head.add(text);
		window.add(head, c);
		c.gridy = 1;
		window.add(start,c);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	private char[] game (int value, int[] number) {
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

}
