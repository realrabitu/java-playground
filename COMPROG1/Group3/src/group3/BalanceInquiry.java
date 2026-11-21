package group3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BalanceInquiry {

	public static void main(String[] args) {
		
	}
	public static double getBalance(
			ArrayList<Double> balance, 
			int idx) {
		 return balance.get(idx);
		 if (t.equals("B")) {
			    String x;
			    do {
			        x = JOptionPane.showInputDialog(null,
			                "" + "BALANCE INQUIRY\n"
			                        + "Account #: " + accNo.get(idx) + "\n"
			                        + "Account Name: " + accName.get(idx) + "\n"
			                        + "Balance: " + String.format("%.2f", getBalance(balance, idx)) + "\n\n"
			                        + "Press X to Exit",
			                title, JOptionPane.PLAIN_MESSAGE);
			    } while (x != null && !x.trim().equalsIgnoreCase("X"));
			// <<< LANDICHO PART END

		
	}
	   


}
