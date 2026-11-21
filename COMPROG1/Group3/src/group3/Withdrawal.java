package group3;

import javax.swing.JOptionPane;

public class Withdrawal {
	private static final String HEADER = "";

	public static void main(String[] args) {
		withdraw(1);

	}
	// OUTPUT #4-W: WITHDRAWAL (MERIBALLES)
	public static void withdraw(int idx) {
	    while (true) {
	        String in = JOptionPane.showInputDialog(
	            null,
	            HEADER + "WITHDRAWAL\nEnter amount to be withdrawn\nPress X to Exit",
	            Array.BANK_NAME,
	            JOptionPane.PLAIN_MESSAGE
	        );

	        if (in == null || in.trim().equalsIgnoreCase("X")) return;

	        try {
	            double amt = Double.parseDouble(in.trim());
	            double bal = Double.parseDouble(Array.accounts[idx][2]);

	            if (amt < 100 || amt % 100 != 0) {
	                JOptionPane.showMessageDialog(
	                    null,
	                    HEADER + "Invalid amount! Must be at least P100 and in P100 denominations.",
	                    Array.BANK_NAME,
	                    JOptionPane.ERROR_MESSAGE
	                );
	            } else if (amt > bal) {
	                JOptionPane.showMessageDialog(
	                    null,
	                    HEADER + "Insufficient balance.",
	                    Array.BANK_NAME,
	                    JOptionPane.ERROR_MESSAGE
	                );
	            } else {
	                double newBal = bal - amt;
	                Array.accounts[idx][2] = String.format("%.2f", newBal);

	                JOptionPane.showMessageDialog(
	                    null,
	                    HEADER + "WITHDRAWAL SUCCESSFUL\n"
	                           + "Withdrawn Amount: P" + String.format("%.2f", amt) + "\n"
	                           + "New Balance: P" + String.format("%.2f", newBal),
	                    Array.BANK_NAME,
	                    JOptionPane.INFORMATION_MESSAGE
	                );

	                return;
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(
	                null,
	                HEADER + "Invalid input! Enter a number.",
	                Array.BANK_NAME,
	                JOptionPane.ERROR_MESSAGE
	            );
	        }
	    }
	}



}
