import java.util.Scanner;
public class One_doWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int input = 0;
		int ctr = 0;
		do { 
			System.out.print("Enter number: ");
			input = sc.nextInt();
			ctr++;
			if (input < 0) 
				continue;
			sum = input + sum;
		} while(ctr != 5);
			
	
		System.out.println("Sum: " + sum);
	}
}
	
/* while (ctr != 5) {
System.out.print("enter 5 positive numbers: ");
input = sc.nextInt();
if (input >= 0) {
	sum = input + sum;
}
ctr++;
*/