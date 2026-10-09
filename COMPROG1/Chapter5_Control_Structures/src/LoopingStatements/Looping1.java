package LoopingStatements;
import javax.swing.JOptionPane;
public class Looping1 {
	int x = 0;
 	public static void main(String[] args) {
 		try { 
 			String i = JOptionPane.showInputDialog("Enter name");
 			String j = i.trim();
 			
 		} catch (Exception e) {  
 			System.out.println(e.notify());
 		} 
		finally { System.out.println("LOL"); 
		
		} 
	}

}


