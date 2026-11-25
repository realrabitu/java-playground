package group3;

import javax.swing.JOptionPane;

public class Admin6 {

    public static void transferFund() {
        String source = JOptionPane.showInputDialog(null,
                "Enter Source Account Number:",
                Array.BANK_NAME, JOptionPane.QUESTION_MESSAGE);
        if (source == null) return;

        String destination = JOptionPane.showInputDialog(null,
                "Enter Destination Account Number:",
                Array.BANK_NAME, JOptionPane.QUESTION_MESSAGE);
        if (destination == null) return;

        if (!DashFormatter.isValidAccountNumber(source)
                || !DashFormatter.isValidAccountNumber(destination)) {
            JOptionPane.showMessageDialog(null,
                    "Account number must contain exactly 12 digits.",
                    Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
            return;
        }

        int s = findAccount(DashFormatter.format(source.trim()));
        int d = findAccount(DashFormatter.format(destination.trim()));

        if (s == -1 || d == -1 || s == d) {
            JOptionPane.showMessageDialog(null,
                    "Invalid account number!",
                    Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Array.accounts.get(s)[5].equalsIgnoreCase("Admin")
                || Array.accounts.get(d)[5].equalsIgnoreCase("Admin")) {
            JOptionPane.showMessageDialog(null,
                    "The administrator account cannot send or receive funds.",
                    Array.BANK_NAME, JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (Array.accounts.get(s)[4].equalsIgnoreCase("Blocked")
                || Array.accounts.get(d)[4].equalsIgnoreCase("Blocked")) {
            JOptionPane.showMessageDialog(null,
                    "Blocked accounts cannot send or receive funds.",
                    Array.BANK_NAME, JOptionPane.WARNING_MESSAGE);
            return;
        }

        String input = JOptionPane.showInputDialog(null,
                "Enter Transfer Amount:",
                Array.BANK_NAME, JOptionPane.QUESTION_MESSAGE);
        if (input == null) return;

        double amount;
        double sourceBalance = getBalance(s);
        
        try {
            amount = Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Invalid amount!",
                    Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Reject malformed special values before changing account balances.
        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            JOptionPane.showMessageDialog(null,
                    "Invalid amount. Please enter a valid number.",
                    Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (amount <= 0 || amount > sourceBalance) {
            JOptionPane.showMessageDialog(null,
                    "Invalid amount or insufficient balance!",
                    Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (amount < 100 || amount > 50000) {
            int choice = JOptionPane.showConfirmDialog(null,
                    "Amount is outside normal transfer limits.\nBypass limits?",
                    "Admin Authorization",
                    JOptionPane.YES_NO_OPTION);
            if (choice != JOptionPane.YES_OPTION) return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
                "Source: " + source.trim()
                        + "\nDestination: " + destination.trim()
                        + "\nAmount: PHP " + String.format("%,.2f", amount)
                        + "\n\nConfirm Transfer?",
                "Transfer Fund",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            setBalance(s, sourceBalance - amount);
            setBalance(d, getBalance(d) + amount);

            JOptionPane.showMessageDialog(null,
                    "Transfer Successful!\n"
                            + "Transferred Amount: PHP " + String.format("%,.2f", amount)
                            + "\nRemaining Balance: PHP " + String.format("%,.2f", getBalance(s)),
                    Array.BANK_NAME, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    static int findAccount(String accountNumber) {
        for (int i = 0; i < Array.accounts.size(); i++) {
            if (Array.accounts.get(i)[0].equals(accountNumber)) {
                return i;
            }
        }
        return -1;
    }

    static double getBalance(int index) {
        return Double.parseDouble(Array.accounts.get(index)[2]);
    }

    static void setBalance(int index, double newBalance) {
        Array.accounts.get(index)[2] = String.format("%.2f", newBalance);
    }

    public static void main(String[] args) {
        Array.initializeAccounts();
        transferFund();
    }
}