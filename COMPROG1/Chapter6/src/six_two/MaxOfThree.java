package six_two;

import java.util.Scanner;

public class MaxOfThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any three numbers: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(max(a,b,c));
		//System.out.println(max(-5, -1, -8));
		//System.out.println(max(7, 7, 3));
		
	}

	public static int max(int a, int b, int c) {
		int max = a;
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}
}
