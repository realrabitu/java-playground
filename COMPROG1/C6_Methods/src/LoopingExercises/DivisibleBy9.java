package LoopingExercises;

public class DivisibleBy9 {
	public static void main(String[] args) {
		// Write a program to find number and sum of all integer between 100 and 200
		// which are divisible by 9
		System.out.println("The numbers between 100 and 200 which are divisible by 9 are:");
		displayNumbers();
		int result = findSum();
		System.out.println("The sum of all numbers between 100 and 200 which are divisible by 9 is: " + result);

	}

	public static void displayNumbers() {
		int num = 100;
		while (num <= 200) {
			if (num % 9 == 0)
				System.out.println(num);
			num++;
		}
	}

	public static int findSum() {
		int num = 100;
		int sum = 0;
		while (num <= 200) {
			if (num % 9 == 0)
				sum += num;
			num++;
		}
		return sum;
	}
}
