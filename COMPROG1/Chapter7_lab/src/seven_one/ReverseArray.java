package seven_one;

public class ReverseArray {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5};
		int length = numbers.length;
		
		for (int i = 0; i < length / 2; i++) {
			int temp = numbers[i];
			numbers[i] = numbers[length - 1 - i];
			numbers[length - 1 - i] = temp;
		}
		
		System.out.println("Reversed array: ");
		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}

}
