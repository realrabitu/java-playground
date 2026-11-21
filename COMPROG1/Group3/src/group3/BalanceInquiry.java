package group3;
import javax.swing.JOptionPane;
public class BalanceInquiry {
   public static void showBalance(int idx) {
       String x;
       do {
           x = JOptionPane.showInputDialog(null,
                   "BALANCE INQUIRY\n"
                           + "Account #: " + Array.accounts[idx][0] + "\n"
                           + "Account Name: " + Array.accounts[idx][1] + "\n"
                           + "Balance: " + String.format("%.2f", Double.parseDouble(Array.accounts[idx][2])) + "\n\n"
                           + "Press X to Exit",
                   Array.BANK_NAME, JOptionPane.PLAIN_MESSAGE);
       } while (x != null && !x.trim().equalsIgnoreCase("X"));
   }
}

/*package group3;

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
	   


}*/
