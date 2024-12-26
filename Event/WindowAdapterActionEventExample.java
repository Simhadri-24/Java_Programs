import java.awt.*;  
import java.awt.event.*;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;  

  

public class WindowAdapterActionEventExample implements ActionListener
{  
TextField tf;  
WindowAdapterActionEventExample()
{  
  
//create components
Frame f = new Frame();  
tf=new TextField();  
tf.setBounds(60,50,170,20);  
Button b=new Button("click me");  
b.setBounds(100,120,80,30);  
  
//register listener  
b.addActionListener(this);//passing current instance 
        
f.addWindowListener(new WindowAdapter() {    
    public void windowClosing(WindowEvent e) 
	{    
        f.dispose();    
                 
    }    
    });     
  
//add components and set size, layout and visibility  
f.add(b);f.add(tf);    
f.setSize(300,300);  
f.setLayout(null);  
f.setVisible(true);  
}  
public void actionPerformed(ActionEvent e)
{  
tf.setText("Welcome");  
} 
  
public static void main(String args[])
{  
new WindowAdapterActionEventExample();  
}  
}  