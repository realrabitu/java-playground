package group3;

import javax.swing.JOptionPane;

// Output #4-T : Transfer Fund (Suganob and Veluz)
public class TransferFund {
    // Hanapin ang account gamit ang account number. Return -1 kung wala.
    static int findAccount(String accNum) {
        String formatted = DashFormatter.format(accNum);
        for (int i = 0; i < Array.accounts.size(); i++) {
            if (Array.accounts.get(i)[0].equals(formatted)) {
                return i;
            }
        }
        return -1;
    }

    // Kunin ang balance bilang number
    static double getBalance(int i) {
        return Double.parseDouble(Array.accounts.get(i)[2]);
    }

    // I-update ang balance
    static void setBalance(int i, double newBalance) {
        Array.accounts.get(i)[2] = String.format("%.2f", newBalance);
    }

    // Output #4-T: Transfer Fund
    // sender = index ng naka-login na account
    // Kapag nag-type ng X o Cancel, babalik sa Output #3
    static void transferFund(int sender) {

        if (Array.accounts.get(sender)[5].equalsIgnoreCase("Admin")) {
            JOptionPane.showMessageDialog(null,
                    "The administrator account cannot send funds.",
                    Array.BANK_NAME,
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 1. Hingin ang recipient account number
        int recipient;
        while (true) {
            String accNum = JOptionPane.showInputDialog(null,
                    "Enter recipient Account Number (X to go back):",
                    Array.BANK_NAME, JOptionPane.QUESTION_MESSAGE);

            // X o Cancel = balik sa Output #3
            if (accNum == null || accNum.equalsIgnoreCase("X")) {
                return;
            }

            if (!DashFormatter.isValidAccountNumber(accNum)) {
                JOptionPane.showMessageDialog(null,
                        "Account number must contain exactly 12 digits.",
                        Array.BANK_NAME,
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }

            recipient = findAccount(accNum.trim());

            if (recipient == -1) {
                JOptionPane.showMessageDialog(null, 
                		"Account does not exist.", 
                		Array.BANK_NAME, 
                		JOptionPane.ERROR_MESSAGE);
            } else if (recipient == sender) {
                JOptionPane.showMessageDialog(null, 
                		"You can't transfer to your own account.", 
                		Array.BANK_NAME, 
                		JOptionPane.ERROR_MESSAGE);
            } else if (Array.accounts.get(recipient)[5].equalsIgnoreCase("Admin")) {
                JOptionPane.showMessageDialog(null,
                        "The administrator account cannot receive funds.",
                        Array.BANK_NAME,
                        JOptionPane.WARNING_MESSAGE);
            } else if (Array.accounts.get(recipient)[4].equalsIgnoreCase("Blocked")) {
                JOptionPane.showMessageDialog(null,
                        "This account is blocked and cannot receive funds.",
                        Array.BANK_NAME,
                        JOptionPane.WARNING_MESSAGE);
            } else {
                break; // valid na
            }
        }

        // 2. Hingin ang amount
        while (true) {
            String input = JOptionPane.showInputDialog(null,
                    "Enter amount to transfer (min P1,000)\n"
                    + "Fee: P25 per P1,000\n"
                    + "(X to go back):",
                    Array.BANK_NAME, 
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null || input.equalsIgnoreCase("X")) {
                return;
            }

            // Check kung number ba talaga
            double amount;
            try {
                amount = Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                		"Numbers only, please.", 
                		Array.BANK_NAME, 
                		JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Reject malformed special numeric values such as NaN and Infinity.
            if (Double.isNaN(amount) || Double.isInfinite(amount)) {
                JOptionPane.showMessageDialog(null,
                        "Invalid amount. Please enter a valid number.",
                        Array.BANK_NAME,
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Minimum P1,000
            if (amount < 1000) {
                JOptionPane.showMessageDialog(null, 
                		"Minimum transfer is P1,000.", 
                		Array.BANK_NAME, 
                		JOptionPane.WARNING_MESSAGE);
                continue;
            }

            // Fee: P25 bawat P1,000 (hal. P3,000 = P75)
            double fee = (int) (amount / 1000) * 25;
            double total = amount + fee;

            // Check kung sapat ang balance (amount + fee)
            if (total > getBalance(sender)) {
                JOptionPane.showMessageDialog(null,
                        "Insufficient balance.\nTotal needed: P" + String.format("%,.2f", total)
                        + "\nYour balance: P" + String.format("%,.2f", getBalance(sender)),
                        Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // 3. I-update ang balance ng DALAWA
            setBalance(sender, getBalance(sender) - total);       // sender: bawas amount + fee
            setBalance(recipient, getBalance(recipient) + amount); // recipient: amount lang

            JOptionPane.showMessageDialog(null,
                    "Transfer successful!\nSent to: " + Array.accounts.get(recipient)[1]
                    + "\nAmount: P" + String.format("%,.2f", amount)
                    + "\nFee: P" + String.format("%,.2f", fee)
                    + "\nNew balance: P" + String.format("%,.2f", getBalance(sender)),
                    Array.BANK_NAME, 
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    // Pang-test lang. Burahin pag i-merge na.
    /*public static void main(String[] args) {
        Array.initializeAccounts();
    	transferFund(0); // naka-login bilang 1001
    }*/
}