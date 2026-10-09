package fourPointTwo;
import java.util.Scanner;
public class Five_MinutesToSeconds {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter time in minutes: ");
		double minutes = input.nextDouble();
		
		double seconds = minutes * 60;
		
		System.out.println(minutes + " minutes is equal to " + seconds + " seconds.");
		input.close();
		


	}

}
