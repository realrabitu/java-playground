package group3_threePointTwo;

public class OperatorPrecedence {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = 30;


		// (a < b) and (b > c) run BEFORE &&
		boolean test1 = a < b && b > c;
		System.out.println("Test 1 (Relational vs Logical): " + test1); // false (true && false)


		// b == 20 && c == 10 runs BEFORE the || on the left
		boolean test2 = a == 10 || b == 20 && c == 10;
		System.out.println("Test 2 (&& outranks ||): " + test2); // true (true || false)

		// Forces || to run before &&
		boolean test3 = (a == 10 || b == 10) && c == 10;
		System.out.println("Test 3 (Parentheses Override): " + test3); // false (true && false)

	}

}
