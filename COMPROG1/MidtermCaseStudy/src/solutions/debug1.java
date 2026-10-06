package solutions;
import javax.swing.JOptionPane;
public class debug1 {

	public static void main(String[] args) {
		String number = JOptionPane.showInputDialog("Enter number");
		System.out.println(Integer.parseInt(number.trim()));
	}

}
