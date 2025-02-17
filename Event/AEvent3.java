import java.awt.*;
import java.awt.event.*;
 
class AEvent3 extends Frame
{
 
    TextField textField;
 
    AEvent3()
    {
        // Component Creation
        textField = new TextField();
     
        // setBounds method is used to provide
        // position and size of component
        textField.setBounds(60, 50, 180, 25);
        Button button = new Button("click Here");
        button.setBounds(100, 120, 80, 30);
     
        // Registering component with listener anonymously
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                // Setting text to field
                textField.setText("welcome");
            }
        });
     
        // add Components
        add(textField);
        add(button);
     
        //make size viewable
        setSize(300,300);
        // set visibility
        setVisible(true);
    }
 
    public static void main(String[] args)
    {
        new AEvent3();
    }
}