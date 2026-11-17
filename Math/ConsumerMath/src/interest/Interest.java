package interest;

import javax.swing.JOptionPane;
import java.util.Scanner;

//Simple Interest: I = Prt
public class Interest {
	static final String[] DURATION = {"Years","Months","Days"};
	
	public static void main(String[] args) {
		String choice = getCalculationChoice();
		double result = 0.0;
		if (choice == null) return;
		switch (choice) {
			case "Interest" -> {
				double p = getPrincipal();
				double r = getRate();
				double t = getTimeInYears();
				result = calculateSimpleInterest(p,r,t);
			}
			case "Principal" -> { 
				double i = getInterest();
				double r = getRate();
				double t = getTimeInYears();
			}
				
		}
		System.out.println(result);
	}
		
	public static String getCalculationChoice() {
		final String[] SELECTION = { "Interest", "Time", "Principal", "Rate" };
		Object input = JOptionPane.showInputDialog(
				null, 							  // Component
				"What do you want to calculate?", // message
				"Input", 						  // title
				JOptionPane.QUESTION_MESSAGE, 	  // type
				null, 							  // icon
				SELECTION, 						  // selection array
				SELECTION[0]); 					  // default option
		if (input == null)
			return null;
		return (String)input;
		
	}
	public static double getInterest() {
		double interest = 0.0;
		boolean isValid = false;
		do {
			String input = JOptionPane.showInputDialog(
					null,
					"Input",
					"Enter Interest",
					JOptionPane.QUESTION_MESSAGE
					);
			if (input == null) return -1.0;
				
					
		} while (!isValid);
		return interest;
	}
	public static double getPrincipal() {
		boolean isValid = false;
		double principal = 0.0;
		do {
			String input = JOptionPane.showInputDialog(
					null, 							  // Component
					"Enter principal", // message
					"Input", 						  // title
					JOptionPane.QUESTION_MESSAGE);  // type 
			if (input == null) return 0.0;
			try {
				principal = Double.parseDouble(input);
				isValid = true;
			} catch (NumberFormatException e) {
				isValid = false;
				JOptionPane.showMessageDialog(
						null,
						"Invalid input. Try again.",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
			}
			
		} while (!isValid);
		return principal;
	}
	
	public static double getRate() {
		boolean isValid = false;
		double rate = 0.0;
		do {
			String input = JOptionPane.showInputDialog(
					null, 							  // Component
					"Enter rate as a whole number", // message
					"Input", 						  // title
					JOptionPane.QUESTION_MESSAGE);  // type 
			if (input == null) return 0.0;
			try {
				rate = Double.parseDouble(input);
				isValid = true;
			} catch (NumberFormatException e) {
				isValid = false;
				JOptionPane.showMessageDialog(
						null,
						"Invalid input. Try again.",
						"Error",
						JOptionPane.ERROR_MESSAGE
						);
			}
			
		} while (!isValid);
		return rate / 100;
	}
	
	public static double getTimeInYears() {
		boolean isValid = false;
		double time = 0.0;
		Object input = JOptionPane.showInputDialog(
				null, 
				"Select duration", 
				"Input", 
				JOptionPane.QUESTION_MESSAGE,
				null, 
				DURATION, 
				DURATION[0]);
		switch((String)input) { 
			case "Years" -> {
				do {
					String t =  JOptionPane.showInputDialog(
							null,
							"Enter time in years",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					try {
						time = Double.parseDouble(t);
						isValid = true;
					} catch (NumberFormatException e) {
						isValid = false;
						JOptionPane.showMessageDialog(
								null,
								"Invalid input. Try again.",
								"Error",
								JOptionPane.ERROR_MESSAGE
								);
					}
				} while (!isValid);
			}
			case "Months" -> { 
				do {
					String t =  JOptionPane.showInputDialog(
							null,
							"Enter time in months",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					try {
						time = Double.parseDouble(t);
						time = Time.calculateMonthsToYears(time);
						isValid = true;
					} catch (NumberFormatException e) {
						isValid = false;
						JOptionPane.showMessageDialog(
								null,
								"Invalid input. Try again.",
								"Error",
								JOptionPane.ERROR_MESSAGE
								);
					}
				} while (!isValid);
				
			}
			case "Days" -> {
				do {
					final String[] SELECTION = {"Exact","Exact (Leap year)", "Ordinary"};
					Object type = JOptionPane.showInputDialog(
							null,
							"Choose type of interest",
							"Input",
							JOptionPane.QUESTION_MESSAGE,
							null,
							SELECTION,
							SELECTION[0]
							);
					if (type == null) return 0.0;
					String t =  JOptionPane.showInputDialog(
							null,
							"Enter time in days",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					try {
						time = Double.parseDouble(t);
						time = Time.calculateDaysToYears(time,(String)type);
						isValid = true;
					} catch (NumberFormatException e) {
						isValid = false;
						JOptionPane.showMessageDialog(
								null,
								"Invalid input. Try again.",
								"Error",
								JOptionPane.ERROR_MESSAGE
								);
					}
				} while (!isValid);
			}
			
		}
		return time;
	}

	public static double calculateSimpleInterest(double p, double r, double t) {
		return p * r * t;
	}
	public static double calculateRate(double p, double i, double t) {
		return i / (p * t);
	}
	public static double calculatePrincipal(double i, double r, double t) {
		return i / (r / 100) * t;
	}
	
}
	/*
	 * switch (d) {
			case "Years" -> {
				try {
				String tInput = JOptionPane.showInputDialog(
						null,
						"Enter time in years",
						"Input",
						JOptionPane.QUESTION_MESSAGE);
				if (tInput == null) return;
				t = Double.parseDouble(tInput);
				
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				result = calculateSimpleInterest(p,r,t);
			}
			case "Days" -> {
				try {
					String tInput = JOptionPane.showInputDialog(
							null,
							"Enter time in days",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					if (tInput == null) return;
					t = Double.parseDouble(tInput);
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				t = CalculateTime.calculateDaysToYears(t);
				result = calculateSimpleInterest(p,r,t);
			}
			case "Months" -> {
				try {
					String tInput = JOptionPane.showInputDialog(
							null,
							"Enter time in months",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					if (tInput == null) return;
					t = Double.parseDouble(tInput);
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				t = CalculateTime.calculateMonthsToYears(t);
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
		}
		case "Time" -> {
			String iInput = JOptionPane.showInputDialog(
					null, 
					"Enter interest amount", 
					"Input", 
					JOptionPane.QUESTION_MESSAGE
					);
			if (iInput == null) return;
			
			String rInput = JOptionPane.showInputDialog(
					null, 
					"Enter rate as a whole number", 
					"Input",
					JOptionPane.QUESTION_MESSAGE
					);
			if (rInput == null) return;
			
			String pInput = JOptionPane.showInputDialog(
					null, 
					"Enter principal amount", 
					"Input", 
					JOptionPane.QUESTION_MESSAGE
					);
			if (pInput == null) return;
			
			i = Double.parseDouble(iInput);
			r = Double.parseDouble(rInput);
			p = Double.parseDouble(pInput);
			
			result = CalculateTime.calculateTime(i,p,r);
			
			
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
			
			
			switch (d) {
			case "Years" -> {
				try {
				String tInput = JOptionPane.showInputDialog(
						null,
						"Enter time in years",
						"Input",
						JOptionPane.QUESTION_MESSAGE);
				if (tInput == null) return;
				t = Double.parseDouble(tInput);
				
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				result = calculatePrincipal(i,r,t);
			}
			case "Days" -> {
				try {
					String tInput = JOptionPane.showInputDialog(
							null,
							"Enter time in days",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					if (tInput == null) return;
					t = Double.parseDouble(tInput);
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				t = CalculateTime.calculateDaysToYears(t);
				result = calculatePrincipal(i,r,t);
			}
			case "Months" -> {
				try {
					String tInput = JOptionPane.showInputDialog(
							null,
							"Enter time in months",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					if (tInput == null) return;
					t = Double.parseDouble(tInput);
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				t = CalculateTime.calculateMonthsToYears(t);
				result = calculatePrincipal(i,r,t);
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
			
			switch (d) {
			case "Years" -> {
				try {
				String tInput = JOptionPane.showInputDialog(
						null,
						"Enter time in years",
						"Input",
						JOptionPane.QUESTION_MESSAGE);
				if (tInput == null) return;
				t = Double.parseDouble(tInput);
				
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				result = calculateRate(p,i,t);
			}
			case "Days" -> {
				try {
					String tInput = JOptionPane.showInputDialog(
							null,
							"Enter time in days",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					if (tInput == null) return;
					t = Double.parseDouble(tInput);
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				t = CalculateTime.calculateDaysToYears(t);
				result = calculateRate(p,i,t);
			}
			case "Months" -> {
				try {
					String tInput = JOptionPane.showInputDialog(
							null,
							"Enter time in months",
							"Input",
							JOptionPane.QUESTION_MESSAGE);
					if (tInput == null) return;
					t = Double.parseDouble(tInput);
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
				t = CalculateTime.calculateMonthsToYears(t);
				result = calculateRate(p,i,t);
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
		String formatted = String.format("%.4f", result);
		JOptionPane.showMessageDialog(null, formatted);
		*/
