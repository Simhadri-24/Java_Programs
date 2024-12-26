import java.awt.*;
import java.awt.event.*;

public class AwtLabelTextFieldButtonExample
{
    public static void main(String[] args)
    {
        // Create a Frame (the main window)
        Frame frame = new Frame("AWT Label, TextField, and Button Example");

        // Create Labels
        Label nameLabel = new Label("Name:");
        Label ageLabel = new Label("Age:");


		TextField nameTextField = new TextField(20); // 20 is the initial width of the text field
        TextField ageTextField = new TextField(5); // 5 is the initial width of the text field

        // Create a Button
        Button submitButton = new Button("Submit");

        // Set the layout for the frame
        frame.setLayout(new FlowLayout());

        // Add components to the frame
        frame.add(nameLabel);
        frame.add(nameTextField);
        frame.add(ageLabel);
        frame.add(ageTextField);
        frame.add(submitButton);
		
		frame.setVisible(true);
		frame.setSize(300, 150); // Width, Height
        
    }
}