package LoopingStatements;

public class sample2 {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("umak-ccis");
			}
			else if (i % 3 == 0 ) {
				System.out.println("umak");
			}
			else if (i % 5 == 0) {
				System.out.println("ccis");
			} 
			else
				System.out.println(i);
		}

	}

}
