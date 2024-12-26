import java.awt.*;
import java.awt.event.*;

public class ListExample1 {
    private Frame frame;
    private List list;
    private TextArea textArea;

    public ListExample1() {
        frame = new Frame("List Example");
        list = new List();
        textArea = new TextArea();

        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");

        list.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                textArea.setText(list.getSelectedItem());
            }
        });

        frame.add(list, BorderLayout.WEST);
        frame.add(textArea, BorderLayout.CENTER);

        frame.setSize(300, 200);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ListExample1();
    }
}