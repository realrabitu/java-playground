package six_two;

import java.util.Scanner;

public class Palindrome {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter a word or string of letters: ");
		String str = sc.nextLine();
		boolean result = isPalindrome(str);
		System.out.println("\""+str + "\"" +  " is a palindrome: " + result);

	}
	public static boolean isPalindrome(String str) {
		String reversed = "";
		// Regex pattern: replace all whitespaces
		str = str.replaceAll("\\s+", "");
		// Regex pattern: replace all punctuation
		str = str.replaceAll("\\p{Punct}","");
		for (int i = str.length() - 1; i >= 0; i--)
			reversed += str.charAt(i);
		
		if (reversed.equalsIgnoreCase(str))
			return true;
		return false;
	}

}
