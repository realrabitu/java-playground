package group3;

import javax.swing.JOptionPane;

public class Login {
	public static void main(String[] args) {
		ArrayDeclaration.initializeAccounts();
		boolean hasExited = false;
		do {
			int index = login();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "User cancelled or exited.",
						"RGBC - Richard Gwapo Banking Corporation", JOptionPane.INFORMATION_MESSAGE);
				hasExited = true;
			} else if (index == -2) {
				JOptionPane.showMessageDialog(null, "Authentication failed.\nTry again.",
						"RGBC - Richard Gwapo Banking Corporation", JOptionPane.ERROR_MESSAGE);
			} else if (index == -3) {
				JOptionPane.showMessageDialog(null, "Account is blocked.", "RGBC - Richard Gwapo Banking Corporation",
						JOptionPane.ERROR_MESSAGE);
			} else if (ArrayDeclaration.accounts[index][5].equals("Admin")) {
				AdminInterface.adminMenu();
				
			} else {
				JOptionPane.showMessageDialog(null, "Welcome, " + ArrayDeclaration.accounts[index][1] + "!",
						"RGBC - Richard Gwapo Banking Corporation", JOptionPane.PLAIN_MESSAGE);
			}
		} while (!hasExited);
	}

	// Asks for the account number and PIN, then checks them.
	// Returns the account's index in the array,
	//-1 if user cancelled
	//-2 if authentication failed 
	//-3 if account is blocked
	public static int login() {
		String title = "RGBC - Richard Gwapo Banking Corporation";
		// 1. Input dialogs

		// ADD ACCOUNT NUMBER CHECK HERE:
		int accountIndex = -1;
		do {
			String accNo = JOptionPane.showInputDialog(null, "LOGIN\nEnter your account number:", title,
					JOptionPane.PLAIN_MESSAGE);
			if (accNo == null)
				return -1;
			accNo = accNo.trim();
			for (int i = 0; i < ArrayDeclaration.accounts.length; i++) {

				if (accNo.equals(ArrayDeclaration.accounts[i][0])) {
					accountIndex = i;
					break;
				}
			}
			if (accountIndex == -1) {
				JOptionPane.showMessageDialog(null, "Account number not found.\nTry again.", title,
						JOptionPane.WARNING_MESSAGE);
			}
		} while (accountIndex == -1);

		if (ArrayDeclaration.accounts[accountIndex][4].equals("Blocked"))
			return -3;
		if (ArrayDeclaration.accounts[accountIndex][5].equals("Admin")) {
			int attempts = 3;
			do {
				String pin = JOptionPane.showInputDialog(null, "LOGIN\nEnter your pin number:", title,
						JOptionPane.PLAIN_MESSAGE);
				if (pin == null)
					return -1;
				if (pin.trim().equals(ArrayDeclaration.accounts[accountIndex][3]))
					return accountIndex;
				else {
					attempts--;
					JOptionPane.showMessageDialog(null,
							"Invalid PIN. Try again.\n" + "You have " + attempts + " attempts remaining.", title,
							JOptionPane.WARNING_MESSAGE);
				}

			} while (attempts > 0);
		} else {
			int attempts = 3;
			do {
				String pin = JOptionPane.showInputDialog(null, "LOGIN\nEnter your pin number:", title,
						JOptionPane.PLAIN_MESSAGE);
				if (pin == null)
					return -1;
				if (pin.trim().equals(ArrayDeclaration.accounts[accountIndex][3]))
					return accountIndex;
				else {
					attempts--;
					JOptionPane.showMessageDialog(null,
							"Invalid PIN. Try again.\n" + "You have " + attempts + " attempts remaining.", title,
							JOptionPane.WARNING_MESSAGE);
				}
				if (attempts == 0) {
					ArrayDeclaration.accounts[accountIndex][4] = "Blocked";
					JOptionPane.showMessageDialog(null,
							"You have exceeded the maximum number of attempts.\n"
									+ "Your account has been blocked for logging in.\n"
									+ "Contact bank administrator for more details.",
							title, JOptionPane.WARNING_MESSAGE);

				}
			} while (attempts > 0);
		}
		return -2;
	}
}
