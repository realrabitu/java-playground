package seven_one;

public class LargestElement {

	public static void main(String[] args) {
		int numbers[] = {1,2,3,4,5};
		int max = numbers[0];

		for (int number : numbers) {
			if (number > max) {
				max = number;
			}
		}
		System.out.println("Largest element: " + max);
	}

}
