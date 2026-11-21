package seven_two;

public class SecondLargest {
	public static void main(String[] args) {
		int[] arr = {4, 5, 1, 2, 3, 6};
       int largest = Integer.MIN_VALUE;
       int second = Integer.MIN_VALUE;
       for (int i = 0; i < arr.length; i++) {
           if (arr[i] > largest) {
               second = largest;
               largest = arr[i];
           } else if (arr[i] > second && arr[i] != largest) {
               second = arr[i];
           }
       }
       if (second == Integer.MIN_VALUE) {
           System.out.println("No second largest element.");
       } else {
           System.out.println("Second largest: " + second);
       }
   }
}


