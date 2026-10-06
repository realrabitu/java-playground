package StringManipulationMethods;

public class replaceMethod {

	public static void main(String[] args) {
		String str1 = "Kaeya Alberich is a cryo character in Genshin.";
		String str2 = str1.replace('e', 'a');
		System.out.println(str2);
		String str3 = str1.replaceAll("[aeiou]", "-");
		System.out.println(str3);
		
		String str4 = "THE quick brown fox jumps over the lazy dog, but the DOg! got mad at the Fox";
		String str5 = "(?i)dog";
		System.out.println(str4.replaceAll(str5, "finnegan"));
	}
	

}