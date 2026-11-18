package six_one;

public class Factorial {
	public static void main(String[] args) {
		int number = 5;
		long result = factorial(number);
		System.out.println("Factorial of " + number + " is " + result);
	}
	public static long factorial(int n) {
		if (n == 0) {
			return 1;
		}
		// recursion
		return n * factorial(n-1);
	}
}
