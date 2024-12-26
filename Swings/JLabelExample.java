import java.awt.*;  
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
public class JLabelExample {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Demo Frame");
      //frame.setLayout(new FlowLayout(FlowLayout.LEFT)); 
      JLabel label = new JLabel("Smiley label");
      label.setIcon(new ImageIcon("E:\\s1.png"));
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.add(label);
      frame.setSize(500, 300);
      frame.setVisible(true);
   }
}