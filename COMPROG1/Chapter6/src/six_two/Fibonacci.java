package six_two;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of terms: ");
		int terms = sc.nextInt();
		printFibonacci(terms);
		

	}
	public static void printFibonacci(int n) {
		int a = 0, b = 1;
		
		for (int i = 0; i < n; i++) {
			System.out.print(a + " ");
			int next = a + b;
			a = b;
			b = next;
		}
		System.out.println();
	}


}
