package group3;

import javax.swing.JOptionPane;

public class Admin1_2 {
	static void viewAllCustomers() {
		String list = "";
		for (int i = 0; i < Array.accounts.size(); i++) {
			String[] account = Array.accounts.get(i);
			if (account[5].equalsIgnoreCase("Admin")) {
	            continue;
	        }
			list += "Account No.: " + account[0] + "\n"
					+ "Name: " + account[1] + "\n"
					+ "Balance: P" + account[2] + "\n"
					+ "PIN: " + account[3] + "\n"	
					+ "Status: " + account[4] + "\n"
					+ "Account Type: " + account[5] + "\n\n";
			
		}
		JOptionPane.showMessageDialog(null, list, Array.BANK_NAME + " - All Customers",
				JOptionPane.INFORMATION_MESSAGE);
	}

	// Option 2: Hanapin ang customer gamit ang account number O pangalan
	// Kapag nag-type ng X o Cancel, babalik sa admin menu
	static void searchCustomer() {
		while (true) {
			String key = JOptionPane.showInputDialog(null,
					"Enter Account Number or Name (X to go back):",
					Array.BANK_NAME, JOptionPane.QUESTION_MESSAGE);
			// X o Cancel = balik sa admin menu
			if (key == null || key.equalsIgnoreCase("X")) {
				return;
			}
			key = key.trim().toLowerCase();
			String result = "";
			// Hanapin sa lahat ng accounts (kahit part lang ng pangalan okay na)
			for (int i = 0; i < Array.accounts.size(); i++) {
				String[] account = Array.accounts.get(i);
				boolean sameNumber = account[0].toLowerCase().equals(key);
				boolean sameName = account[1].toLowerCase().contains(key);
				if (!key.isEmpty() && (sameNumber || sameName)) {
					result += "Account No.: " + account[0] + "\n"
							+ "Name: " + account[1] + "\n"
							+ "Balance: P" + account[2] + "\n"
							+ "PIN: " + account[3] + "\n"
							+ "Status: " + account[4] + "\n"
							+ "Account Type: " + account[5] + "\n\n";
				}
			}
			if (result.equals("")) {
				JOptionPane.showMessageDialog(null, "No customer found.", Array.BANK_NAME,
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, result, Array.BANK_NAME + " - Search Result",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		}
	}

	// Pang-test lang. Burahin pag i-merge na.
	public static void main(String[] args) {
		Array.initializeAccounts();
		String[] buttons = { "1 - View All", "2 - Search", "X - Exit" };
		while (true) {
			int choice = JOptionPane.showOptionDialog(null, "Admin test menu", Array.BANK_NAME,
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);
			if (choice == 0) {
				viewAllCustomers();
			} else if (choice == 1) {
				searchCustomer();
			} else {
				break;
			}
		}
	}
}