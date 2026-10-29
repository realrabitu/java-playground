package MethodPrograms;

import java.util.Scanner;

public class Method2 {
	Scanner sc = new Scanner(System.in);
	int n, high;
	void main() {
		System.out.println("Enter 5 numbers: ");
		n = sc.nextInt();
		high = n;
		for (int i = 1; i < 5; i++) {
			n = sc.nextInt();
			checkHigh(n);
		}
		System.out.println("The highest number is: " + high);
		
	}
	int checkHigh(int num) {
		if (num > high)
			high = num;
		return high;
	}
}
