package mmw;

public class SimpleInterest {
	void main() {
		// Simple Interest
		// I = Prt
		IO.print("What do you want to calculate?\n" +
	             "\tI for interest\n" +
				 "\tT for time\n" +
	             "\tP for prinicipal\n");
		String input = IO.readln();
		if (input.trim().equalsIgnoreCase("I")) { 
			IO.print("Enter principal amount: ");
			double p = Double.parseDouble(IO.readln());
			IO.print("Enter rate in percentage: ");
			double r = Double.parseDouble(IO.readln());
			
			IO.print("Enter D for days\n"
					+ "      M for months\n"
					+ "      Y for years\n");
			String d = IO.readln();
			double interest = calculateSimpleInterest(p,r,d);
			if (interest == -1)
				System.out.println("Error occurred. Please try again.");
			else
				displayInterest();
				
		}
		else if (input.trim().equalsIgnoreCase("T")) {
			IO.print("Enter interest: ");
			double i = Double.parseDouble(IO.readln());
			IO.print("Enter principal: ");
			double p = Double.parseDouble(IO.readln());
			IO.print("Enter rate: ");
			double r = Double.parseDouble(IO.readln());
			System.out.printf("%s%.2f%n", "Time in years: ", calculateTime(i,p,r));
			IO.print("Would you like to convert it into YY/MM/DD format?" +
					 "\n\tY - Yes\n\tn - no");
			if(IO.readln().trim().equalsIgnoreCase("Y")) { }
				//convertTimeFormat();
			
		}
		
		
		
		
	}
	void displayInterest() {
		
	}
	
	double calculateSimpleInterest(double p, double r, String d) {
		double t = 0.0;
		if (d.trim().equalsIgnoreCase("D")) {
			IO.print("Enter time in days: ");
			t = Double.parseDouble(IO.readln());
			IO.print("Enter O for ordinary interest\n"
					+"      E for exact interest\n");
			String type = IO.readln();
			if (type.trim().equalsIgnoreCase("O"))
				t = calculateDaysToYears(t,360);
			else if (type.trim().equalsIgnoreCase("E"))
				t = calculateDaysToYears(t,365);
			else {
				IO.println("Invalid interest type.\n" + "Try again.");
				return -1;
			}
		
		}
		else if (d.trim().equalsIgnoreCase("M")) {
			IO.print("Enter time in months: ");
			t = Double.parseDouble(IO.readln());
			t = calculateMonthsToYears(t);
		} 
		else if (d.trim().equalsIgnoreCase("Y")) {
			IO.print("Enter time in years: ");
			t = Double.parseDouble(IO.readln());
		}
		else {
			IO.println("Invalid input, please try again.");
			return 0;
		}
	
		double interest = p * (r / 100.0) * t;
		return interest;
	}
	double calculateDaysToYears(double t, int d) {
		t = t / d;
		return t;
	}
	double calculateMonthsToYears(double t) {
		t = t / 12;
		return t;
	}
	double calculateTime(double i, double p, double r) {
		r = r / 100.0;
		double time = i/(p*r);
		return time;
	}
	
}
