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
import javax.swing.JOptionPane;

public class AlexSolution_JOP {
	public static void main(String[] args) {
		// I am using the JOptionPane class directly instead of instantiating a JOptionPane object
		// to avoid the squiggly lines about static access
		// Although it would stil work fine if:
		// JOptionPane input = new JOptionPane();

		// Declare and initialize variables within the method scope
		int rate = 0;
		boolean isInputValid = false;
		boolean isCanceled = false;

		// Using if only
		String name = JOptionPane.showInputDialog(null, "Name", "Input Details",
				JOptionPane.QUESTION_MESSAGE);
		if (name == null) isCanceled = true;

		// showInputDialog() parameters:
		// showInputDialog(null, message, title, messageType)
		if (!isCanceled) {
			String position = JOptionPane.showInputDialog(null, "Enter Position: \n"
					+ "m for Manager\n s for Supervisor\n e for Employee",
					"Input Details", 
					JOptionPane.QUESTION_MESSAGE);
			String wordPosition = "";

			// Did the user cancel?
			if (position == null) isCanceled = true;

			if (!isCanceled) { 
				if (position.trim().equalsIgnoreCase("m")) {
					rate = 500;
					isInputValid = true;
					wordPosition = "Manager";
				}
				else if (position.trim().equalsIgnoreCase("s")) {
					rate = 400;
					isInputValid = true;
					wordPosition = "Supervisor";
				}
				else if (position.trim().equalsIgnoreCase("e")) {
					rate = 300;
					isInputValid = true;
					wordPosition = "Employee";
				}

				if (isInputValid) {
					// Declare and initialize variables within the if statement scope
					isInputValid = false;
					String numberOfDaysWorkedInput = "";
					int numberOfDaysWorked = 0;
					int gross = 0;
					int bonus = 0;
					int tax = 0;
					int taxRate = 0;
					int SSS = 0;
					int medicare = 100;

					numberOfDaysWorkedInput = JOptionPane.showInputDialog("Number of days worked");

					// Did the user cancel?
					if (numberOfDaysWorkedInput == null) isCanceled = true;
					else {
						numberOfDaysWorkedInput = numberOfDaysWorkedInput.trim();
						isInputValid = numberOfDaysWorkedInput.matches("\\d+");
					}

					if (isInputValid) { 
						numberOfDaysWorked = Integer.parseInt(numberOfDaysWorkedInput);

						gross = numberOfDaysWorked * rate;

						// Decide which bonus to use based on gross
						if (gross >= 8000) bonus = 1000;
						else if (gross >= 5000) bonus = 750;
						else if (gross >= 3000) bonus = 500;
						else bonus = 0;

						// Decide which tax rate to use based on gross
						if (gross >= 7000) taxRate = 15;
						else if (gross >= 4000) taxRate = 10;
						else if (gross >= 2000) taxRate = 5;
						else taxRate = 0;

						// Compute for tax
						tax = gross * taxRate / 100;
						// Compute for SSS
						SSS = gross * 10 / 100;

						int deduction = SSS + medicare + tax;
						int netIncome = gross + bonus - deduction;
						JOptionPane.showMessageDialog(null,
								"Name: " + name +
								"\nPosition: " + wordPosition +
								"\nRate: P" + rate + " per day" +
								"\nNo. of days worked: " + numberOfDaysWorked + " days" + 
								"\nGross: P" + gross +
								"\n\nBonus: P" + bonus +
								"\nDeductions: " +
								"\n      Tax : P" + tax + 
								"\n      SSS: P" + SSS + 
								"\n      Medicare: P" + medicare +
								"\nTotal Deduction: P" + deduction +
								"\n\nNet Income: P" + netIncome);
					}
				}
			}
		}		
		// If the user cancels on any part of the program
		if (isCanceled) {
			// showMessageDialog parameters: parentComponent, message, title, messageType
			JOptionPane.showMessageDialog(null, "User canceled.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		// If the user input is invalid on any part of the program
		else if (!isInputValid)
			JOptionPane.showMessageDialog(null, "Invalid input.\nPlease try again.", "Error",
					JOptionPane.ERROR_MESSAGE);
	} // Main method brace
} // Class brace
