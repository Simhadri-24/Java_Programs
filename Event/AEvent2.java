import java.awt.*;  
import java.awt.event.*; 

class Outer implements ActionListener
{  
    AEvent2 obj;  
    Outer(AEvent2 obj)
    {  
        this.obj=obj;  
    }  
    public void actionPerformed(ActionEvent e)
    {  
        obj.tf.setText("welcome");  
    }  
}    
public class AEvent2 extends Frame
{  
    TextField tf;  
    AEvent2()
    {    
        tf=new TextField();  
        tf.setBounds(60,50,170,20);  
        Button b=new Button("click me");  
        b.setBounds(100,120,80,30);  
        //register listener  
        Outer o=new Outer(this);  
        b.addActionListener(o);//passing outer class instance  
        //add components and set size, layout and visibility  
        add(b);
        add(tf);  
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);  
    }  
    public static void main(String args[])
    {  
        new AEvent2();  
    }
}  