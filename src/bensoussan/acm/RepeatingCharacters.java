package bensoussan.acm;

import java.util.Scanner;

public class RepeatingCharacters {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int n = 0;
		while (n < 1 || n > 1000) {
			n = keyboard.nextInt();
			keyboard.nextLine();
		}
		while (keyboard.hasNext()) {
			int counter = keyboard.nextInt();
			int r = keyboard.nextInt();
			String seq = keyboard.next();
			System.out.println();
			System.out.print(counter + " ");
			for (int i = 0; i < seq.length(); i++) {
				for (int j = 0; j < r; j++) {
					System.out.print(seq.charAt(i));
				}
			}
		}
		keyboard.close();
	}

}
