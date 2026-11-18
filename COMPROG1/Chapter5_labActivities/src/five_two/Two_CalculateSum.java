package five_two;

import java.util.Scanner;
public class Two_CalculateSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		System.out.print("Enter a string of numbers: ");
		String num = sc.nextLine();
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0'; // 0 in ASCII = 48
		}
		System.out.println("The sum is: " + sum);
	}

}
