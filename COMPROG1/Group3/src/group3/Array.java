package group3;

import javax.swing.JOptionPane;

public class ArrayDeclaration {
	// Default Bank name na lalabas sa lahat ng JOptionpane
	// comment: subject to change based sa final deliberation w/ the group. 
	public static final String BANK_NAME = "Ainsworth Trust & Savings";
	/**
	 * Nag a-act as DataBase natin.. at naka declare siya sa labas ng methods for
	 * easy access at matawag
	 */
	// comment: declaration of empty accounts array
	public static String[][] accounts;

	// Dito mo in-initialize o nilagyan ng laman yung accounts array
	
	// comment: is this necessary? why should we do this instead of predefining the accounts?
	public static void initializeAccounts() {
		// May sample data narin siya nakalagay bow haha
		// Added narin dito ung ADMIN ACCOUNT
		
		// comment: 2D array including all account information. i learned this is a better approach than
		// using multiple arrays to hold information. Good!
		accounts = new String[][] { { "10001", "Ezekiel Pagco", "5000.00", "1617", "Active", "Customer" },
				{ "10002", "Xandler Yaries Zafe", "25000.00", "6969", "Active", "Customer" },
				{ "10003", "Shaun Yuri Baruela", "500.00", "2008", "Blocked", "Customer" },
				{ "99999", "System Administrator", "0.00", "0000", "Active", "Admin" } };
	}

	// For test and display ng array gamit ung required na JOption format
	
	// comment: i'm guessing this is to verify the program for debugging and testing.
	// is this necessary for the final output?
	public static void verifyAccounts() {
		// comment: be sure to be able to explain the usage of stringbuilder here and the methods
		StringBuilder accountList = new StringBuilder("System Database Initialization:\n\n");

		for (String[] acc : accounts) {
			accountList.append("Account #: ").append(acc[0]).append("\n").append("Name: ").append(acc[1]).append("\n")
					.append("Balance: ₱").append(acc[2]).append("\n").append("PIN: ").append(acc[3]).append("\n")
					.append("Status: ").append(acc[4]).append("\n").append("---------------------------\n");
		}
		// Dito nakalagay ung Bank Name variable na mag ppop-up
		JOptionPane.showMessageDialog(null, accountList.toString(), BANK_NAME + " - Database Check",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		initializeAccounts();
		verifyAccounts();
	}
}
