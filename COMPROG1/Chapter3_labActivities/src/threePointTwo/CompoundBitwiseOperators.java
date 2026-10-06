package threePointTwo;

public class CompoundBitwiseOperators {

	public static void main(String[] args) {
		// 1. Bitwise AND assignment
		int a = 6; // 0110 in binary
		a &= 2; // a = a & 2;
		/* 0110 (6)
		 & 0010 (2)
		 ______
		   0010 = 2
		*/
		System.out.println("a &= 2: " + a); // 2
		
		// 2. Bitwise OR assignment
		int b = 8; // 1000 in binary
		b |= 4; // b = b | 4;
		/* 1000 (8)
		 | 0100 (4)
		_______
		   1100 = 12
		*/
		System.out.println("b |= 4: " + b); // 12
		
		// 3. Bitwise XOR assignment
		int c = 5; // 0101 in binary
		c ^= 3; // 
		/* 0101 (5)
		 ^ 0011 (3)
		 ______
		   0110 = 6
		*/
		System.out.println("c ^= 3: " + c);
	}

}
