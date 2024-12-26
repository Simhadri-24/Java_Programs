import java.uti;.*;
import javax.swing.*;
class PassengerDetails
{
    String name,gender,berth;
    int d,m,y;
    PassengerDetails(String name,int d,int m,int y,String gender,String berth)
    {
        this.name=name;
        this.d=d;
        this.m=m;
        this.y=y;
        this.gender=gender;
        this.berth=berth;
    }
}
class Passenger extends JFrame
{
    JLabel lname,ldob,ld,lm;
    JTextField jname,jdob;
    Passenger()
    {
        lname=new JLabel("Name");
        lname.setBounds(50,50,50,50);
        add(lname);
        jname=new JTextField();
        jname.setBounds(120,50,50,30);
        add(jname);
        ldob=new JLabel("Dob");
        ldob.setBounds(50,100,50,50);
        add(ldob);
        d=new JTextField();
        d.setBounds(120,100,20,30);
        add(d);
        ld=new JLabel("/");
        ad.setBounds(140,100,10,30);
        add(ad);
        m=new JTextField();
        m.setBounds(150,100,20,30);
        add(m);
        lm=new JLabel("/");
        lm.setBounds(170,100,10,30);
        add(lm);
        y=new JTextField();
        y.setBounds(180,100,20,30);
        add(y);
        lage=new JLabel("Age");
        lage.setBounds(50,150,50,50);
        add(lage);

        jage=new JTextField();
        jage.setBounds(120,150,30,30);
        add(jage);


    }
    public static void main(String args[])
    {
        new Passenger();
    }
}