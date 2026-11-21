package group3;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;


public class Deposit {


    static final String BANK_CODE    = "RGBC";
    static final String BANK_NAME    = "Richard Gwapo Banking Corporation";
    static final String WINDOW_TITLE = BANK_CODE + " - " + BANK_NAME;


    static String header(String screenName) {
        return BANK_CODE + "\n" + BANK_NAME + "\n\n" + screenName + "\n\n";
    }

    static void showError(String screenName, String message) {
        JOptionPane.showMessageDialog(null, header(screenName) + message,
                WINDOW_TITLE, JOptionPane.ERROR_MESSAGE);
    }


    static String money(double amount) {
        return String.format(Locale.US, "%.2f", amount);
    }


    static final double MIN_DEPOSIT = 100.00;  


    static void deposit(int accIndex) {
        while (true) {
            String input = askDepositAmount();

            if (input == null) {                 
                return;
            }
            input = input.trim();

            if (input.equalsIgnoreCase("X")) {   
                return;
            }

            String error = validateDepositAmount(input);

            if (error != null) {
                showError("DEPOSIT", error);      
            } else {
                updateBalance(accIndex, Double.parseDouble(input));
                balanceInquiry(accIndex);         
                return;                          
            }
        }
    }

    
    static String askDepositAmount() {
        return JOptionPane.showInputDialog(null,
                header("DEPOSIT")
                + "Enter amount to be deposited\n"
                + "Press X to Exit",
                WINDOW_TITLE, JOptionPane.PLAIN_MESSAGE);
    }

   
    static String validateDepositAmount(String input) {


        if (input.isEmpty()) {
            return "Please enter the amount to be deposited.";
        }

        if (!input.matches("[+-]?(\\d+\\.?\\d*|\\.\\d+)")) {
            return "Invalid amount. Please enter numbers only\n"
                 + "(no letters, commas, or symbols).";
        }

        double amount = Double.parseDouble(input);  


        if (Double.isInfinite(amount)) {
            return "Invalid amount. That number is too large.";
        }
        if (amount < 0) {
            return "Invalid amount. Negative amounts are not allowed.";
        }
        int dot = input.indexOf('.');
        if (dot != -1 && input.length() - dot - 1 > 2) {
            return "Invalid amount. Please use at most 2 decimal places\n"
                 + "(example: 3275.99).";
        }
        if (amount < MIN_DEPOSIT) {
            return "Invalid amount. The minimum deposit is P" + money(MIN_DEPOSIT) + ".";
        }

        return null;   // valid
    }


    static void updateBalance(int accIndex, double amount) {
        double newBalance = balances.get(accIndex) + amount;               // <-- read balance
        balances.set(accIndex, Math.rint(newBalance * 100.0) / 100.0);     // <-- save balance
    }


    static ArrayList<String> accNumbers = new ArrayList<>();
    static ArrayList<String> accNames   = new ArrayList<>();
    static ArrayList<Double> balances   = new ArrayList<>();
    static ArrayList<String> pins       = new ArrayList<>();
    static ArrayList<String> statuses   = new ArrayList<>();

    static void loadAccounts() {
        addAccount("0123-4567-8901", "Roel Richard",      5000.00, "1111", "Active");
        addAccount("2345-6789-0123", "Dorie Marie",          0.00, "2222", "Blocked");
        addAccount("3456-7890-1234", "Railee Darrel",    10000.00, "3333", "Active");
        addAccount("4567-8901-2345", "Railynne Dessirei", 2500.00, "4444", "Active");
        addAccount("5678-9012-3456", "Raine Dessirei",   10000.00, "5555", "Active");
    }

    static void addAccount(String number, String name, double balance, String pin, String status) {
        accNumbers.add(number);
        accNames.add(name);
        balances.add(balance);
        pins.add(pin);
        statuses.add(status);
    }

    static void balanceInquiry(int accIndex) {
        String input;
        do {
            input = JOptionPane.showInputDialog(null,
                    header("BALANCE INQUIRY")
                    + "Account #: " + accNumbers.get(accIndex) + "\n"
                    + "Account Name: " + accNames.get(accIndex) + "\n"
                    + "Balance: " + money(balances.get(accIndex)) + "\n\n"
                    + "Press X to Exit",
                    WINDOW_TITLE, JOptionPane.PLAIN_MESSAGE);
        } while (input != null && !input.trim().equalsIgnoreCase("X"));
    }

    
    public static void main(String[] args) {
        loadAccounts();
        int loggedIn = 0;   

        while (true) {
            String choice = JOptionPane.showInputDialog(null,
                    header("SELECT TYPE OF TRANSACTION")
                    + "B -> Balance Inquiry\n"
                    + "W -> Withdrawal\n"
                    + "D -> Deposit\n"
                    + "T -> Transfer Fund\n"
                    + "C -> Cancel\n\n"
                    + "Enter transaction type:",
                    WINDOW_TITLE, JOptionPane.PLAIN_MESSAGE);

            if (choice == null || choice.trim().equalsIgnoreCase("C")) {
                break;
            } else if (choice.trim().equalsIgnoreCase("D")) {
                deposit(loggedIn);
            } else if (choice.trim().equalsIgnoreCase("B")) {
                balanceInquiry(loggedIn);
            } else {
                showError("SELECT TYPE OF TRANSACTION",
                        "Only B (Balance Inquiry) and D (Deposit)\nwork in this test file.");
            }
        }
    }
}
