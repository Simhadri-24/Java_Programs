import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MenuCheckDemo implements ActionListener {
JLabel jlab;
MenuCheckDemo() {
// Create a new JFrame container.
JFrame jfrm = new JFrame("Menu Demo");

// Specify FlowLayout for the layout manager.
jfrm.setLayout(new FlowLayout());
// Give the frame an initial size.
jfrm.setSize(220, 200);
// Terminate the program when the user closes the application.
jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Create a label that will display the menu selection.
jlab = new JLabel();
// Create the menu bar.
JMenuBar jmb = new JMenuBar();
// Create the File menu.

JMenu jmFile = new JMenu("File");
jmFile.setMnemonic(KeyEvent.VK_F);
JMenuItem jmiOpen = new JMenuItem("Open",KeyEvent.VK_O);
jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
JMenuItem jmiClose = new JMenuItem("Close",KeyEvent.VK_C);
jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
JMenuItem jmiSave = new JMenuItem("Save",KeyEvent.VK_S);
jmiSave.setAccelerator(
KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
JMenuItem jmiExit = new JMenuItem("Exit",KeyEvent.VK_E);
jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_DOWN_MASK));




jmFile.add(jmiOpen);
jmFile.add(jmiClose);
jmFile.add(jmiSave);
jmFile.addSeparator();
jmFile.add(jmiExit);
jmb.add(jmFile);




// Create the Options menu.
JMenu jmOptions = new JMenu("Options");
// Create the Colors submenu.
JMenu jmColors = new JMenu("Colors");
// Use check boxes for colors. This allows
// the user to select more than one color.
JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");
jmColors.add(jmiRed);
jmColors.add(jmiGreen);
jmColors.add(jmiBlue);
jmOptions.add(jmColors);
// Create the Priority submenu.
JMenu jmPriority = new JMenu("Priority");
// Use radio buttons for the priority setting.
// This lets the menu show which priority is used
// but also ensures that one and only one priority
// can be selected at any one time. Notice that
// the High radio button is initially selected.
JRadioButtonMenuItem jmiHigh =
new JRadioButtonMenuItem("High", true);
JRadioButtonMenuItem jmiLow =
new JRadioButtonMenuItem("Low");
jmPriority.add(jmiHigh);
jmPriority.add(jmiLow);
jmOptions.add(jmPriority);
// Create button group for the radio button menu items.
ButtonGroup bg = new ButtonGroup();
bg.add(jmiHigh);
bg.add(jmiLow);
// Create the Reset menu item.
JMenuItem jmiReset = new JMenuItem("Reset");
jmOptions.addSeparator();
jmOptions.add(jmiReset);
// Finally, add the entire options menu to
// the menu bar
jmb.add(jmOptions);





// Create the Help menu.
JMenu jmHelp = new JMenu("Help");
ImageIcon icon = new ImageIcon("E:\\hourglass.png");
JMenuItem jmiAbout = new JMenuItem("About", icon);
//JMenuItem jmiAbout = new JMenuItem("About");
jmHelp.add(jmiAbout);
jmb.add(jmHelp);
// Add action listeners for the menu items.
jmiOpen.addActionListener(this);
jmiClose.addActionListener(this);
jmiSave.addActionListener(this);
jmiExit.addActionListener(this);
jmiRed.addActionListener(this);
jmiGreen.addActionListener(this);
jmiBlue.addActionListener(this);
jmiHigh.addActionListener(this);
jmiLow.addActionListener(this);
jmiReset.addActionListener(this);
jmiAbout.addActionListener(this);
// Add the label to the content pane.
jfrm.add(jlab);
// Add the menu bar to the frame.
jfrm.setJMenuBar(jmb);
// Display the frame.
jfrm.setVisible(true);
}
// Handle menu item action events.
public void actionPerformed(ActionEvent ae) {
// Get the action command from the menu selection.
String comStr = ae.getActionCommand();
// If user chooses Exit, then exit the program.
if(comStr.equals("Exit")) System.exit(0);
// Otherwise, display the selection.
jlab.setText(comStr + " Selected");
}
public static void main(String args[]) {
// 
new MenuCheckDemo();
}

}