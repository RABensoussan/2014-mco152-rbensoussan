package bensoussan.acm2;

import java.util.Scanner;

public class MaxSum {

	public static void main(String args[]) {

		Scanner keyboard = new Scanner(System.in);
		int size = keyboard.nextInt();
		int maxSum = 0;
		int[][] bigRectangle = new int[size][size];
		// fill the array
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				while (!keyboard.hasNextInt()) {
					keyboard.next();
				}
				int num = keyboard.nextInt();
				bigRectangle[i][j] = num;
				if (num > maxSum) {
					maxSum = num;
				}
			}
		}
		int sum;
		for (int begX = 0; begX < size; begX++) {
			for (int begY = 0; begY < size; begY++) {
				for (int endX = 0; endX < size; endX++) {
					for (int endY = 0; endY < size; endY++) {
						sum = -128;
						for (int searchX = begX; searchX <= endX; searchX++) {
							for (int searchY = begY; searchY <= endY; searchY++) {
								sum += bigRectangle[searchX][searchY];
							}
							if (sum > maxSum) {
								maxSum = sum;
							}
						}
					}
				}
			}
		}

		System.out.print(maxSum);
		keyboard.close();
	}
}
