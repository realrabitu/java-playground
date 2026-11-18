package six_one;

public class PrimeCheck {

	public static void main(String[] args) {
		int number = 17;
		boolean result = isPrime(number);
		System.out.println(number + " is prime: " + result);

	}
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
