package group3_threePointTwo;

public class BitwiseShiftOperators {

	public static void main(String[] args) {
		int x = 8; 		// binary: 0000 1000
		int y = -16; 	// negative number, for >>> demonstration


		System.out.println("x = " + x);
		System.out.println("x << 2 (left shift): " + (x << 2 ));	//multiplies by 2^2
		System.out.println("x >> 2 (right shift): " + (x >> 2 ));	//divides by 2^2
		System.out.println();


		System.out.println("y = " + y);
		System.out.println("y >> 2 (signed right  shift): " + (y >> 2));
		System.out.println("y >>> 2 (unsigned right  shift): " + (y >>> 2));


	}

}
