package MethodPrograms;
import java.io.Console;
import java.util.Random;
public class Method3 {
	void main() {
		Random random = new Random(40);
		int randomInt;
		for (int i = 0; i < 5; i++) {
			randomInt = random.nextInt(100);
			System.out.println(randomInt);
		}
	}
}
