package group3;

import javax.swing.JOptionPane;

public class BalanceInquiry {
	public static void showBalance(int idx) {
		String[] account = Array.accounts.get(idx);
		String inputPrompt;
		do {
			inputPrompt = JOptionPane.showInputDialog(null,
					"BALANCE INQUIRY\n"
							+ "Account #: " + account[0] + "\n"
							+ "Account Name: " + account[1] + "\n"
							+ "Balance: " + String.format("%.2f", Double.parseDouble(account[2])) + "\n\n"
							+ "Press X to Exit",
					Array.BANK_NAME, JOptionPane.PLAIN_MESSAGE);
		} while (inputPrompt != null && !inputPrompt.trim().equalsIgnoreCase("X"));
	}
}