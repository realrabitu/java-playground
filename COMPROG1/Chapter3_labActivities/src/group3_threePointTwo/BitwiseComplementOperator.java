package group3_threePointTwo;

public class BitwiseComplementOperator {

	public static void main(String[] args) {
		// ~num1 = -(num1 + 1)
		int num1 = 5; // 0101 in binary
		System.out.println("~num: " + (~num1)); // -6 (1010) in binary

		int num2 = -6; // 1010 in binary
		System.out.println("~num: " + (~num2)); // 5 (0101) in binary

		int num3 = 4; // 0100 in binary
		System.out.println("~num: " + (~num3));

		int num4 = -5; // 1011 in binary
		System.out.println("~num: " + (~num4));


	}

}
