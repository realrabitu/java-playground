package group3_threePointTwo;

public class UnaryOperators {

	public static void main(String[] args) {
		//Unary Operators
		int a = 15;
		int b = -15;

		System.out.println("The use of Unary Plus");
		System.out.println("+a: " + (+a));
		System.out.println("+b: " + (+b));
		// a+ keeps the signs even though it's negative or positive

		System.out.println("\nThe use of Unary Minus");
		System.out.println("-a: " + (-a)); // -15
		System.out.println("-b: " + (-b)); // 15
		// it changes a positive value into a negative value and vice versa

		System.out.println("\nThe use of Increment");
		//prefix. increments first, then returns new incremented value
		System.out.println("++a: " + (++a)); // prints 16 from 15
		//post fix. returns current value first, then increments
		System.out.println("a++: " + (a++)); // prints 16 then increments to 17
		
		System.out.println("\nThe use of Decrement");
		//prefix. decrements first, then returns new value
		System.out.println("--a: " + (--a)); // from 17, a gets decremented to 16 then gets printed
		//post fix. returns current value first, then decrements
		System.out.println("a--: " + (a--)); // prints 16 then decrements to 15

	}

}
