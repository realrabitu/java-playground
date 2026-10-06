package threePointTwo;

public class LogicalOperators {

	public static void main(String[] args) {
		// Short-circuit behavior of logical operators
		// Logical AND (&&)
		int num1 = 5;
		int num2 = 0;
		boolean result1 = (num1 < num2) && (num1++ > num2); /* && (logical AND) skips the right side
		                                        			   since num1 < num2 (5 < 0) is already false. */
		System.out.println("First result: " + result1); // false
		System.out.println("Value of num1: " + num1); // num1 is still 5 since it was skipped.
		
		// Logical OR (||)
		int num3 = 10;
		int num4 = 11;
		boolean result2 = (num3 < num4) || (num3-- > num4); /* 10 > 11 is false, so it evaluates the right side 
															   10-- > 11 is false but 10-- gets evaluated (decrement) */
		System.out.println("Second result: " + result2); // true
		System.out.println("Value of num3: " + num3);  // num3 is STILL 10 since the second operand
													   // was NOT evaluated
		
		
	}
}
