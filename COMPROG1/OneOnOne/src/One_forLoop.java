import java.util.Scanner;
public class One_forLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			System.out.print("Enter number: ");
			input = sc.nextInt();
			if (input < 0)
				continue;
			sum = input + sum;
		}
		System.out.println("Sum: " + sum);

	}

}
