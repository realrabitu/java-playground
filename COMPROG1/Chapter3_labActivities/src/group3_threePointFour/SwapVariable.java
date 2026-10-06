package group3_threePointFour;

public class SwapVariable {

	public static void main(String[] args) {
		int a = 7;
		int b = 10;
		System.out.println("Before swap: a = " + a + ", b = " + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println("After swap: a = " + a + ", b = " + b);
	}
}
