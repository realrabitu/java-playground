package group3;

import javax.swing.JOptionPane;

public class TypeOfTransaction {

	public static void main(String[] args) {
		customerMenu(1);

	}

	public static void customerMenu(int idx) {
		 
		while (true) {
			
			String t = JOptionPane.showInputDialog(null,
					Array.BANK_NAME + "SELECT TYPE OF TRANSACTION\n" + "B -> Balance Inquiry\n" + "W -> Withdrawal\n"
							+ "D -> Deposit\n" + "T -> Transfer Fund\n" + "C -> Cancel\n\n"
							+ "Enter Transaction Type: ",
					"RGBC", JOptionPane.QUESTION_MESSAGE);
			if (t == null || t.equalsIgnoreCase("C")) {
				return;
			}

			t.trim();

			if (t.equalsIgnoreCase("B")) {
				// balanceInquiry(idx); 
			} else if (t.equalsIgnoreCase("W")) {
				// withdraw(idx);
			} else if (t.equalsIgnoreCase("D")) {
				// deposit(idx);
			} else if (t.equalsIgnoreCase("T")) {
				// transferScreen(idx);
			} else {
				// comment: what is HEAD?
				//JOptionPane.showMessageDialog(null, HEAD + "Invalid transaction type.", "RGBC",
						//JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
