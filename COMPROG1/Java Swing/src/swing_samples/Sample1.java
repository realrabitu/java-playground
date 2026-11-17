package swing_samples;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

public class Sample1 {

    public static void main(String[] args) {
        // Safe execution: Schedule the GUI construction on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // 1. Create the main window frame
        JFrame frame = new JFrame("Swing App Demonstration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // 2. Set the Layout Manager (arranges components inside the window)
        frame.setLayout(new FlowLayout());

        // 3. Create interactive components
        JLabel messageLabel = new JLabel("Click the button below:");
        JButton actionButton = new JButton("Click Me!");

        // 4. Add an Event Listener to handle button clicks
        actionButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Hello! You interacted with Java Swing.");
        });

        // 5. Add elements into the frame layout
        frame.add(messageLabel);
        frame.add(actionButton);

        // 6. Center the window on screen and make it visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
