package JOptionPane;
import javax.swing.JOptionPane;
public class Sample1 {

	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		
		JOptionPane.showMessageDialog(null, "Welcome to Java");
		String name = JOptionPane.showInputDialog("Enter your name: ");
		JOptionPane.showMessageDialog(null, "Welcome! " + name);
		
		float n1 = Float.parseFloat(jop.showInputDialog("Enter 1st #: "));
		float n2 = Float.parseFloat(jop.showInputDialog("Enter 2nd #: "));
		float sum = n1 + n2;
		jop.showMessageDialog(null, sum);

	}

}
