package StringManipulationMethods;

public class contains {

	public static void main(String[] args) {
		String str1 = "Kaeya Alberich is a cryo character in Genshin.";
		boolean containsStr = str1.contains("c"); // true
		System.out.println(containsStr);
		String str2 = str1.concat(".. ").concat("Diluc is a pyro character.").concat(":)");
		System.out.println(str2);
	
	}

}
