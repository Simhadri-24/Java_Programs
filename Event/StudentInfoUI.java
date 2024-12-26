import java.awt.*;
import java.awt.event.*;

public class StudentInfoUI {
    private Frame frame;
    private Label nameLabel, ageLabel;
    private TextField nameTextField, ageTextField;
    private Button displayButton;
    private TextArea displayArea;

    public StudentInfoUI() {
        frame = new Frame("Student Information");
        
        nameLabel = new Label("Name:");
        nameLabel.setBounds(50, 50, 50, 20);
        
        ageLabel = new Label("Age:");
        ageLabel.setBounds(50, 80, 50, 20);
        
        nameTextField = new TextField(20);
        nameTextField.setBounds(120, 50, 150, 20);
        
        ageTextField = new TextField(20);
        ageTextField.setBounds(120, 80, 150, 20);
        
        displayButton = new Button("Display");
        displayButton.setBounds(50, 120, 100, 30);
        
        displayArea = new TextArea();
        displayArea.setBounds(50, 170, 300, 200);

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String age = ageTextField.getText();
				//append - Component class
                displayArea.append("Name: " + name + ", Age: " + age + "\n");
                nameTextField.setText("");
                ageTextField.setText("");
            }
        });

        frame.setLayout(null);
        frame.add(nameLabel);
        frame.add(ageLabel);
        frame.add(nameTextField);
        frame.add(ageTextField);
        frame.add(displayButton);
        frame.add(displayArea);

        frame.setSize(400, 400);
        frame.setVisible(true);

        // Close the frame when the user closes the window
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) 
	{
        new StudentInfoUI();
    }
}