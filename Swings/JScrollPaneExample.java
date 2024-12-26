/*
A container has several layers in it.
You can think of a layer as a transparent film that overlays the container. 
In Java Swing, the layer that is used to hold objects is called the content pane. 
Objects are added to the content pane layer of the container.
The getContentPane() method retrieves the content pane layer 
so that you can add an object to it. 
The content pane is an object created by the Java run time environment. 
You do not have to know the name of the content pane to use it.
When you use getContentPane(), the content pane object then is
substituted there so that you can apply a method to it.*/

import javax.swing.*; 
import java.awt.FlowLayout;  
import javax.swing.JFrame;  
import javax.swing.JScrollPane.*;  
  
  
public class JScrollPaneExample {  
    
  
    
  JScrollPaneExample()
  {
        // Create and set up the window.  
        JFrame frame = new JFrame("Scroll Pane Example");  
        frame.setSize(400, 400);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
          // set flow layout for the frame  
        frame.setLayout(new FlowLayout());  
  
        JTextArea textArea = new JTextArea(20, 20);  
        JScrollPane scrollableTextArea = new JScrollPane(textArea);  
        frame.add(scrollableTextArea);  
    }  
    public static void main(String[] args)
    {  
  new JScrollPaneExample();
  
       
    }  
}