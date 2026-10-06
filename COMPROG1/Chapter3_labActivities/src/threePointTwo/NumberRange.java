package threePointTwo;

public class NumberRange {

	public static void main(String[] args) {
		int num1 = 47;
		int min = 18;
		int max = 60;
		// Is num1 at least 18 and at most 60?
		boolean result = (num1 >= min) && (num1 <= max);
		System.out.println("The result is: " + result); // true

	}

}
