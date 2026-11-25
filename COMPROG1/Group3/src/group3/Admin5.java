package group3;

import javax.swing.JOptionPane;

public class Admin5 {
    static void changeCustomerPin() {

        // Keep asking until a valid customer account is found or the admin exits.
        int index = -1;
        while (index == -1) {
            String accNum = JOptionPane.showInputDialog(null,
                    "Enter customer Account Number (X to go back):",
                    Array.BANK_NAME + " - Change PIN", JOptionPane.QUESTION_MESSAGE);

            if (accNum == null || accNum.equalsIgnoreCase("X")) {
                return;
            }

            // Validate account number format (exactly 12 digits).
            if (!DashFormatter.isValidAccountNumber(accNum)) {
                JOptionPane.showMessageDialog(null,
                        "Account number must contain exactly 12 digits.",
                        Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Normalize input (with/without dashes) so lookup matches stored format.
            index = findCustomerAccount(DashFormatter.format(accNum.trim()));

            if (index == -1) {
                JOptionPane.showMessageDialog(null,
                        "Customer account does not exist.",
                        Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
            }
        }

        // Enforce exactly 4 numeric digits before saving the new PIN.
        while (true) {
            String newPin = JOptionPane.showInputDialog(null,
                    "Customer: " + Array.accounts.get(index)[1]
                            + "\nEnter new 4-digit PIN (X to go back):",
                    Array.BANK_NAME + " - Change PIN", JOptionPane.QUESTION_MESSAGE);

            if (newPin == null || newPin.equalsIgnoreCase("X")) {
                return;
            }

            newPin = newPin.trim();
            if (!newPin.matches("\\d{4}")) {
                JOptionPane.showMessageDialog(null,
                        "PIN must be exactly 4 digits.",
                        Array.BANK_NAME, JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // PIN is stored at column index 3 in the account record.
            Array.accounts.get(index)[3] = newPin;

            JOptionPane.showMessageDialog(null,
                    "PIN changed successfully for " + Array.accounts.get(index)[1] + ".",
                    Array.BANK_NAME, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    static int findCustomerAccount(String accNum) {
        for (int i = 0; i < Array.accounts.size(); i++) {
            String[] account = Array.accounts.get(i);
            // Only customer accounts are eligible for this admin action.
            if (account[0].equals(accNum) && account[5].equalsIgnoreCase("Customer")) {
                return i;
            }
        }
        return -1;
    }
}