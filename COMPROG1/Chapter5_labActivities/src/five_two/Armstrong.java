package five_two;

import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		
		int a = number / 100;
		int b = (number / 10) % 10;
		int c = number % 10;
		
		int sum = a * a * a + b * b * b + c * c * c;
		if (sum == number) {
			System.out.println(number + " is an Armstrong number.");
		} else {
			System.out.println(number + " is not an Armstrong number.");
		}

	}

}
