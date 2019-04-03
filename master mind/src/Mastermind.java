import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Random;

public class Mastermind {
	static Scanner input = new Scanner(System.in);
	static Random random = new Random();
	static int[] number = {random.nextInt(9), random.nextInt(9), random.nextInt(9), random.nextInt(9)};
	
	public Mastermind() {
		super();
	}
	
	public static void main(String[] args) {
		spel();
	}
	
	public static void spel() {
		char result[] = chance();
		String answer = Arrays.toString(result);
			
		if(result[0] == 'C' && result[1] == 'C' && result[2] == 'C' && result[3] == 'C') {
			System.out.println("gelukt einde spel");
		} else {
			System.out.println(answer);
			spel();
		}
	}
	
	static char[] chance() {
		char result[] = new char[4];
		System.out.print("Plaats iets \n");
		if(input.hasNextLine()) {
			String numberInput = input.nextLine().replaceAll("[^\\d.]", "");
			for ( int i = 0; i<number.length; i++) {
				int num = Integer.parseInt(numberInput.substring(i, i + 1));
				boolean contains = IntStream.of(number).anyMatch(x -> x == num);
				if(num == number[i]) {
					result[i] = 'C';
				} else if(contains) {
					result[i] = 'I';
				} else {
					result[i] = 'X';
				}
			}
		}
		return result;
	}
}
