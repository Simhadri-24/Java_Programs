
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
class PassengerNotFoundException extends Exception
{
    PassengerNotFoundException(String str)
    {
        super(str);
    }
}
class Airlines
{
    String Passenger_Name;
    int Passenger_ID;
    int Flight_Number;
    String Source,destination;
    Airlines(String Passenger_Name,int Passenger_ID,int Flight_Number,String Source,String destination)
    {
        this.Passenger_Name=Passenger_Name;
        this.Passenger_ID=Passenger_ID;
        this.Flight_Number=Flight_Number;
        this.Source=Source;
        this.destination=destination;
    }
}
class AirlinesManagement extends JFrame
{
    JLabel lname,lid,lnumber,lsource,ldest,lsearch;
    JTextField jname,jid,jnumber,jsource,jdest,jsearch;
    JButton Add,Search,Display;
    JTextArea error;
    ArrayList<Airlines> a=new ArrayList<Airlines>();
    String name,source,destination;
    int id,number;
    AirlinesManagement()
    {
        setSize(1000,1000);
        setVisible(true);
        setLayout(null);
        setTitle("Airlines");
        lname=new JLabel("Passenger Name");
        lname.setBounds(50,50,100,50);
        lid=new JLabel("Passenger Id");
        lid.setBounds(50,100,100,50);
        lnumber=new JLabel("Flight Number");
        lnumber.setBounds(50,150,100,50);
        lsource=new JLabel("Source");
        lsource.setBounds(50,200,100,50);
        ldest=new JLabel("Destination");
        ldest.setBounds(50,250,100,50);
        add(lname);
        add(lid);
        add(lnumber);
        add(lsource);
        add(ldest);
        jname=new JTextField();
        jname.setBounds(150,50,100,30);
        jid=new JTextField();
        jid.setBounds(150,100,100,30);
        jnumber=new JTextField();
        jnumber.setBounds(150,150,100,30);
        jsource=new JTextField();
        jsource.setBounds(150,200,100,30);
        jdest=new JTextField();
        jdest.setBounds(150,250,100,30);
        add(jname);
        add(jid);
        add(jnumber);
        add(jsource);
        add(jdest);
        Add=new JButton("Add");
        Add.setBounds(80,320,80,40);
        add(Add);
        Add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                name = jname.getText();
                id = Integer.parseInt(jid.getText().trim());
                number = Integer.parseInt(jnumber.getText().trim());
                source = jsource.getText();
                destination = jdest.getText();
                addPassenger(name, id, number, source, destination);
                jname.setText(" ");
                jid.setText(" ");
                jnumber.setText(" ");
                jsource.setText(" ");
                jdest.setText(" ");
            }
        });
        lsearch=new JLabel("Search ");
        lsearch.setBounds(400,50,60,50);
        jsearch=new JTextField();
        jsearch.setBounds(470,50,100,30);
        add(jsearch);
        Search=new JButton("Search");
        Search.setBounds(220,320,80,40);
        add(lsearch);
        add(Search);
        Search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String line = " ";
                    int iid = Integer.parseInt(jsearch.getText().trim());
                    Airlines a2 = SearchPassenger(iid);
                    line += "Name :" + a2.Passenger_Name + "\nId :" + a2.Passenger_ID;
                    line += "\nFlight Number :" + a2.Flight_Number + "\nSource :" + a2.Source;
                    line += "\nDestination :" + a2.destination + "\n\n";
                    error.setText(line);
                }
                catch (PassengerNotFoundException ex)
                {
                    error.setText("Passenger Not Found!");
                }
            }
        });
        error=new JTextArea();
        error.setBounds(300,120,300,180);
        error.setEditable(false);
        add(error);
        Display = new JButton("Display");
        Display.setBounds(400, 320, 120, 40);
        add(Display);
        Display.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                DisplayPassengers();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void addPassenger(String name,int id,int number,String source,String destination)
    {
            a.add(new Airlines(name,id,number,source,destination));
    }
    public Airlines SearchPassenger(int id)throws PassengerNotFoundException
    {
        for(Airlines a1:a)
        {
            if(a1.Passenger_ID==id)
            {
                return a1;
            }
        }
        throw new PassengerNotFoundException("Passenger not found");
    }
    public void DisplayPassengers()
    {
        error.setText(" ");
        String line=" ";
        Collections.sort(a,(a5,a6)->a5.Passenger_Name.compareTo(a6.Passenger_Name));
        Iterator i=a.iterator();
        while(i.hasNext())
        {
            Airlines a3=(Airlines)i.next();
            line+="Name :"+a3.Passenger_Name+"\nId :"+a3.Passenger_ID;
            line+="\nFlight Number :"+a3.Flight_Number+"\nSouce :"+a3.Source;
            line+="\nDestination :"+a3.destination;
            error.setText(line);
        }
    }
    public static void main(String args[])
    {
        new AirlinesManagement();
    }

}