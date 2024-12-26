// Java  Program to create a simple 
// choice and add ItemListener to it 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
  
class choice implements ItemListener { 
  
    // choice 
    Choice c; 
  
    // frame 
    Frame f; 
  
    // label 
    Label l; 
  
    // default constructor 
    choice() 
    { 
    } 
  
    // Main Method 
    public static void main(String args[]) 
    { 
  
        // create a frame 
        f = new Frame("choice"); 
  
        // object 
        choice ch = new choice(); 
  
        // create e panel 
        //JPanel p = new JPanel(); 
  
        // create a choice 
        c = new Choice(); 
  
        // add element to the list 
        c.add("Andrew"); 
        c.add("Arnab"); 
        c.add("Ankit"); 
  
        // add itemListener to it 
        c.addItemListener(ch); 
  
        // create a label 
        l = new Label(); 
  
        // set the label text 
        l.setText(c.getSelectedItem() + " selected"); 
  
        // add choice to panel 
        f.add(c); 
        f.add(l); 
  
        // add panel to the frame 
        //f.add(p); 
  
        // show the frame 
		f.setLayout(null);
        f.setVisible(true); 
        f.setSize(300, 300); 
    } 
  
    // if an item is selected 
    public void itemStateChanged(ItemEvent e) 
    { 
        l.setText(c.getSelectedItem() + " selected"); 
    } 
} 