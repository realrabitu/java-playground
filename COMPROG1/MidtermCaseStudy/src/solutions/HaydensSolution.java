package solutions;

import javax.swing.*;

public class HaydensSolution {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		
		String name = jop.showInputDialog(null, "Please enter your name:", "NAME OF EMPLOYEE", JOptionPane.PLAIN_MESSAGE);
		
		if (name == null) {
			return; // Exit program gracefully if canceled
		}
		
		String position = jop.showInputDialog(null,
				"-----------------Please enter your position-----------------" 
				+ "\n\n  <m> Manager  " + " <s>  Supervisor  " + " <e>  Employee  \n\n", 
				"TYPE YOUR POSTION", JOptionPane.PLAIN_MESSAGE);
		
		if (position == null) {
			return; // Exit program gracefully if canceled
		}
		
		String stringnod = jop.showInputDialog(null,"Please enter how many days you've worked:","DAYS WORKED INPUT", JOptionPane.PLAIN_MESSAGE);
		
		if (stringnod == null) {
			return; // Exit program gracefully if canceled
		}
		
		int nod;
		
		try {
			nod = Integer.parseInt(stringnod.trim());
			// Ensure the user doesn't enter negative days
			if (nod < 0) {
				JOptionPane.showMessageDialog(null, "Days worked cannot be negative.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (NumberFormatException e) {
			// Triggered if the input contains letters, symbols, or is blank ("")
			JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid whole number for days worked.", "Error", JOptionPane.ERROR_MESSAGE);
			return; // Stop execution
		}
		
		double rpd;
		double gross;
		double bonus; 
		double sss;
		double tax;
		int medicare = 100;
		double totalDeduction;
		double netIncome;
		
		
		
		if (position.equalsIgnoreCase("m")) {
			rpd = 500;
		}
		else if (position.equalsIgnoreCase("s")) {
			rpd = 400;
		}
		else if (position.equalsIgnoreCase("e")) {
			rpd = 300;
		}
		else {
			jop.showMessageDialog(null, "Inputted invalid position please try again: m (Manager), s (Supervisor) , e (Employee)");
			return;
		}
		
		
		gross = rpd * nod;
		
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
		
		sss = gross * .1;
		
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
		
		totalDeduction = sss + tax + medicare;
		netIncome = gross + bonus - totalDeduction;
				
		
		jop.showMessageDialog(null, 
		"======================================" 
		+ "\n--------------------Member Information--------------------" 
	    + "\n======================================" 
		+ "\nName: " + name 
		+ "\nPosition: " + position 
		+ "\nRate: " + rpd 
		+ "\nNo. of days worked: " + nod 
		+ "\nGross: " + gross 
		+ "\n======================================" 
		+ "\nBonus: "  +  bonus 
		+ "\n------------------------- Deductions: -------------------------" 
		+ "\nTax: " + tax 
		+ "\nSSS: " + sss 
		+  "\nMedicare: " + medicare 
		+ "\nTotal Deduction: " + totalDeduction 
		+ "\n======================================" 
		+  "\n\nNet Income: " + netIncome, 
		null, JOptionPane.PLAIN_MESSAGE);
		
			
		
		
	}
}
