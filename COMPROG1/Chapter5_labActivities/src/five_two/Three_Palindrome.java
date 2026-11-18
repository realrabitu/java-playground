package five_two;
import java.util.Scanner;

public class Three_Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String reversed = "";
		System.out.print("Enter a word or string of letters: "); // A man a plan a canal Panama
		String original = sc.nextLine();
		// Regex pattern: replace all whitespaces 
		original = original.replaceAll("\\s+", "");
		original = original.replaceAll("\\p{Punct}","");
		for (int i = original.length() - 1; i >= 0; i--) {
			reversed += original.charAt(i);
			
		}
		System.out.println("Reversed: " + reversed);
		if (original.equalsIgnoreCase(reversed))
			System.out.println("Palindrome");
		else
			System.out.println("Not a palindrome");

	}

}
