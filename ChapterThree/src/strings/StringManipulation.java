package strings;

public class StringManipulation {

	public static void main(String[] args) {
		// PRE: Two ways to create a string
		String myString = "LOL!";
		String myString2 = new String("LOL2!");
		
		// 1. length()
		String str = "Hello, World!";
		System.out.println("Length: " + str.length());
		
		// 2. charAt()
		System.out.println("Character at index 0: " + str.charAt(0));
		char tenthChar = str.charAt(9);
		System.out.println("Character at index 9: " + tenthChar);
		String substr1 = str.substring(7,13);
		System.out.println(substr1);
		
		
	}

}
