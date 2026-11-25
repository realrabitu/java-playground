package group3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Array {
	// Default Bank name na lalabas sa lahat ng JOptionpane
	// comment: subject to change based sa final deliberation w/ the group. 
	public static final String BANK_NAME = "Ainsworth Trust & Savings";
	
	public static ArrayList<String[]> accounts;
	// Dito mo in-initialize o nilagyan ng laman yung accounts array
	public static void initializeAccounts() {
		// May sample data narin siya nakalagay bow haha
		// Added narin dito ung ADMIN ACCOUNT
		/*accounts = new String[][] { { "10001", "Ezekiel Pagco", "5000.00", "1617", "Active", "Customer" },
				{ "10002", "Xandler Yaries Zafe", "25000.00", "6969", "Active", "Customer" },
				{ "10003", "Shaun Yuri Baruela", "500.00", "2008", "Blocked", "Customer" },
				{ "99999", "System Administrator", "0.00", "0000", "Active", "Admin" } };*/
		// Account column order: number, name, balance, PIN, status, type
		accounts = new ArrayList<String[]>();
		accounts.add(new String[] { "0123-4567-8901", "Roel Richard", "5000.00", "1111", "Active", "Customer" });
		accounts.add(new String[] { "2345-6789-0123", "Dorie Marie", "0.00", "2222", "Blocked", "Customer" });
		accounts.add(new String[] { "3456-7890-1234", "Railee Darrel", "10000.00", "3333", "Active", "Customer" });
		accounts.add(new String[] { "4567-8901-2345", "Railynne Dessirei", "2500.00", "4444", "Active", "Customer" });
		accounts.add(new String[] { "5678-9012-3456", "Raine Dessirei", "10000.00", "5555", "Active", "Customer" });
		accounts.add(new String[] { "0000-0000-0000", "System Administrator", "0.00", "0000", "Active", "Admin" });
	}
	
	// For test and display ng array gamit ung required na JOption format
	public static void verifyAccounts() {
		// comment: be sure to be able to explain the usage of stringbuilder here and the methods
		StringBuilder accountsDisplay = new StringBuilder("System Database Initialization:\n\n");

		for (String[] account : accounts) {
			accountsDisplay.append("Account #: ").append(account[0]).append("\n")
					.append("Name: ").append(account[1]).append("\n")
					.append("Balance: ₱").append(account[2]).append("\n")
					.append("PIN: ").append(account[3]).append("\n")
					.append("Status: ").append(account[4]).append("\n")
					.append("Account Type: ").append(account[5]).append("\n")
					.append("---------------------------\n");
		}

		// Dito nakalagay ung Bank Name variable na mag ppop-up
		JOptionPane.showMessageDialog(null, accountsDisplay.toString(),
				BANK_NAME + " - Database Check", JOptionPane.INFORMATION_MESSAGE);
	}

}