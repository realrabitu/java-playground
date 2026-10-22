package mmw;
public class SimpleInterest {
	void main() {
		IO.print("What do you want to calculate?\n" +
	             "\tI for interest\n" +
				 "\tT for time\n" +
	             "\tP for prinicipal\n");
		IO.print("Enter principal amount: ");
		double p = Double.parseDouble(IO.readln());
		IO.print("Enter rate in percentage: ");
		double r = Double.parseDouble(IO.readln());
		IO.print("Enter D for days\n"
				+ "      M for months\n"
				+ "      Y for years\n");
		String d = IO.readln();
		double interest = calculateSimpleInterest(p,r,d);
		if (interest == -1) {
			System.out.println("Error occurred. Please try again.");
		}
		
		
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
	
		double interest = p * r * t;
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
	
}
