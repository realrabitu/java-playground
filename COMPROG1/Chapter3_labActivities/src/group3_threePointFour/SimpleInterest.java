package group3_threePointFour;

public class SimpleInterest {

	public static void main(String[] args) {
		// Simple interest formula: I = Prt
		int principal = 1000;
		float rate = 0.10f; // 10% = 0.10
		int time = 5; // 5 years
		float interest = principal * rate * time;
		System.out.println("The interest is: " + interest); // 500.0
	}

}
