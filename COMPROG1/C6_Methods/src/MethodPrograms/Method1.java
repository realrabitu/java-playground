package MethodPrograms;

import java.util.Scanner;

public class Method1 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		displayHigh();
	}
	static void displayHigh() {
		int n, max;
		System.out.println("Enter 10 numbers: ");
		n = sc.nextInt();
		max = n;
		for (int i = 1; i < 10; i++) {
			n = sc.nextInt();
			if (n > max)
				max = n;
		}
		System.out.println("The highest number is: " + max);
		
	}

}
