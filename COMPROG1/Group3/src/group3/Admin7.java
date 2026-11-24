package group3;

import javax.swing.JOptionPane;

public class Admin7 {
	static final String HEAD = Array.BANK_NAME + "\n\n";

	static void setStatus() {
		int i = askAccount("ACTIVATE/BLOCK ACCOUNT\n\nEnter account #:\n(Cancel or X to Exit)");
		if (i == -1)
			return;

		String c = ask("Account Name: " + Array.accounts.get(i)[1]
				+ "\nCurrent status: " + Array.accounts.get(i)[4]
				+ "\n\nEnter A to Activate or B to Block:");
		if (c == null)
			return;

		if (c.equalsIgnoreCase("A")) {
			Array.accounts.get(i)[4] = "Active";
			show("Account activated.");
		} else if (c.equalsIgnoreCase("B")) {
			Array.accounts.get(i)[4] = "Blocked";
			show("Account blocked.");
		} else {
			show("Invalid choice. No changes made.");
		}
	}

	static String ask(String msg) {
		String s = JOptionPane.showInputDialog(null, HEAD + msg,
				Array.BANK_NAME, JOptionPane.QUESTION_MESSAGE);
		return s == null ? null : s.trim();
	}

	static void show(String msg) {
		JOptionPane.showMessageDialog(null, HEAD + msg,
				Array.BANK_NAME, JOptionPane.INFORMATION_MESSAGE);
	}

	static int findAccount(String num) {
		for (int i = 0; i < Array.accounts.size(); i++) {
			if (Array.accounts.get(i)[0].equals(num))
				return i;
		}
		return -1;
	}

	static int askAccount(String msg) {
		while (true) {
			String num = ask(msg);
			if (num == null || num.equalsIgnoreCase("X"))
				return -1;

			int idx = findAccount(num);
			if (idx != -1)
				return idx;

			show("Account number does not exist. Try again.");
		}
	}

	public static void main(String[] args) {
		Array.initializeAccounts();
		setStatus();
	}
}