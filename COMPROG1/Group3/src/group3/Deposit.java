package group3;

import javax.swing.JOptionPane;

public class Deposit {
	// Minimum amount accepted for one deposit transaction.
	static final double MIN_DEPOSIT = 100.00;

	// Ask repeatedly until the user cancels or enters a valid deposit amount.
	static void deposit(int accIndex) {
		while (true) {
			String input = JOptionPane.showInputDialog(null,
					"Ainsworth\n" + Array.BANK_NAME + "\n\nDEPOSIT\n\n"
							+ "Enter amount to be deposited\nPress X to Exit",
					Array.BANK_NAME, JOptionPane.PLAIN_MESSAGE);

			// Cancel or X exits the deposit process.
			if (input == null || input.trim().equalsIgnoreCase("X")) {
				return;
			}

			// Check the amount before using it in a balance calculation.
			String error = validateDepositAmount(input.trim());
			if (error != null) {
				JOptionPane.showMessageDialog(null, error,
						Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
				continue;
			}

			// Valid input is converted once and added to the selected account.
			updateBalance(accIndex, Double.parseDouble(input.trim()));
			BalanceInquiry.showBalance(accIndex);
			return;
		}
	}

	// Return an error message for invalid input, or null when the amount is valid.
	static String validateDepositAmount(String input) {
		if (input.isEmpty()) {
			return "Please enter the amount to be deposited.";
		}
		// Accept only optional signs and decimal-number text; letters and commas are rejected.
		if (!input.matches("[+-]?([\\d]+\\.?\\d*|\\.\\d+)")) {
			return "Invalid amount. Please enter numbers only\n(no letters, commas, or symbols).";
		}

		double amount = Double.parseDouble(input);
		// Reject special numeric values that could corrupt the stored balance.
		if (Double.isNaN(amount) || Double.isInfinite(amount)) {
			return "Invalid amount. That number is too large or invalid.";
		}
		if (amount < 0) {
			return "Invalid amount. Negative amounts are not allowed.";
		}

		// Count characters after the decimal point to enforce peso-and-centavo precision.
		int dot = input.indexOf('.');
		if (dot != -1 && input.length() - dot - 1 > 2) {
			return "Invalid amount. Please use at most 2 decimal places\n(example: 3275.99).";
		}
		if (amount < MIN_DEPOSIT) {
			return "Invalid amount. The minimum deposit is P" + String.format("%.2f", MIN_DEPOSIT) + ".";
		}
		return null;
	}

	// Add the validated amount to the stored balance and format it with 2 decimals.
	static void updateBalance(int accIndex, double amount) {
		String[] account = Array.accounts.get(accIndex);
		double newBalance = Double.parseDouble(account[2]) + amount;
		account[2] = String.format("%.2f", newBalance);
	}
}