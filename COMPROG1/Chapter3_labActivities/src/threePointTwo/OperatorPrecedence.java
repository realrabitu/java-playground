package threePointTwo;

public class OperatorPrecedence {

	public static void main(String[] args) {
		// Precedence of logical and relational operators
		// Logical operators: &&, ||, !
		// Relational operators: ==, !=, >, <, >=, <=
		int a = 10;
		int b = 13;
		int c = 15;
		int d = 17;
		int e = 19;
		int f = 7;
		boolean result = a < b || c > d && e < f;
		              // true     false    false
		// According to operator precedence, < and > have higher precedence, so they get evaluated first
		// Then, && has higher precedence than || so it gets evaluated first
		// In this instance, false && false = false
		// Then, true || false (from earlier &&) = true
		// So the whole statement is true
		System.out.println("Result: " + result);
		

	}

}
