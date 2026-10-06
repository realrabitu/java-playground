package BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.io.*;
public class Sample1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Fahrenheit to celsius");
		System.out.print("Enter fahrenheit: ");
		String strFahrenheit = br.readLine();
		double fahrenheit = Double.parseDouble(strFahrenheit);
		double celsius = (fahrenheit - 32) * 5/9;
		System.out.printf("%f %s %.2f %s", fahrenheit, " fahrenheit is: ", celsius, " celsius");
	}
}