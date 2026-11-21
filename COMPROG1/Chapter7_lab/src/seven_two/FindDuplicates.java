package seven_two;
public class FindDuplicates {
    public static void main(String[] args) {

        int[] numbers = {1, 5, 3, 2, 5, 1, 7, 3};

        System.out.println("Duplicate elements:");

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] == numbers[j]) {
                    System.out.println(numbers[i]);
                }

            }
        }
    }
}
