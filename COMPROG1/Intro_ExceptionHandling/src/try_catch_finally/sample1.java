package try_catch_finally;
import javax.swing.JOptionPane;
public class sample1 {
	int x = 0;
 	public static void main(String[] args) {
 		try { 
 			String i = JOptionPane.showInputDialog("Enter name");
 			String j = i.trim();
 			
 		} catch (Exception e) {  
 			System.out.println(e.getMessage());
 		} finally { 
 			System.out.println("Bye..."); 
		} 
	}

}


