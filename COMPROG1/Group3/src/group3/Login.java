package group3;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Login {
	// Authenticates an account and returns: account index, -1 cancel, -2 attempts exceeded, or -3 blocked.
	public static int login() {
		String title = Array.BANK_NAME;
		int accountIndex = -1;

		// Repeat account lookup until a matching account is entered or login is cancelled.
		do {
			String accNo = JOptionPane.showInputDialog(null, "LOGIN\nEnter your account number:", title,
					JOptionPane.PLAIN_MESSAGE);
			if (accNo == null)
				return -1;

			// Format input consistently before comparing it with stored account numbers.
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
		// Blocked accounts cannot proceed to PIN entry or transactions.
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

				// Three failed customer attempts block the account and end login.
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

	// Displays a masked PIN field instead of a plain text input dialog.
	private static String askForHiddenPin(String title) {
		JLabel label = new JLabel("Enter your 4-digit PIN:");
		JPasswordField pinField = new JPasswordField(4);
		pinField.setToolTipText("Enter your 4-digit PIN");

		JPanel panel = new JPanel(new BorderLayout(5, 5));
		panel.add(label, BorderLayout.NORTH);
		panel.add(pinField, BorderLayout.CENTER);

		int result = JOptionPane.showConfirmDialog(null, panel,
				title + " - Login", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result != JOptionPane.OK_OPTION)
			return null;

		return new String(pinField.getPassword()).trim();
	}
}