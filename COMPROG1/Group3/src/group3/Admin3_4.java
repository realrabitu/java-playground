package group3;

import javax.swing.JOptionPane;

public class Admin3_4 {

	static int findAccount(String accNo) {
		for (int i = 0; i < Array.accounts.size(); i++) {
			if (Array.accounts.get(i)[0].equals(accNo)) {
				return i;
			}
		}
		return -1;
	}

	// Option 3: Magdagdag ng bagong customer
	static void addNewCustomer() {
		String accNo = JOptionPane.showInputDialog(null,
				"Enter new Account Number (X to go back):",
				Array.BANK_NAME + " - Add New Customer", JOptionPane.QUESTION_MESSAGE);
		if (accNo == null || accNo.equalsIgnoreCase("X")) {
			return;
		}

		accNo = accNo.trim();
		if (accNo.isEmpty() || !accNo.matches("[0-9-]+")) {
			JOptionPane.showMessageDialog(null, "Account number must contain numbers and dashes only.",
					Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
			return;
		}

		accNo = DashFormatter.format(accNo);

		if (findAccount(accNo) != -1) {
			JOptionPane.showMessageDialog(null, "Account number already exists.",
					Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
			return;
		}

		String name = JOptionPane.showInputDialog(null,
				"Enter Account Name (X to go back):",
				Array.BANK_NAME + " - Add New Customer", JOptionPane.QUESTION_MESSAGE);
		if (name == null || name.equalsIgnoreCase("X")) {
			return;
		}
		name = name.trim();
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Name cannot be empty.",
					Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
			return;
		}

		String pin = JOptionPane.showInputDialog(null,
				"Enter 4-digit PIN (X to go back):",
				Array.BANK_NAME + " - Add New Customer", JOptionPane.QUESTION_MESSAGE);
		if (pin == null || pin.equalsIgnoreCase("X")) {
			return;
		}
		pin = pin.trim();
		if (!pin.matches("\\d{4}")) {
			JOptionPane.showMessageDialog(null, "PIN must contain exactly 4 digits.",
					Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
			return;
		}

		Array.accounts.add(new String[] { accNo, name, "0.00", pin, "Active", "Customer" });
		JOptionPane.showMessageDialog(null, "Account added successfully.",
				Array.BANK_NAME, JOptionPane.INFORMATION_MESSAGE);
	}

	// Option 4: I-edit ang impormasyon ng customer
	static void editCustomer() {
		String accNo = JOptionPane.showInputDialog(null,
				"Enter Account Number to edit (X to go back):",
				Array.BANK_NAME + " - Edit Customer", JOptionPane.QUESTION_MESSAGE);
		if (accNo == null || accNo.equalsIgnoreCase("X")) {
			return;
		}

		accNo = accNo.trim();
		if (accNo.isEmpty() || !accNo.matches("[0-9-]+")) {
			JOptionPane.showMessageDialog(null, "Account number must contain numbers and dashes only.",
					Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
			return;
		}

		accNo = DashFormatter.format(accNo);
		int index = findAccount(accNo);
		if (index == -1) {
			JOptionPane.showMessageDialog(null, "Account number not found.",
					Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
			return;
		}

		String[] account = Array.accounts.get(index);
		String newName = JOptionPane.showInputDialog(null,
				"Account No: " + accNo + "\n"
						+ "Current Name: " + account[1] + "\n\n"
						+ "Enter new Account Name (X to go back):",
				Array.BANK_NAME + " - Edit Customer", JOptionPane.QUESTION_MESSAGE);
		if (newName == null || newName.equalsIgnoreCase("X")) {
			return;
		}

		newName = newName.trim();
		if (newName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Name cannot be empty.",
					Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
			return;
		}

		account[1] = newName;
		JOptionPane.showMessageDialog(null, "Account name updated successfully!",
				Array.BANK_NAME, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		Array.initializeAccounts();
		addNewCustomer();
	}
}