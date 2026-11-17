package group3;

import javax.swing.JOptionPane;

public class MainMenu {
	// OUTPUT #1: MAIN MENU
	public static char mainMenu() {
		// Options array for the buttons
		String[] options = { "S - Start Transaction", "Q - Quit" };

		// this uses html tags which is the first time i've encountered this. be sure to be able to explain this
		// design decision
		String message = "<html><center>" + "<h1>RGBC</h1>" + "<b>Richard Gwapo Banking Corporation </b>" + "<hr>"
				+ "<br><h3>MAIN MENU</h3>" + "Welcome to RGBC Banking System!<br><br>"
				+ "Please select your desired option:" + "</center<>/html>"; 

		int choice = JOptionPane.showOptionDialog(null,
				message,
				"Richard Gwapo Banking Corporation",
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

	// MAIN METHOD
	public static void main(String[] args) {
		// comment: Call the main menu method and store the result in choice 
		char choice = mainMenu();

		if (choice == 'S') {
			JOptionPane.showMessageDialog(null, "You selected Start Transaction!", "RGBC",
					JOptionPane.INFORMATION_MESSAGE);

			// OUTPUT #2 (Login) will be connected here. 

		} else {
			JOptionPane.showMessageDialog(null, 
					"Thank you for using RGBC Banking Corporation!", // message
					"RGBC", 										 // title
					JOptionPane.INFORMATION_MESSAGE);				 // type and icon
			System.exit(0); // exit the program (what if return?)
			// good!
		}

	}

}
