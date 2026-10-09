package fourPointTwo;
import java.util.Scanner;

public class Two_Circumference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter The Radius: ");
		double radius = sc.nextDouble();
		
		double circumference = 2 * Math.PI* radius;
		System.out.println("The circumference is: " + circumference);

	}

}
