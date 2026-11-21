package group3;
import javax.swing.JOptionPane;

public class AdminInterface {
	public static void main(String[] args) {
		adminMenu();
	}
	public static void adminMenu() {
        boolean running = true;
        // comment: explain the usage for while loop 
        while (running) {
        	// pre-formatted string
            String menu = "RGBC\n"
                    + "Richard Gwapo Banking Corporation\n\n"
                    + "What would you like to do?\n"
                    + "( 1 ) - View Customer Information\n"
                    + "( 2 ) - Search Customer\n"
                    + "( 3 ) - Add New Customer\n"
                    + "( 4 ) - Edit Customer Information\n"
                    + "( 5 ) - Change Customer Pin Number\n"
                    + "( 6 ) - Transfer Fund\n"
                    + "( 7 ) - Activate/Block Account\n"
                    + "( X ) - Exit\n\n"
                    + "Enter your choice:";
            String choice = JOptionPane.showInputDialog(null, 
            		menu,											   // message
                    Array.BANK_NAME + " | Administrator", // title
                    JOptionPane.PLAIN_MESSAGE);
            // Cancel button or closing the window is treated as X
            if (choice == null) {
                running = false;
                continue;
            }
            choice = choice.trim().toUpperCase();
            switch (choice) {
                case "1":
                    //viewCustomerInformation();
                    break;
                case "2":
                    //searchCustomer();
                    break;
                case "3":
                    //addNewCustomer();
                    break;
                case "4":
                    //editCustomerInformation();
                    break;
                case "5":
                   // changeCustomerPin();
                    break;
                case "6":
                    //adminTransferFund();
                    break;
                case "7":
                    //activateBlockAccount();
                    break;
                case "X":
                    running = false; // back to Output #1 (main menu)
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid choice. Please enter 1-7 or X.",
                            Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
            }
        }
    }
	
	
}
