package group3;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login {
	public static int login() {
		String title = Array.BANK_NAME;
		int accountIndex = -1;

		do {
			String accNo = JOptionPane.showInputDialog(null, "LOGIN\nEnter your account number:", title,
					JOptionPane.PLAIN_MESSAGE);
			if (accNo == null)
				return -1;

			accNo = DashFormatter.format(accNo.trim());
			for (int i = 0; i < Array.accounts.size(); i++) {
				if (accNo.equals(Array.accounts.get(i)[0])) {
					accountIndex = i;
					break;
				}
			}
			if (accountIndex == -1) {
				JOptionPane.showMessageDialog(null, "Account number not found.\nTry again.", title,
						JOptionPane.WARNING_MESSAGE);
			}
		} while (accountIndex == -1);

		String[] account = Array.accounts.get(accountIndex);
		if (account[4].equals("Blocked"))
			return -3;

		if (account[5].equals("Admin") || account[5].equals("Customer")) {
			int attempts = 3;
			do {
				String pin = askForHiddenPin(title);
				if (pin == null)
					return -1;
				if (pin.equals(account[3]))
					return accountIndex;

				attempts--;
				JOptionPane.showMessageDialog(null,
						"Invalid PIN. Try again.\n" + "You have " + attempts + " attempts remaining.", title,
						JOptionPane.WARNING_MESSAGE);

				if (attempts == 0 && account[5].equals("Customer")) {
					account[4] = "Blocked";
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

	private static String askForHiddenPin(String title) {
		JPasswordField pinField = new JPasswordField();
		int result = JOptionPane.showConfirmDialog(null, pinField,
				title + "\nEnter your PIN:", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result != JOptionPane.OK_OPTION)
			return null;

		return new String(pinField.getPassword()).trim();
	}
}