package fourPointTwo;
import java.util.Scanner;

public class Four_Maximum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input first number: ");
		int num1 = sc.nextInt();
		System.out.print("Input second number: ");
		int num2 = sc.nextInt();
		int max = num1 > num2 ? num1 : num2;
		System.out.println("The maximum of the two numbers is: " + max);
	}
}
