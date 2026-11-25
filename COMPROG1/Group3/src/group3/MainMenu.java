package group3;

import javax.swing.JOptionPane;

public class MainMenu {
	// Output #1: Show the first screen and return the user's action.
	public static char mainMenu() {
		// Button labels mapped to the return values below.
		String[] options = { "Start Transaction", "Quit" };

		// HTML is used here to keep title/subtitle formatting readable in JOptionPane.
		String message = "<html><center>" + "<h1>Ainsworth</h1>" + "<b>Ainsworth Trust & Savings</b>" + "<hr>"
				+ "<br><h3>MAIN MENU</h3>" + "Welcome to Ainsworth Banking System!<br><br>"
				+ "Please select your desired option:" + "</center></html>";

		int choice = JOptionPane.showOptionDialog(null,
				message,
				Array.BANK_NAME,
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null,
				options,
				options[0]);

		// Index 0 means Start; any other result (Quit button or dialog close) exits.
		if (choice == 0) {
			return 'S';
		} else {
			return 'Q';
		}
	}
}