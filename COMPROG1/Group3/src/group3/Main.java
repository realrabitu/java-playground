package group3;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		// Load initial in-memory account data before any login/transaction flow.
		Array.initializeAccounts();
		
		boolean running = true;
		// Main application loop: show menu, process login, then route by account type.
		while (running) {
			char choice = MainMenu.mainMenu(); // Output #1 (Main Menu)

			if (choice == 'Q') { // User exits from the first menu
				JOptionPane.showMessageDialog(null,
						"Thank you for using Ainsworth Banking Corporation!",
						Array.BANK_NAME, JOptionPane.INFORMATION_MESSAGE);
				running = false;
			} else { // User starts transaction flow and proceeds to login
				int index = Login.login(); // Output #2 (Login window)

				if (index == -1) {
					// Cancel/login-back action: return to start of while loop
				} else if (index == -2) {
					// Too many wrong PIN attempts (captured-card scenario).
					JOptionPane.showMessageDialog(null,
							"CAPTURED CARD.... PLEASE CALL 143-44",
							Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
				} else if (index == -3) {
					// Account status is already blocked before entering transactions.
					JOptionPane.showMessageDialog(null,
							"Account is blocked.",
							Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
				} else if (Array.accounts.get(index)[5].equals("Admin")) {
					AdminInterface.adminMenu(); // Output #5
				} else {
					TypeOfTransaction.customerMenu(index); // Output #3
				}
			}
		}
	}
}