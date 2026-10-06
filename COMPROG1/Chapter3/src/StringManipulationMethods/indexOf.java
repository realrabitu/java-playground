package StringManipulationMethods;

public class indexOf {

	public static void main(String[] args) {
		String str1 = "Kaeya Alberich is a cryo character in Genshin.";
		int indexStr1 = str1.indexOf('a');
		System.out.println(indexStr1);
		
		int lastIndexStr1 = str1.lastIndexOf('a');
		System.out.println(lastIndexStr1);

	}

}
