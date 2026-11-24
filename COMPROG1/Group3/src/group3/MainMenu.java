package group3;

import javax.swing.JOptionPane;

public class MainMenu {
	// OUTPUT #1: MAIN MENU
	public static char mainMenu() {
		// Options array for the buttons
		String[] options = { "S - Start Transaction", "Q - Quit" };

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

		if (choice == 0) {
			return 'S';
		} else {
			return 'Q';
		}
	}
}