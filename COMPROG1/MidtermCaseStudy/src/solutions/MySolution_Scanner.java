package solutions;

//The problem: Compute for the net income of a particular employee.
// Required variables: name, position, number of days worked

/* CATEGORIES
 * Manager:  rate = 500 per day
 * Supervisor: rate = 400 per day
 * Employee: 300 per day
 */

// Gross = rate per day * number of days worked

/* BONUS
 * if gross >= 8000 then bonus = 1000
 * if gross >= 5000 then bonus = 750
 * if gross >= 3000 then bonus = 500
 * if gross < 3000 then bonus = 0
 */

// SSS = 10% of gross
// Medicare = 100 pesos

/* TAX
 * if gross >= 7000 then tax = 15% of gross
 * if gross >= 4000 then tax = 10% of gross
 * if gross >= 2000 then tax = 5% of gross
 */

// NET INCOME = gross + bonus - total deduction.
// Display the net income

/* SAMPLE OUTPUT
 * Name: Richard <enter>
 * <m> Manager <s> Supervisor <e> Employee
 * Position: s <enter>
 * Rate: 400
 * No. of Days Worked: 15 <enter>
 * Gross: 6000
 * 
 * Bonus: 750
 * Deductions:
 * 		Tax: 600
 * 		SSS: 600
 * 		Medicare: 100
 * Total Deduction: 1300
 * 
 * Net Income: 5450

 */
import java.util.Scanner;

public class MySolution_Scanner {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Declare and initialize variables within the method scope
		int rate = 0;
		boolean validInput = false;
		
		// Using if and switch
		System.out.print("Name: ");
		String name = input.nextLine();

		System.out.println("<m> Manager <s> Supervisor <e> Employee");
		System.out.print("Position: ");

		String position = input.next().toLowerCase();

		switch (position) {
		case "m":
			rate = 500;
			validInput = true;
			System.out.println("Rate: " + rate);
			break;
		case "s":
			rate = 400;
			validInput = true;
			System.out.println("Rate: " + rate);
			break;
		case "e":
			rate = 300;
			validInput = true;
			System.out.println("Rate: " + rate);
			break;
		default:
			System.out.println("Not a valid position.");
		}

		if (validInput) {
			// Declare and initialize variables within the statement scope
			int numberOfDaysWorked = 0;
			int gross = 0;
			int bonus = 0;
			int tax = 0;
			int taxRate = 0;
			int SSS = 0;
			int medicare = 100;

			System.out.print("Number of days worked: ");
			numberOfDaysWorked = input.nextInt();

			if (numberOfDaysWorked >= 0) {
				gross = numberOfDaysWorked * rate;

				System.out.println("Gross: " + gross);
				
				
				if (gross >= 7000) bonus = 1000;
				else if (gross >= 4000 && gross < 7000) bonus = 750;
				else if (gross >= 3000 && gross < 4000) bonus = 500;
				else bonus = 0;

				System.out.println("\n Bonus: " + bonus);
				System.out.println("Deductions: ");
				
				// Decide which tax rate to use based on gross
				if (gross >= 7000) taxRate = 15;
				else if (gross >= 5000 && gross < 7000) taxRate = 10;
				else taxRate = 5;
				
				// Compute for tax
				tax = gross * taxRate / 100;
				
				System.out.println("\t Tax: " + tax);
				
				// Compute for SSS
				SSS = gross * 10 / 100;
				
				int deduction = SSS + medicare + tax;
				System.out.println("\t SSS: " + SSS);
				System.out.println("\t Medicare: " + medicare);
				System.out.println("Total Deduction: " + deduction);
				
				int netIncome = gross + bonus - deduction;
				System.out.println("\nNet income: " + ((gross + bonus) - deduction));
			}
			// If number of days is negative
			else {
				System.out.println("Invalid number of days.");	
				System.out.println("Try again.");
			}
		}
		// If position is invalid
		else System.out.println("Try again.");
	}
}
