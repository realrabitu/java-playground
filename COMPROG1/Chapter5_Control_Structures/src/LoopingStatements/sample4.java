// write a program that will input a non-zero digit
// if the user input a "zero", the program will terminate and will display
// the sum of all inputted numbers
package LoopingStatements;
import java.io.*;
public class sample4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = -1;
		int sum = 0;
		while (input != 0) {
			System.out.print("Enter a non-zero digit: ");
			input = Integer.parseInt(br.readLine());
			sum = input + sum;
		}
		System.out.println("Sum: " + sum);

	}

}
 