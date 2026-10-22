package mmw;

import java.util.Scanner;

public class PearsonCoefficient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of values: ");
		int num = sc.nextInt();
		double pearson = calculatePearson(num, sc);
		displayCorrelation(pearson);
	}

	private static double calculatePearson(int n, Scanner sc) {
		long sumX = 0;
		long sumY = 0;
		long sumX2 = 0;
		long sumY2 = 0;
		long sumXY = 0;
		int X[] = new int[n];
		int Y[] = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter X: ");
			sumX += X[i];
		}
		for (int i = 0; i < n; i++) {
			System.out.print("Enter Y: ");
			Y[i] = sc.nextInt();
			sumY += Y[i];
		}
		for (int i = 0; i < n; i++) {
			sumXY += X[i] * Y[i];
			sumX2 += X[i] * X[i];
			sumY2 += Y[i] * Y[i];
		}
		double pearson = (n * sumXY - sumX * sumY)
				/ Math.sqrt((n * sumX2 - (sumX * sumX)) * (n * sumY2 - (sumY * sumY)));
		return pearson;
	}

	private static void displayCorrelation(double pearson) {
		System.out.printf("%s%.2f%n", "Pearson correlation coefficient: ", pearson);
		if (Math.abs(pearson) >= 0.995)
			System.out.println("Perfect correlation");
		else if (Math.abs(pearson) >= 0.80)
			System.out.println("High correlation");
		else if (Math.abs(pearson) >= 0.60)
			System.out.println("Moderately High correlation");
		else if (Math.abs(pearson) >= 0.40)
			System.out.println("Moderate correlation");
		else if (Math.abs(pearson) >= 0.20)
			System.out.println("Low correlation");
		else if (Math.abs(pearson) >= 0.01)
			System.out.println("Negligible correlation");
		else
			System.out.println("No correlation");
	}

}
