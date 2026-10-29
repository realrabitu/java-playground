package five_two;

public class Two_CalculateSum {
	public static void main(String[] args) {
		int sum = 0;
		IO.print("Enter a string of numbers: ");
		String num = IO.readln();
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0'; // 0 in ASCII = 48
		}
		IO.println("The sum is: " + sum);
	}

}
