import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;  
public class JListExample  
{  
     public static void main(String args[])
     {  
        JFrame f= new JFrame();  
        JLabel label = new JLabel();          
        label.setSize(700,100);  
        JButton b=new JButton("Show");  
        b.setBounds(200,150,80,30);  
        
        String l1[] = {"C","C++","Java", "PHP"};  
           
          JList<String> list1 = new JList<>(l1);
          list1.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);  
          list1.setBounds(100,100, 75,75);  
          String l2[] = {"Turbo c++","Struts", "Spring", "YII"};
           
          JList<String> list2 = new JList<>(l2);  
          list2.setBounds(100,200, 75,75);  
          f.add(list1); f.add(list2); f.add(b); f.add(label);  
          f.setSize(450,450);  
          f.setLayout(null);  
          f.setVisible(true); 

          b.addActionListener(new ActionListener() {  
              public void actionPerformed(ActionEvent e) {   
                 String data = "";  
                 if (list1.getSelectedIndex() != -1) {                       
                    data = "Programming language Selected: " + list1.getSelectedValue();   
                    label.setText(data);  
                 }  
                 if(list2.getSelectedIndex() != -1){  
                    data += ", FrameWork Selected: ";  
                    for(Object frame :list2.getSelectedValues()){  
                       data += frame + " ";  
                    }  
                 }  
                 label.setText(data);  
              }  
           });   
     }  
}