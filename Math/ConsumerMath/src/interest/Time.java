package interest;

public class Time {
	public static void main(String[] args) {
	
	}
	public static double calculateTime(double i, double p, double r) {
		r = r / 100.0;
		double time = i/(p*r);
		return time;
	}
	public static double calculateDaysToYears(double t, String type) {
		switch (type) {
			case "Exact" -> t = t / 365;
			case "Exact (Leap Year)" -> t = t / 366;
			case "Ordinary" -> t = t / 360;
		}
		return t;
	}
	public static double calculateMonthsToYears(double t) {
		t = t / 12;
		return t;
	}
}
