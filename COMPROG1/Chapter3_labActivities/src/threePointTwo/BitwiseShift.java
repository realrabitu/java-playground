package threePointTwo;

public class BitwiseShift {

	public static void main(String[] args) {
		int a = 8;
		int leftShift = a << 3;
		System.out.println(leftShift); // 8 * 2^3 = 64
		int rightShift = a >> 3; // 8 / 2^3 = 1
		System.out.println(rightShift);
		int unsignedRightShift = a >>> 3;
		System.out.println(unsignedRightShift); // 1

	}

}
