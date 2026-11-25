package group3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Array {
	// Shared bank name used as the title for JOptionPane screens.
	// The static ArrayList stores every account while the program is running.
	// Column order: account number, name, balance, PIN, status, account type.
	public static final String BANK_NAME = "Ainsworth Trust & Savings";
	
	public static ArrayList<String[]> accounts;

	// Initializes sample customer and administrator records on program startup.
	public static void initializeAccounts() {
		accounts = new ArrayList<String[]>();
		accounts.add(new String[] { "0123-4567-8901", "Roel Richard", "5000.00", "1111", "Active", "Customer" });
		accounts.add(new String[] { "2345-6789-0123", "Dorie Marie", "0.00", "2222", "Blocked", "Customer" });
		accounts.add(new String[] { "3456-7890-1234", "Railee Darrel", "10000.00", "3333", "Active", "Customer" });
		accounts.add(new String[] { "4567-8901-2345", "Railynne Dessirei", "2500.00", "4444", "Active", "Customer" });
		accounts.add(new String[] { "5678-9012-3456", "Raine Dessirei", "10000.00", "5555", "Active", "Customer" });
		accounts.add(new String[] { "0000-0000-0000", "System Administrator", "0.00", "0000", "Active", "Admin" });
	}
	
	// Displays all account records for database/testing purposes.
	public static void verifyAccounts() {
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

		JOptionPane.showMessageDialog(null, accountsDisplay.toString(),
				BANK_NAME + " - Database Check", JOptionPane.INFORMATION_MESSAGE);
	}
}