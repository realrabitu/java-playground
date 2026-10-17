// write a program that will input a non-zero digit
// if the user input a "zero", the program will terminate and will display
// the sum of all inputted numbers
package LoopingStatements;
import java.util.Scanner;
public class sample5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = -1;
		int sum = 0;
		int ctr = 0;
		
		for (;;) {
			System.out.print("Enter a non-zero digit: ");
			input = sc.nextInt();
			ctr++;
			if (input == 0)
				continue;
			sum = input + sum;
			
			if (ctr == 5)
				break;
		}
		
		
		System.out.println("Sum: " + sum);

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