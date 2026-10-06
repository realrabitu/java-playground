package group3_threePointTwo;

public class TernaryOperator {

	public static void main(String[] args) {
		int a = 10;
		int b = 42;
		int c = 27;


		int max = a > b ? (a > c ? a : c) : (b > c ? b : c);


		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.print("Maximum: " + max);


	}

}
