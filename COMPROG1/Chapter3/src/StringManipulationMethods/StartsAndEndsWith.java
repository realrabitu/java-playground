package StringManipulationMethods;

public class StartsAndEndsWith {

	public static void main(String[] args) {
		String str1 = "Kaeya Alberich is a cryo character in Genshin.";
		boolean startsStr = str1.startsWith("Kaeya"); 
		System.out.println("Starts with \"Kaeya\": " + startsStr); // true
		System.out.println("Starts with \"Kae\": " + str1.startsWith("Kae")); // true
		System.out.println("Starts with \"KAEYA\": " + str1.startsWith("KAEYA")); // false
		
		System.out.println(str1.endsWith("Genshin")); // false! 
		System.out.println(str1.endsWith("Genshin.")); // True
		
	}

}
