package group3;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Array.initializeAccounts();          // load the account table once

        boolean running = true;
        while (running) {
            char choice = MainMenu.mainMenu();            // Output #1

            if (choice == 'Q') {
                JOptionPane.showMessageDialog(null,
                        "Thank you for using RGBC Banking Corporation!",
                        "RGBC", JOptionPane.INFORMATION_MESSAGE);
                running = false;
            } else {
                int idx = Login.login();                  // Output #2

                if (idx == -1) {
                    // user cancelled -> back to Output #1
                } else if (idx == -2) {
                    JOptionPane.showMessageDialog(null,
                            "CAPTURED CARD.... PLEASE CALL 143-44",
                            "RGBC", JOptionPane.ERROR_MESSAGE);
                } else if (idx == -3) {
                    JOptionPane.showMessageDialog(null,
                            "Account is blocked.",
                            "RGBC", JOptionPane.ERROR_MESSAGE);
                } else if (Array.accounts[idx][5].equals("Admin")) {
                    AdminInterface.adminMenu();           // Output #5
                } else {
                    TypeOfTransaction.customerMenu(idx);  // Output #3
                }
            }
        }
    }
}

