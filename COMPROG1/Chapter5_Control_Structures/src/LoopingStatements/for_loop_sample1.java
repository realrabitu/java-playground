package LoopingStatements;
import java.util.Scanner;

public class for_loop_sample1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int input = sc.nextInt();
		for (int i = 1; i <= input; i++) {
			for (int j = 0; j <= 10; j++) 
				System.out.print(j * i + "  ");
			System.out.println();
		}
		
	}
}
