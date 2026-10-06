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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AlexSolution_BR {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		// Declare and initialize variables within the method scope
		int rate = 0;
		boolean isInputValid = false;

		// Using if and switch
		System.out.print("Name: ");
		String name = input.readLine();

		System.out.println("Enter m for Manager,\n"
				+          "      s for Supervisor,\n"
				+ "      e for Employee");
		System.out.print("Position: ");

		String position = input.readLine().toLowerCase().trim();
		String wordPosition = "";

		switch (position) {
		case "m":
			rate = 500;
			isInputValid = true;
			wordPosition = "Manager";
			System.out.println("Rate: " + rate);
			break;
		case "s":
			rate = 400;
			isInputValid = true;
			wordPosition = "Supervisor";
			System.out.println("Rate: " + rate);
			break;
		case "e":
			rate = 300;
			isInputValid = true;
			wordPosition = "Employee";
			System.out.println("Rate: " + rate);
			break;
		default:
			System.out.println("Not a valid position.");
		}

		if (isInputValid) {
			// Declare and initialize variables within the if statement scope
			isInputValid = false;
			String numberOfDaysWorkedStr = "";
			int numberOfDaysWorkedInt = 0;
			int gross = 0;
			int bonus = 0;
			int tax = 0;
			int taxRate = 0;
			int sss = 0;
			int medicare = 100;
			int netIncome = 0;

			System.out.print("Number of days worked: ");

			numberOfDaysWorkedStr = input.readLine();
			numberOfDaysWorkedStr = numberOfDaysWorkedStr.trim();
			if (numberOfDaysWorkedStr.matches("\\d+")) {
				isInputValid = true;
				numberOfDaysWorkedInt = Integer.parseInt(numberOfDaysWorkedStr);
			}
			if (isInputValid) {
				gross = numberOfDaysWorkedInt * rate;

				System.out.println("Gross: P" + gross);

				// Decide which bonus to use based on gross
				if (gross >= 8000) bonus = 1000;
				else if (gross >= 5000) bonus = 750;
				else if (gross >= 3000) bonus = 500;
				else bonus = 0;

				System.out.println("\nBonus: P" + bonus);
				System.out.println("Deductions: P");

				// Decide which tax rate to use based on gross
				if (gross >= 7000) taxRate = 15;
				else if (gross >= 4000) taxRate = 10;
				else if (gross >= 2000) taxRate = 5;
				else taxRate = 0;

				// Compute for tax
				tax = gross * taxRate / 100;

				System.out.println("\tTax: P" + tax);

				// Compute for SSS 
				sss = gross * 10 / 100;
				int deduction = sss + medicare + tax;
				
				System.out.println("\tSSS: P" + sss);
				System.out.println("\tMedicare: P" + medicare);
				System.out.println("Total Deduction: P" + deduction);

				// Compute for Net Income
				netIncome = gross + bonus - deduction;
				System.out.println("\nNet income: P" + netIncome);
			}	
		}
		if (!isInputValid)
			System.out.println("Invalid input. Please try again.");
	}
}
