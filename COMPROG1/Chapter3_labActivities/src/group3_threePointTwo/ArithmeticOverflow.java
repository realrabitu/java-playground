package group3_threePointTwo;

public class ArithmeticOverflow {

	public static void main(String[] args) {
		int maxInt = Integer.MAX_VALUE; // 2147483647


		System.out.println("Max Integer value: " + maxInt);

		int overflowResult = maxInt + 1;
		System.out.println("Value after adding 1 (Overflow): " + overflowResult); // -2147483648


	}

}
