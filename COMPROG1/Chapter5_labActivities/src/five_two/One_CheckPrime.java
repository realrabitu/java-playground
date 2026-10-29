package five_two;

import java.util.Scanner;

public class One_CheckPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Algorithm taken from a C program
		boolean isPrime = true;
		IO.print("Enter a number: ");
		int num = sc.nextInt();
		if (num == 0 || num == 1)
			isPrime = false;
			
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime)
			IO.println(num + " is a prime number.");	
		else 
			IO.println(num + " is not a prime number.");

	}

}
