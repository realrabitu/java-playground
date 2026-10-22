package mmw;

import java.util.Scanner;

public class Summation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = calculateSummation(sc);
		displaySummation(sum);

	}

	public static int calculateSummation(Scanner sc) {
		int sum = 0;
		int input = 0;
		do {
			System.out.print("Enter values: ");
			input = sc.nextInt();
			sum += input;
		} while (input != 0);

		return sum;
	}

	private static void displaySummation(int sum) {
		System.out.println("Your sum is: " + sum);
	}

	static int calculateSumXY(int num, Scanner sc) {
		int X[] = new int[num];
		int Y[] = new int[num];
		int sumXY = 0;
		for (int i = 0; i < num; i++) {
			System.out.print("Enter X: ");
			X[i] = sc.nextInt();
		}
		for (int i = 0; i < num; i++) {
			System.out.print("Enter Y: ");
			Y[i] = sc.nextInt();
		}
		for (int i = 0; i < num; i++)
			sumXY += X[i] * Y[i];
		return sumXY;
	}
}
