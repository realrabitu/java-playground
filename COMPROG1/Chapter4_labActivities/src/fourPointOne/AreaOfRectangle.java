package fourPointOne;
import java.util.Scanner;

public class AreaOfRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter length: ");
		int length = sc.nextInt();
		
		System.out.print("Enter width: ");
		int width = sc.nextInt();
		
		int area = length * width;
		System.out.println("Area: " + area);

	}

}
