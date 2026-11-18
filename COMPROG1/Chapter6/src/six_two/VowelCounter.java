package six_two;

import java.util.Scanner;

public class VowelCounter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = sc.nextLine();
        System.out.println("Number of vowels: " + countVowels(text));

	}
	  public static int countVowels(String str) {
	        int count = 0;
	        str = str.toLowerCase();

	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	                count++;
	            }
	        }
	        return count;
	    }


}
