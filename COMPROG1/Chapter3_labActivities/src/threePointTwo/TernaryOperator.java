package threePointTwo;

public class TernaryOperator {

	public static void main(String[] args) {
		// Ternary operator (?:)
		// Maximum of three numbers
		int num1 = 14;
		int num2 = 15;
		int num3 = 6;
		// this works although it suffers from readability issues
		int max = (num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3));
		// this is much more readable
		int temp = num1 > num2 ? num1 : num2; 
		int max2 = temp > num3 ? temp : num3;
		System.out.println("The maximum is: " + max);
		System.out.println("The maximum is: " + max2);
		
		

	}

}
