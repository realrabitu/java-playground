package group3_threePointTwo;

public class LogicalOperators {
	public static void main(String[] args) {
		// The short-circuit behavior of logical operators
		int a = 10;
		int b = 5;
		
		System.out.println("Logical Operators AND (&&) Short-circuit");
		boolean AndResult = (a < b) && (a++ > b);
		System.out.println("Results: " + AndResult);
		System.out.println("a value: " + a);
		/* it should increment after printing but didn't due to the short circuit behavior,
		that if the left part returns false the it shuts down and doesn't continue.*/

		System.out.println("\nLogical Operators AND (||)");
		boolean OrResult = (a < b) || (a++ > b);
		System.out.println("Results: " + OrResult);
		System.out.println("a value: " + a);
		/* As you can see, even though the first part is false it still returns true
		 * since the right part is true. The OR operator evaluates the true value even
		 * if there's a false present
		 * 
		 * And a gets incremented to 11 anyway.*/

	}
}
