package seven_one;

public class CopyArray {
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5};
		int[] copy = new int[original.length];
		
		for (int i = 0; i < original.length; i++) {
			copy[i] = original[i];
		}
		
		System.out.print("Copied array: ");
		for (int number : copy) {
			System.out.print(number + " ");
		}

	}

}
