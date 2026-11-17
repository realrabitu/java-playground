package mmw;

import javax.swing.JOptionPane;
import java.util.Scanner;

//Simple Interest: I = Prt
public class SimpleInterest {
	static double p = 0.0, r = 0.0, i = 0.0, t = 0.0;
	static String d = "";
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String[] duration = { "Days", "Months", "Years" };
		String[] selection = { "Interest", "Time", "Principal", "Rate" };
		double result = 0.0;
		Object objInput = JOptionPane.showInputDialog(
				null, 							  // Component
				"What do you want to calculate?", // message
				"Input", 						  // title
				JOptionPane.QUESTION_MESSAGE, 	  // type
				null, 							  // icon
				selection, 						  // selection array
				selection[0]); 					  // default option
		if (objInput == null)
			return;

		String input = (String) objInput;

		switch (input) {
		case "Interest" -> {
			try {
				p = Double.parseDouble(
						JOptionPane.showInputDialog(
								null, 
								"Enter principal amount", 
								"Input", 
								JOptionPane.QUESTION_MESSAGE)
						);
				
				r = Double.parseDouble(
						JOptionPane.showInputDialog(null, 
								"Enter rate as a whole number", 
								"Input",
								JOptionPane.QUESTION_MESSAGE)
						);
			} 
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, e);
				return;
			} 
			
			Object dr = JOptionPane.showInputDialog(null, 
					"Select duration", 
					"Input", 
					JOptionPane.QUESTION_MESSAGE,
					null, 
					duration, 
					duration[0]);
			d = (String) dr;
			switch (d) {
			case "Years" -> {
				t = Double.parseDouble(
						JOptionPane.showInputDialog(
								null,
								"Enter time in years",
								"Input",
								JOptionPane.QUESTION_MESSAGE
								)
						);
				result = calculateSimpleInterest(p,r,t);
				break;
			}
			case "Days" -> {
				t = Double.parseDouble(
						JOptionPane.showInputDialog(
								null,
								"Enter time in days",
								"Input",
								JOptionPane.QUESTION_MESSAGE
								)
						);
				result = calculateSimpleInterest(p,r,t);
				break;
			}
			case "Months" -> {
				t = Double.parseDouble(
						JOptionPane.showInputDialog(
								null,
								"Enter time in months",
								"Input",
								JOptionPane.QUESTION_MESSAGE
								)
						);
				result = calculateSimpleInterest(p,r,t);
				break;
			}
			default ->
				JOptionPane.showMessageDialog(
						null,
						"Invalid input. Try again.",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
			}
			break;
		}
		case "Time" -> {
			i = Double.parseDouble(
					JOptionPane.showInputDialog(null, 
							"Enter interest amount", 
							"Input", 
							JOptionPane.QUESTION_MESSAGE
							)
					);
			r = Double.parseDouble(
					JOptionPane.showInputDialog(
							null, 
							"Enter rate as a whole number", 
							"Input",
							JOptionPane.QUESTION_MESSAGE
							)
					);
			p = Double.parseDouble(
					JOptionPane.showInputDialog(
							null, 
							"Enter principal amount", 
							"Input", 
							JOptionPane.QUESTION_MESSAGE
							)
					);
			break;
		}
		case "Principal" -> {

			i = Double.parseDouble(
					JOptionPane.showInputDialog(null, 
							"Enter interest amount", 
							"Input", 
							JOptionPane.QUESTION_MESSAGE)
					);

			r = Double.parseDouble(
					JOptionPane.showInputDialog(null, 
							"Enter rate as a whole number", 
							"Input", 
							JOptionPane.QUESTION_MESSAGE)
					);
			Object dr = JOptionPane.showInputDialog(null, 
					"Select duration", "Input", JOptionPane.QUESTION_MESSAGE,
					null, duration, duration[0]);
			d = (String) dr;
			break;
		}
		case "Rate" -> {
			i = Double.parseDouble(
					JOptionPane.showInputDialog(null, 
							"Enter interest amount", 
							"Input", 
							JOptionPane.QUESTION_MESSAGE)
					);
			p = Double.parseDouble(
					JOptionPane.showInputDialog(
							null, 
							"Enter principal amount", 
							"Input", 
							JOptionPane.QUESTION_MESSAGE)
					);
			Object dr = JOptionPane.showInputDialog(null, "Select duration", "Input", JOptionPane.QUESTION_MESSAGE,
					null, duration, duration[0]);
			d = (String) dr;
			
		}

		default -> {
			JOptionPane.showMessageDialog(
					null,
					"Invalid input. Try again",
					"Error",
					JOptionPane.ERROR_MESSAGE
					);
			return;
		}
		}
		

	}

	public static double calculateSimpleInterest(double p, double r, double t) {

		return 0;
	}
}
