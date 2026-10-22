package LoopingExercises;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of terms: ");
		int n = sc.nextInt();
		displayFibonacci(n);

	}

	private static void displayFibonacci(int n) {
		int currentValue = 0, nextValue = 1;
		for (int i = 1; i <= n; i++) {
			System.out.println(currentValue + " ");
			int next = currentValue + nextValue;
			currentValue = nextValue;
			nextValue = next;
		}

	}

}
