package bensoussan.acm2;

import java.util.Scanner;

public class RascalTriangle {

	public static void main(String args[]) {

		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
		while (keyboard.hasNext()) {
			int time = keyboard.nextInt();
			int i = keyboard.nextInt();
			int j = keyboard.nextInt();
			int diagNum = i - j;
			int termInDiag = i - diagNum;
			int answer = (diagNum * termInDiag) + 1;
			System.out.println(time + " " + answer);
		}
		keyboard.close();
		
	}
}
