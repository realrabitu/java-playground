package solutions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ShaunsSolution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("ENTER YOUR NAME: ");
		String ename = (br.readLine());

		System.out.println("(Manager, Supervisor, Employee)");

		System.out.print("ENTER POSITION: ");
		String position = (br.readLine());       

		double ratePerDay = 0;
		if (position.equalsIgnoreCase("Manager")) {
			ratePerDay = 500;
		} else if (position.equalsIgnoreCase("Supervisor")) {
			ratePerDay = 400;
		} else if (position.equalsIgnoreCase("Employee")) {
			ratePerDay = 300;
		} else {
			System.out.print("Invalid position.");
			return;
		}
		System.out.print("ENTER NUMBER OF DAYS WORKED: ");
		int daysWorked = Integer.parseInt(br.readLine());
		// GROSS INCOME NEGZZZ
		double gross = ratePerDay * daysWorked;
		// BOWNUZZ
		double bonus;
		if (gross >= 8000) {
			bonus = 1000;
		} else if (gross >= 5000) {
			bonus = 750;
		} else if (gross >= 3000) {
			bonus = 500;
		} else {
			bonus = 0;
		}
		// DEDUCTIONS
		double sss = gross * 0.10;
		double medicare = 100;
		double tax;
		if (gross >= 7000) {
			tax = gross * 0.15;
		} else if (gross >= 4000) {
			tax = gross * 0.10;
		} else if (gross >= 2000) {
			tax = gross * 0.05;
		} else {
			tax = 0;
		}
		double totalDeduction = sss + medicare + tax;
		// COMPUTE NET INCOME
		double netIncome = gross + bonus - totalDeduction;
		// RESULT
		System.out.printf(
				"==========================================================\n"
						+ "                  ##EMPLOYEE PAYSLIP##      \n"
						+ "==========================================================\n"
						+ "__________________EMPLOYEE INFORMATION____________________\n"
						+ "----------------------------------------------------------\n"
						+ "   NAME                             : " + ename.toUpperCase()
						+ "\n   POSITION                      : " + position.toUpperCase()
						+ "\n   DAYS WORKED            : " + daysWorked
						+ "\n   RATE PER DAY             : ₱" + String.format("%.2f", ratePerDay)
						+ "\n----------------------------------------------------------\n"
						+ "GROSS INCOME              : ₱" + String.format("%.2f", gross)
						+ "\nBONUS                              : ₱" + String.format("%.2f", bonus)
						+ "\n==========================================================\n"
						+ "_______________________DEDUCTIONS_________________________\n"
						+ "----------------------------------------------------------\n"
						+ "   SSS                                  : ₱" + String.format("%.2f", sss)
						+ "\n   MEDICARE                      : ₱" + String.format("%.2f", medicare)
						+ "\n   TAX                                   : ₱" + String.format("%.2f", tax)
						+ "\n----------------------------------------------------------\n"
						+ "TOTAL DEDUCTIONS      : ₱" + String.format("%.2f", totalDeduction)
						+ "\n==========================================================\n"
						+ "NET INCOME                     : ₱" + String.format("%.2f", netIncome)
						+ "\n==========================================================\n",
						"EMPLOYEE PAYSLIP"                 
				);


	}
}
