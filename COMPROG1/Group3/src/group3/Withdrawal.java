package group3;

import javax.swing.JOptionPane;

public class Withdrawal {
	public static void withdraw(int idx) {
		while (true) {
			String input = JOptionPane.showInputDialog(null,
					"WITHDRAWAL\nEnter amount to be withdrawn\nPress X to Exit",
					Array.BANK_NAME, JOptionPane.PLAIN_MESSAGE);
			if (input == null || input.trim().equalsIgnoreCase("X")) {
				return;
			}
			try {
				double amount = Double.parseDouble(input.trim());
				String[] account = Array.accounts.get(idx);
				double balance = Double.parseDouble(account[2]);
				if (amount < 100 || amount % 100 != 0) {
					JOptionPane.showMessageDialog(null,
							"Invalid amount! Must be at least P100 and in P100 denominations.",
							Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
				} else if (amount > balance) {
					JOptionPane.showMessageDialog(null, "Insufficient balance.",
							Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
				} else {
					double newBalance = balance - amount;
					account[2] = String.format("%.2f", newBalance);
					JOptionPane.showMessageDialog(null,
							"WITHDRAWAL SUCCESSFUL\nWithdrawn Amount: P"
									+ String.format("%.2f", amount) + "\nNew Balance: P"
									+ String.format("%.2f", newBalance),
							Array.BANK_NAME, JOptionPane.INFORMATION_MESSAGE);
					return;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid input! Enter a number.",
						Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}