import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JButtonExample3 extends JFrame implements ActionListener
{ 
    JLabel jlab;
	JButtonExample3()
	{
		// Change to flow layout.
		setLayout(new FlowLayout());
		// Add buttons to content pane.
		ImageIcon hourglass = new ImageIcon("E:\\s1.png");
		JButton jb = new JButton(hourglass);
		jb.setActionCommand("Hourglass");
		jb.addActionListener(this);
		add(jb);
		ImageIcon analog = new ImageIcon("E:\\s1.png");
		jb = new JButton(analog);
		jb.setActionCommand("Analog Clock");
		jb.addActionListener(this);
		add(jb);
		ImageIcon digital = new ImageIcon("E:\\s1.png");
		jb = new JButton(digital);
		jb.setActionCommand("Digital Clock");	
		jb.addActionListener(this);
		add(jb);
		ImageIcon stopwatch = new ImageIcon("E:\\s1.png");
		jb = new JButton(stopwatch);
		jb.setActionCommand("Stopwatch");
		jb.addActionListener(this);
		add(jb);
		// Create and add the label to content pane.
		jlab = new JLabel("Choose a Timepiece");
		add(jlab);
	}
	// Handle button events.
	public void actionPerformed(ActionEvent ae)
	{
	jlab.setText("You selected " + ae.getActionCommand());
	}

	public static void main(String args[])
	{
		new JButtonExample3();
	}
}