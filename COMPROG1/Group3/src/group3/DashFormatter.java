package group3;
import javax.swing.JOptionPane;

public class DashFormatter {

    // Convert an account number to groups of four digits separated by dashes.
    public static String format(String input) {
        // Remove all non-digit characters from the input
        String digits = input.replaceAll("\\D", "");
        StringBuilder sb = new StringBuilder();

        // Iterate over the digits and add a dash after every four digits
        for (int i = 0; i < digits.length(); i++) {
            if (i > 0 && i % 4 == 0) {
                sb.append('-');
            }
            sb.append(digits.charAt(i));
        }
        return sb.toString();
    }

    /*public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Enter number:");

        if (input == null) {
            return; // user pressed Cancel or closed the dialog
        }

        String result = format(input);
        JOptionPane.showMessageDialog(null, "Formatted: " + result);
    }*/
}