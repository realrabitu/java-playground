package seven_one;

public class AverageArray {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5};
		int sum = 0;
		
		for (int number : numbers) {
			sum += number;
		}
		double average = (double)sum / numbers.length;
		System.out.println("Average of array elements: x" + average);
	}

}
