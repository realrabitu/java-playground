package group3;
import javax.swing.JOptionPane;

public class DashFormatter {

    public static String format(String input) {
        String digits = input.replaceAll("\\D", "");
        StringBuilder sb = new StringBuilder();

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