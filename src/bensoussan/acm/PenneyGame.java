package bensoussan.acm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PenneyGame {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int number = -1;
		while (number < 1 || number > 1000) {
			number = keyboard.nextInt();
		}

		System.out.println();
		
		for (int times = 0; times < number; times++) {
			keyboard.nextInt();
			keyboard.nextLine();
			
			Map<String, Integer> counter = new HashMap<String, Integer>();
			counter.put("TTT", 0);
			counter.put("TTH", 0);
			counter.put("THT", 0);
			counter.put("THH", 0);
			counter.put("HTT", 0);
			counter.put("HTH", 0);
			counter.put("HHT", 0);
			counter.put("HHH", 0);
			
			String sequence = keyboard.nextLine();
			for (int i = 0; i < sequence.length() - 2; i++) {
				String miniseq = sequence.substring(i, i + 3);
				miniseq.toUpperCase();
				Integer count = counter.get(miniseq);
				counter.replace(miniseq, count, ++count);
				}
			
			System.out.println();
			System.out.print((times + 1) + " ");
			System.out.print(counter.get("TTT") + " ");
			System.out.print(counter.get("TTH") + " ");
			System.out.print(counter.get("THT") + " ");
			System.out.print(counter.get("THH") + " ");
			System.out.print(counter.get("HTT") + " ");
			System.out.print(counter.get("HTH") + " ");
			System.out.print(counter.get("HHT") + " ");
			System.out.print(counter.get("HHH"));
		}
		keyboard.close();
	}
}
