package seven_one;

public class SumArray {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5};
		int sum = 0;
		
		for (int number : numbers ) {
			sum += number;
		}
		
		System.out.println("Sum of array elements: " + sum);

	}

}
