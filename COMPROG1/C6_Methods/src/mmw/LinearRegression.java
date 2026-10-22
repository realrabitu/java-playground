package mmw;

import java.util.Scanner;

public class LinearRegression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of values: ");
		int numVal = sc.nextInt();
		System.out.print("Enter value of predictor variable: ");
		int predictor = sc.nextInt();
		double regression = calculateLR(numVal, predictor, sc);
		displayPrediction(regression);

	}

	public static double calculateLR(int n, int predictor, Scanner sc) {
		double sumX = 0;
		double sumY = 0.0;
		double sumXY = 0.0;
		double sumX2 = 0.0;
		// Test cases
		// int X[] = {2,3,4,6,6,7,7,7,8,8,9,9,10,10};
		// int Y[] = {45,46,56,53,64,74,73,75,68,93,84,92,95,94};
		int X[] = new int[n];
		int Y[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Enter X values: ");
			X[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			System.out.print("Enter Y values: ");
			Y[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			sumX += X[i];
			sumY += Y[i];
			sumXY += X[i] * Y[i];
			sumX2 += X[i] * X[i];
		}
		double yIntercept = Math.round(((sumY * sumX2 - sumX * sumXY) / (n * sumX2 - sumX * sumX)) * 100.0) / 100.0;
		;
		double slope = Math.round(((n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX)) * 100.0) / 100.0;
		double regression = yIntercept + slope * predictor;
		return regression;
	}

	static void displayPrediction(double regression) {
		System.out.printf("%s~%.2f", "Estimated predicted value: ", regression);
	}

}
