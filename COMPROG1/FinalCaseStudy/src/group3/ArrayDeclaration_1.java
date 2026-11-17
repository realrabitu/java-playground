package group3;
import javax.swing.JOptionPane;

public class ArrayDeclaration_1 {
	// Default Bank name na lalabas sa lahat ng JOptionpane
	public static final String BANK_NAME = "Ainsworth Trust & Savings";
	/** Nag a-act as DataBase natin.. at naka declare siya sa labas ng methods
	for easy access at matawag*/
	public static String[][] accounts;

	//Dito mo in-initialize o nilagyan ng laman yung accounts array
	public static void initializeAccounts() {
	    // May sample data narin siya nakalagay bow haha
	    // Added narin dito ung ADMIN ACCOUNT
	    accounts = new String[][] {
	        {"10001", "Ezekiel Pagco", "5000.00", "1617", "Active"},
	        {"10002", "Xandler Yaries Zafe", "25000.00", "6969", "Active"},
	        {"10003", "Shaun Yuri Baruela", "500.00", "2008", "Blocked"},
	        {"99999", "System Administrator", "0.00", "0000", "Admin"}
	    };
	}
	// For test and display ng array gamit ung required na JOption format
	   public static void verifyAccounts() {
	       StringBuilder accountList = new StringBuilder("System Database Initialization:\n\n");
	      
	       for (String[] acc : accounts) {
	           accountList.append("Account #: ").append(acc[0]).append("\n")
	                      .append("Name: ").append(acc[1]).append("\n")
	                      .append("Balance: ₱").append(acc[2]).append("\n")
	                      .append("PIN: ").append(acc[3]).append("\n")
	                      .append("Status: ").append(acc[4]).append("\n")
	                      .append("---------------------------\n");
	       }
	       // Dito nakalagay ung Bank Name variable na mag ppop-up
	       JOptionPane.showMessageDialog(
	           null,
	           accountList.toString(),
	           BANK_NAME + " - Database Check",
	           JOptionPane.INFORMATION_MESSAGE
	       );
	   }
	   void main() {
		   initializeAccounts();
		   verifyAccounts();
	   }
}


    
