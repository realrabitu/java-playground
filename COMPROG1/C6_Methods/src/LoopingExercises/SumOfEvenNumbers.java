package LoopingExercises;

import java.util.Scanner;

public class SumOfEvenNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int input = sc.nextInt();
		int result = addEven(input);
		System.out.println("The sum is: " + result);
		// 10. Write a program to find sum of all even numbers between 1 to n
	}

	public static int addEven(int n) {
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			if (i % 2 == 0)
				sum += i;
			// else
			// continue;
		}
		return sum;
	}
}
