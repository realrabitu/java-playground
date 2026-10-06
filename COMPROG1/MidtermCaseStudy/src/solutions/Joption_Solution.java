package solutions;

import javax.swing.*;

public class Joption_Solution {

	public static void main(String[] args) {	
		
		// ---------------------------------------------------
		String name = JOptionPane.showInputDialog(null, "Please enter your name:", "NAME OF EMPLOYEE", JOptionPane.PLAIN_MESSAGE);
		
		// Ensures that before it continues the input is valid (It isn't exited by clicking X/cancel or isn't empty)
		if (name == null) return; // exits program if canceled
	
		if (name.trim().isEmpty()) { // Name sure that there is a name inside of the input box if not then goodbye
			JOptionPane.showMessageDialog(null, "Please enter a name.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//---------------------------------------------------
		
		// ------------ Code that include position -------------
		String position = JOptionPane.showInputDialog(null,
				"-----------------Please enter your position-----------------" 
				+ "\n\n  <m> Manager  " + " <s>  Supervisor  " + " <e>  Employee  \n\n", 
				"TYPE YOUR POSITION", JOptionPane.PLAIN_MESSAGE);
		
		// checks if it is exited
		if (position == null) return; 

		// --- if-else structure to assign rate per day value based on position ---
		double rpd;
		
		if (position.trim().equalsIgnoreCase("m") || position.trim().equalsIgnoreCase("Manager")) {
			rpd = 500.0;	
		}
		else if (position.trim().equalsIgnoreCase("s") || position.trim().equalsIgnoreCase("Supervisor")) {
			rpd = 400.0;
		}
		else if (position.trim().equalsIgnoreCase("e") || position.trim().equalsIgnoreCase("Employee")) {
			rpd = 300.0;
		}
		else {
			JOptionPane.showMessageDialog(null, "Inputted invalid position please try again: m (Manager), s (Supervisor) , e (Employee)", "Invalid Input.", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// --------------------------------------------------- 
		
		// ---------------------- Number of days -----------------------------
		String stringnod = JOptionPane.showInputDialog(null,"Please enter how many days you've worked:","DAYS WORKED INPUT", JOptionPane.PLAIN_MESSAGE);
		
		// checks if exited 
		if (stringnod == null) return; 
	
		int nod;
		
		// -- Uses try and catch to check if they tried to input anything other than a number for number of days worked --
		try {
			nod = Integer.parseInt(stringnod.trim());
			// -- Ensure the user doesn't enter negative days --
			if (nod < 0) {
				JOptionPane.showMessageDialog(null, "Days worked cannot be negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} 
		catch (NumberFormatException e) {
			// Triggered if the input contains letters, symbols, or is blank ("")
			JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid whole number for days worked.", "Error", JOptionPane.ERROR_MESSAGE);
			return; // Stop execution
		}
		// ---------------------------------------------------
		
		
		// -- Assigns gross and sss to its formula and the if-else structure to assign the value of bonus according to gross --
		double gross = rpd * nod;
		double sss = gross * .1; 
		double medicare = 100; // Stated to have a set value of 100
		
		double bonus;
		
		if (gross >= 8000) {
			bonus = 1000;
		}
		else if (gross >= 5000) {
			bonus = 750;
		}
		else if (gross >= 3000) {
			bonus = 500;
		}
		else {
			bonus = 0;
		}	
		// ---------------------------------------------------
		
		// --  if-else structure for assigning tax to its value according to gross --
		double tax;
		
		if (gross >= 7000) {
			tax = gross * .15;
		}
		else if (gross >= 4000) {
			tax = gross * .10;
		}
		else if (gross >= 2000 ) {
			tax = gross * .05;
		}
		else {
			tax = 0;
		}
		// --------------------------------------------------- 
		
		
		// ---- Both totalDeduction and netIncome assigned to its values
		double totalDeduction = sss + tax + medicare;
		double netIncome = gross + bonus - totalDeduction;
		// ---------------------------------------------------
		
		
		// -- Final output using jop message dialog --
		JOptionPane.showMessageDialog(null,
                " ================================\n"
                + "             ##EMPLOYEE PAYSLIP##      \n"
                + " ================================\n"
                + " ______EMPLOYEE INFORMATION______\n"
                + " ----------------------------------------------------------\n"
                + "   NAME                             : " + name.trim().toUpperCase()
                + "\n   POSITION                      : " + position.trim().toUpperCase()
                + "\n   DAYS WORKED            : " + nod
                + "\n   RATE PER DAY             : ₱" + rpd
                + "\n ----------------------------------------------------------\n"
                + "  GROSS INCOME            : ₱" + gross
                + "\n  BONUS                            : ₱" + bonus
                + "\n ================================\n"
                + " ____________DEDUCTIONS____________\n"
                + " ----------------------------------------------------------\n"
                + "   SSS                                  : ₱" + sss
                + "\n   MEDICARE                      : ₱" + medicare
                + "\n   TAX                                  : ₱" + tax
                + "\n ----------------------------------------------------------\n"
                + "  TOTAL DEDUCTIONS    : ₱" + totalDeduction
                + "\n ================================\n"
                + "  NET INCOME                   : ₱" + netIncome
                + "\n ================================\n",
                "EMPLOYEE PAYSLIP",                       
                JOptionPane.PLAIN_MESSAGE 
        );
		
		//---------------------------------------------------
		
		
	}
}
