import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class multi extends Thread
{
    Thread t;
    JLabel j;
    multi(JLabel j)
    {
        this.j=j;
    }
    public void run()
    {
        while(true)
        {
            try
            {
                j.setBounds(50,25,200,50);
                Thread.sleep(500);
                j.setBounds(100,25,200,50);
                Thread.sleep(500);
                j.setBounds(150,25,200,50);
                Thread.sleep(500);
                j.setBounds(200,25,200,50);
                Thread.sleep(500);
                j.setBounds(250,25,200,50);
                Thread.sleep(500);
                j.setBounds(300,25,200,50);
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                return;
            }
        }
    }
}
class Passenger extends JFrame
{
    JLabel lname,ldob,ld,lm,lage,lgen,dot,berth;
    static JLabel title;
    JTextField jname,jdob,d,m,y,jage;
    int a;
    String b[]={"Lower","Upper","Middle"};
    JComboBox<String> c;
    JRadioButton male,fem;
    ButtonGroup gen;
    JTextArea sub;
    JButton bsub;
    Passenger()
    {
        setTitle("Train Ticket");
        title=new JLabel("BOOKING TRAIN TICKETS");
        add(title);
        lname=new JLabel("Name");
        lname.setBounds(50,70,50,50);
        add(lname);
        jname=new JTextField();
        jname.setBounds(120,70,50,30);
        add(jname);
        ldob=new JLabel("Dob");
        ldob.setBounds(50,100,50,50);
        add(ldob);
        d=new JTextField();
        d.setBounds(120,100,20,20);
        add(d);
        ld=new JLabel("/");
        ld.setBounds(140,100,10,50);
        add(ld);
        m=new JTextField();
        m.setBounds(150,100,20,20);
        add(m);
        lm=new JLabel("/");
        lm.setBounds(170,100,10,50);
        add(lm);
        y=new JTextField();
        y.setBounds(180,100,40,20);
        add(y);
        lage=new JLabel("Age");
        lage.setBounds(50,150,50,50);
        add(lage);
        jage=new JTextField();
        jage.setBounds(120,150,30,30);
        add(jage);
        jage.setEditable(false);
        lgen=new JLabel("Gender");
        lgen.setBounds(50,200,50,50);
        add(lgen);
        male=new JRadioButton("Male");
        male.setBounds(120,200,60,50);
        add(male);
        fem=new JRadioButton("Female");
        fem.setBounds(200,200,70,50);
        add(fem);
        gen=new ButtonGroup();
        gen.add(male);
        gen.add(fem);
        berth=new JLabel("Berth");
        berth.setBounds(50,250,80,50);
        add(berth);
        c=new JComboBox<String>(b);
        c.setBounds(170,250,80,40);
        add(c);
        bsub=new JButton("Submit");
        bsub.setBounds(100,320,100,30);
        add(bsub);
        sub=new JTextArea();
        sub.setBounds(400,150,250,250);
        add(sub);
        dot=new JLabel(".");
        dot.setBounds(500,500,1,1);
        add(dot);
        bsub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String line=" ";
                if(y.getText()!=null)
                {
                    a=Integer.parseInt(y.getText().trim());
                    jage.setText(String.valueOf(2023-a));
                }
                if(Integer.parseInt(jage.getText())>60)
                {
                    line+="You are a Senior citizen \n";
                }
                line+="Name :"+jname.getText();
                line+="\nDate of Birth :"+d.getText()+"/"+m.getText()+"/"+y.getText();
                line+="\nAge :"+jage.getText();
                line+="\nGender :"+(male.isSelected()?"Male":"Female");
                line+="\nBerth :"+c.getSelectedItem();
                sub.setText(line);
            }
        });
        setVisible(true);
        setLayout(null);
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        new Passenger();
        Thread t=new multi(title);
        t.start();
    }
}