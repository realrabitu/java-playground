package five_two;

public class Three_Palindrome {

	public static void main(String[] args) {
		String reversed = "";
		IO.print("Enter a word or string of letters: "); // A man a plan a canal Panama
		String original = IO.readln();
		original = original.replaceAll("\\s+", "");
		for (int i = original.length() - 1; i >= 0; i--) {
			reversed += original.charAt(i);
			
		}
		IO.println("Reversed: " + reversed);
		if (original.equalsIgnoreCase(reversed))
			IO.println("Palindrome");
		else
			IO.println("Not a palindrome");

	}

}
