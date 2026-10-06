package threePointTwo;

public class UnaryOperators {

	public static void main(String[] args) {
		// Unary Operators
		// 1. Unary plus (+)
		int a = 10;
		int b = -13;
		System.out.println("Result of +a: "+ (+a)); // No changes as a is already positive
		System.out.println("Result of +b: "+ (+b)); // No changes even if b is negative
		
		// 2. Unary minus (-)
		System.out.println("Result of -a: " + (-a)); // Negates a into a negative value
		System.out.println("Result of -b: " + (-b)); // Negates b into a positive value
		
		// 3. Increment (++)
		// 3a. Postfix
		int num1 = 5;
		int num2 = num1++;
		System.out.println("Value of num1: " + num1); // 6
		System.out.println("Value of num2: " + num2); // 5
		
		// 3b. Prefix
		int num3 = 42;
		int num4 = ++num3;
		System.out.println("Value of num3: " + num3); // 43
		System.out.println("Value of num4: " + num4); // 43
		
		// 4. Decrement (--)
		// 4a. Postfix
		int num5 = 100;
		int num6 = num5--;
		System.out.println("Value of num5: " + num5); // 99
		System.out.println("Value of num6: " + num6); // 100
		
		// 4b. Prefix
		int num7 = 14;
		int num8 = --num7;
		System.out.println("Value of num7: " + num7); // 13
		System.out.println("Value of num8: " + num8); // 13
	}
	

}
