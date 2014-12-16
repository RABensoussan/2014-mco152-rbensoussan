package bensoussan.acm2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HappyPrimes {

	private int num;

	public HappyPrimes(int num) {
		this.num = num;
	}

	public boolean isHappy() {
		int sum = this.num;
		while (sum > 9) {
			String[] values = String.valueOf(sum).split("");
			sum = 0;
			for (int j = 0; j < values.length; j++) {
				sum += Integer.parseInt(values[j])
						* Integer.parseInt(values[j]);
			}
		}
		if (sum == 1 || sum == 7) {
			return true;
		}
		return false;
	}

	public boolean isPrime() {
		if (num == 2) {
			return true;
		}
		if (num == 1 || num % 2 == 0) {
			return false;
		}
		for (int i = 3; i < num; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);

		int numTimes = -1;
		while (numTimes < 0) {
			try {
				numTimes = keyboard.nextInt();
				keyboard.nextLine();
			} catch (InputMismatchException e) {
				keyboard.next();
			}
		}

		for (int i = 0; i < numTimes; i++) {
			keyboard.next();
			String input = keyboard.next();
			System.out.println();
			System.out.print(i + 1 + " ");
			System.out.print(input + " ");
			HappyPrimes number = new HappyPrimes(Integer.parseInt(input));
			if (number.isPrime() && number.isHappy()) { // did it separately
														// because no need to
				// check for both; if not one, then not
				// applicable
				System.out.print("YES");
			} else {
				System.out.print("NO");
			}

		}

		keyboard.close();
	}
}