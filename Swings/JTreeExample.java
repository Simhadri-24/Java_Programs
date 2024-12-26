import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*; 
public class JTreeExample
{  
JFrame f;
JTree tree;
JLabel jlab;  
JTreeExample()
{  
    f=new JFrame();
    f.setLayout(new FlowLayout()) ;  
    DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");
// Create subtree of "A".
DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
top.add(a);
DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("A1");
a.add(a1);
DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
a.add(a2);
// Create subtree of "B"
DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
top.add(b);
DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("B1");
b.add(b1);
DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
b.add(b2);
DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("B3");
b.add(b3);
// Create the tree.
tree = new JTree(top);
// Add the tree to a scroll pane.
JScrollPane jsp = new JScrollPane(tree);
// Add the scroll pane to the content pane.
f.add(jsp);
// Add the label to the content pane.
jlab = new JLabel();
f.add(jlab, BorderLayout.NORTH);
    f.setSize(200,200);  
    f.setVisible(true);



// Handle tree selection events.
tree.addTreeSelectionListener(new TreeSelectionListener() {
public void valueChanged(TreeSelectionEvent tse) {
jlab.setText("Selection is " + tse.getPath());
}
});
}



public static void main(String[] args) {  
    new JTreeExample();  
}

}