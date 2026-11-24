package group3;

import javax.swing.JOptionPane;

public class Deposit {
	static final String BANK_CODE = "Ainsworth";
	static final String BANK_NAME = "Ainsworth Trust & Savings";
	static final String WINDOW_TITLE = BANK_NAME;
	static final double MIN_DEPOSIT = 100.00;

	static String header(String screenName) {
		return BANK_CODE + "\n" + BANK_NAME + "\n\n" + screenName + "\n\n";
	}

	static void showError(String screenName, String message) {
		JOptionPane.showMessageDialog(null, header(screenName) + message,
				WINDOW_TITLE, JOptionPane.ERROR_MESSAGE);
	}

	static String money(double amount) {
		return String.format("%.2f", amount);
	}

	static void deposit(int accIndex) {
		while (true) {
			String input = JOptionPane.showInputDialog(null,
					header("DEPOSIT") + "Enter amount to be deposited\nPress X to Exit",
					WINDOW_TITLE, JOptionPane.PLAIN_MESSAGE);
			if (input == null || input.trim().equalsIgnoreCase("X")) {
				return;
			}
			input = input.trim();
			String error = validateDepositAmount(input);
			if (error != null) {
				showError("DEPOSIT", error);
			} else {
				updateBalance(accIndex, Double.parseDouble(input));
				BalanceInquiry.showBalance(accIndex);
				return;
			}
		}
	}

	static String validateDepositAmount(String input) {
		if (input.isEmpty()) {
			return "Please enter the amount to be deposited.";
		}
		if (!input.matches("[+-]?([\\d]+\\.?\\d*|\\.\\d+)")) {
			return "Invalid amount. Please enter numbers only\n(no letters, commas, or symbols).";
		}
		double amount = Double.parseDouble(input);
		if (Double.isInfinite(amount)) {
			return "Invalid amount. That number is too large.";
		}
		if (amount < 0) {
			return "Invalid amount. Negative amounts are not allowed.";
		}
		int dot = input.indexOf('.');
		if (dot != -1 && input.length() - dot - 1 > 2) {
			return "Invalid amount. Please use at most 2 decimal places\n(example: 3275.99).";
		}
		if (amount < MIN_DEPOSIT) {
			return "Invalid amount. The minimum deposit is P" + money(MIN_DEPOSIT) + ".";
		}
		return null;
	}

	static void updateBalance(int accIndex, double amount) {
		String[] account = Array.accounts.get(accIndex);
		double newBalance = Double.parseDouble(account[2]) + amount;
		newBalance = Math.rint(newBalance * 100.0) / 100.0;
		account[2] = String.format("%.2f", newBalance);
	}
}