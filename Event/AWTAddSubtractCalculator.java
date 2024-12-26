import java.awt.*;
import java.awt.event.*;

public class AWTAddSubtractCalculator extends Frame 
{
    private TextField num1Field, num2Field, resultField;
    private Button addBtn, subtractBtn;

    public AWTAddSubtractCalculator() 
	{
        setTitle("Addition and Subtraction Calculator");
        setSize(300, 200);
        setLayout(new FlowLayout());
		setVisible(true);

        Label num1Label = new Label("Number 1: ");
        num1Field = new TextField(10);

        Label num2Label = new Label("Number 2: ");
        num2Field = new TextField(10);

        addBtn = new Button("Add");
        subtractBtn = new Button("Subtract");

        resultField = new TextField(15);
        resultField.setEditable(false);

        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(addBtn);
        add(subtractBtn);
        add(resultField);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performAddition();
            }
        });

        subtractBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSubtraction();
            }
        });

        addWindowListener(new WindowAdapter() 
		{
            public void windowClosing(WindowEvent we) 
			{
                dispose(); // Close the window
            }
        });
    }

		void performAddition() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = num1 + num2;
            resultField.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input!");
        }
    }

    private void performSubtraction() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = num1 - num2;
            resultField.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        AWTAddSubtractCalculator calculator = new AWTAddSubtractCalculator();
        
    }
}