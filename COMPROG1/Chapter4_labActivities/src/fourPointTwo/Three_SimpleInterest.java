package fourPointTwo;
import java.util.Scanner;

public class Three_SimpleInterest {

	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		
		System.out.print("Enter principle: ");
		double principle = Input.nextDouble();
		
		System.out.print("Enter anual: ");
		double anual = Input.nextDouble();
		
		System.out.print("Enter time: ");
		double time = Input.nextDouble();
		
		double Interest = (principle * anual * time)/100;
		System.out.print("Interest: " + Interest);

		
		


	}

}
