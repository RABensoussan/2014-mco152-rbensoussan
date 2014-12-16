package bensoussan.acm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NthLargestValue {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int number = -1;
		while (number < 1 || number > 1000) {
			number = keyboard.nextInt();
			keyboard.nextLine();
		}
		for (int i = 0; i < number; i++) {
			String input = keyboard.nextLine();
			ArrayList<Integer> list = new ArrayList<Integer>();
			String[] str = input.split(" ");
			for (int j = 1; j < str.length; j++) {
				list.add(Integer.parseInt(str[j]));
			}
			Collections.sort(list);
			System.out.println(str[0] + " " + list.get(7));
		}
		keyboard.close();
	}

}