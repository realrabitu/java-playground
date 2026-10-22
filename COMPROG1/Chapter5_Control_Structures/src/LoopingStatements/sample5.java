// write a program that will input a non-zero digit
// if the user input a "zero", the program will terminate and will display
// the sum of all inputted numbers
package LoopingStatements;
import java.util.Scanner;
public class sample5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int input = sc.nextInt();
		int result = squareRoot(input);
		if (result == -1)
			System.out.println(input + " is not a perfect square number");
		else 
			System.out.println("The square root is: " + result);
	}
	public static int squareRoot(int num) {
		for (int i = 0; i <= num; i++) {
			if (i * i == num)
				return i;
		}
		return -1;
	}

}

/* 
 * for (int i = 0; i <= 3; i++) {
			if (i != 0) {
				System.out.print("Enter a non-zero digit: ");
				input = Integer.parseInt(br.readLine());
				sum = input + sum;
			}
		}*/
/* for (; input != 0;) {
System.out.print("Enter a non-zero digit: ");
input = Integer.parseInt(br.readLine());
sum = input + sum;
}
*/