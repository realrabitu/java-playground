package group3;
import javax.swing.JOptionPane;
public class TypeOfTransaction {
	// Route a logged-in customer to the selected transaction screen.
	public static void customerMenu(int idx) {
		while (true) {
			String t = JOptionPane.showInputDialog(null,
					Array.BANK_NAME + "\nSELECT TYPE OF TRANSACTION\n" + "B -> Balance Inquiry\n" + "W -> Withdrawal\n"
							+ "D -> Deposit\n" + "T -> Transfer Fund\n" + "C -> Cancel\n\n"
							+ "Enter Transaction Type: ",
					Array.BANK_NAME, JOptionPane.QUESTION_MESSAGE);
			if (t == null || t.equalsIgnoreCase("C")) {
				return;
			}
			t = t.trim();
			if (t.equalsIgnoreCase("B")) {
			    BalanceInquiry.showBalance(idx);
			} else if (t.equalsIgnoreCase("W")) {
			    Withdrawal.withdraw(idx);
			} else if (t.equalsIgnoreCase("D")) {
			    Deposit.deposit(idx);
			} else if (t.equalsIgnoreCase("T")) {
			    TransferFund.transferFund(idx);
			}
		}
	}
}