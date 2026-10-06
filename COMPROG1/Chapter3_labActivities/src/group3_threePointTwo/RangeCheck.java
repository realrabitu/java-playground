package group3_threePointTwo;

public class RangeCheck {

	public static void main(String[] args) {
		int num = 25;
		int min = 10;
		int max = 50;


		boolean inRange = (num >= min) && (num <= max);
		System.out.println("Is " + num + " within [" + min + ", " + max + "]? " + inRange);


	}

}
