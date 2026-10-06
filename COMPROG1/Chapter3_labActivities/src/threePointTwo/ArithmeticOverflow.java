package threePointTwo;

public class ArithmeticOverflow {

	public static void main(String[] args) {
		int max = Integer.MAX_VALUE; // 2,147,483,647
		int result = max + 1;
		System.out.println(result); // -2,147,483,648
	}

}
