import java.awt.*;  
import java.awt.event.*;  
class WindowActionEventExample extends Frame implements ActionListener,WindowListener
{  
TextField tf;  
WindowActionEventExample()
{  
  
//create components  
tf=new TextField();  
tf.setBounds(60,50,170,20);  
Button b=new Button("click me");  
b.setBounds(100,120,80,30);  
  
//register listener  
b.addActionListener(this);//passing current instance 
addWindowListener(this);    
  
//add components and set size, layout and visibility  
add(b);add(tf);  
add(b);add(tf);  
setSize(300,300);  
setLayout(null);  
setVisible(true);  
}  
public void actionPerformed(ActionEvent e)
{  
tf.setText("Welcome");  
} 



public void windowActivated (WindowEvent arg0) {    
   System.out.println("activated");    
}    
  
// overriding windowClosed() method of WindowListener interface which prints the given string when window is closed  
public void windowClosed (WindowEvent arg0) {    
    System.out.println("closed");    
}    
  
// overriding windowClosing() method of WindowListener interface which prints the given string when we attempt to close window from system menu  
public void windowClosing (WindowEvent arg0) {    
    System.out.println("closing");    
    dispose();    
}    
  
// overriding windowDeactivated() method of WindowListener interface which prints the given string when window is not active  
public void windowDeactivated (WindowEvent arg0) {    
   System.out.println("deactivated");    
}    
  
// overriding windowDeiconified() method of WindowListener interface which prints the given string when window is modified from minimized to normal state  
public void windowDeiconified (WindowEvent arg0) {    
    System.out.println("deiconified");    
}    
  
// overriding windowIconified() method of WindowListener interface which prints the given string when window is modified from normal to minimized state  
public void windowIconified(WindowEvent arg0) {    
   System.out.println("iconified");    
}    
  
// overriding windowOpened() method of WindowListener interface which prints the given string when window is first opened  
public void windowOpened(WindowEvent arg0) {    
    System.out.println("opened");    
}    
    
public static void main(String args[])
{  
new WindowActionEventExample();  
}  
}  