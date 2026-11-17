package mmw;

public class CalculateTime {
	public static void main(String[] args) {
	
	}
	public static double calculateTime(double i, double p, double r) {
		r = r / 100.0;
		double time = i/(p*r);
		return time;
	}
	public static double calculateDaysToYears(double t, int d) {
		t = t / d;
		return t;
	}
	public static double calculateMonthsToYears(double t) {
		t = t / 12;
		return t;
	}
}
