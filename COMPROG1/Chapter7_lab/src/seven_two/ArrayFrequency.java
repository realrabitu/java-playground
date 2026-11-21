package seven_two;

public class ArrayFrequency {

    public static void main(String[] args) {

        int[] numbers = {2, 3, 2, 5, 3, 2, 4, 5};

        boolean[] visited = new boolean[numbers.length]; // 8

        for (int i = 0; i < numbers.length; i++) {

            if (visited[i]) {
                continue;
            }

            int count = 1;

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] == numbers[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(numbers[i] + " occurs " + count + " times");
        }
    }
}