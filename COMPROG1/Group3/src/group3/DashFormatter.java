package group3;

public class DashFormatter {

    // Convert exactly 12 account digits into groups of four separated by dashes.
    public static String format(String input) {
        if (input == null) {
            return "";
        }

        // Formatting is safe only after validation, but this method also removes
        // ordinary dashes so undashed input can match stored account numbers.
        String digits = input.replaceAll("[\\-\\s]", "");
        if (!digits.matches("\\d{12}")) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            if (i > 0 && i % 4 == 0) {
                sb.append('-');
            }
            sb.append(digits.charAt(i));
        }
        return sb.toString();
    }

    // Valid input contains only digits/dashes and exactly 12 digits.
    public static boolean isValidAccountNumber(String input) {
        if (input == null) {
            return false;
        }
        String trimmed = input.trim();
        if (!trimmed.matches("[0-9-]+")) {
            return false;
        }
        String digits = trimmed.replace("-", "");
        return digits.matches("\\d{12}");
    }
}