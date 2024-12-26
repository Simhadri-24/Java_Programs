import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class RepresentativeException extends Exception
{
    RepresentativeException(String s)
    {
        super(s);
    }
}
class DateException extends Exception
    {
        DateException(String str)
        {
            super(str);
        }
    }
class Appoinment
{
    String repName,meet,date;
    Appoinment(String repName,String meet,String date)
    {
        this.repName=repName;
        this.meet=meet;
        this.date=date;
    }
}
class OrganisedAppointment extends JFrame
{
    JLabel lname,lmeet,ldate,lsearch,dsea,dot;
    JTextField tname,tmeet,tdate,tsearch,tsea;
    JButton rsearch,dsearch,sub,Add;
    JTextArea error;
    String line=" ";
    String line1=" ";
    ArrayList<Appoinment> a=new ArrayList<>();
    OrganisedAppointment()
    {
        lname=new JLabel("Rep Name");
        lname.setBounds(50,50,80,50);
        add(lname);
        tname=new JTextField();
        tname.setBounds(130,50,80,30);
        add(tname);
        lmeet=new JLabel("Whom To Meet");
        lmeet.setBounds(50,100,150,50);
        add(lmeet);
        tmeet=new JTextField();
        tmeet.setBounds(150,100,80,30);
        add(tmeet);
        ldate=new JLabel("Appointment Date");
        ldate.setBounds(50,150,120,50);
        add(ldate);
        tdate=new JTextField();
        tdate.setBounds(200,150,80,30);
        add(tdate);
        lsearch=new JLabel("Search Repre");
        lsearch.setBounds(250,50,100,50);
        add(lsearch);
        tsearch=new JTextField();
        tsearch.setBounds(350,50,80,35);
        add(tsearch);
        error=new JTextArea();
        error.setBounds(400,150,200,200);
        add(error);
        rsearch=new JButton("Search rep");
        rsearch.setBounds(80,200,100,40);
        add(rsearch);
        rsearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String sname=tsearch.getText();
                    searchRep(sname);
                }
                catch(RepresentativeException e1)
                {
                    error.setText("The Given representative name is not in the list");
                }
            }
        });
        dsea=new JLabel("Search Date");
        dsea.setBounds(250,100,100,50);
        add(dsea);
        tsea=new JTextField();
        tsea.setBounds(350,100,90,35);
        add(tsea);
        dsearch=new JButton("Search Date");
        dsearch.setBounds(190,200,100,40);
        add(dsearch);
        dsearch.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String sdate=tsea.getText().trim();
                try
                {
                searchDate(sdate);
                }
                catch(DateException d)
                {
                    error.setText("The given date is not in the list");
                }
            }
        });
        Add=new JButton("Add");
        Add.setBounds(300,200,80,35);
        add(Add);
        Add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String name=tname.getText();
                String meet=tmeet.getText();
                String date=tdate.getText();
                a.add(new Appoinment(name,meet,date));
                tname.setText(" ");
                tmeet.setText(" ");
                tdate.setText(" ");
            }
        });
        sub=new JButton("Submit");
        sub.setBounds(100,250,100,40);
        add(sub);
        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String liner=" ";
                error.setText(liner);
                Iterator i=a.iterator();
                while(i.hasNext())
                {
                    Appoinment o=(Appoinment)i.next();
                    liner+="\nRep Name :"+o.repName+"\nDate :"+o.date;
                    liner+="\n Whomto meet :"+o.meet;
                    error.setText(liner);
                }
            }
        });
        dot=new JLabel(".");
        dot.setBounds(500,500,1,1);
        add(dot);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1000,1000);
    }
    public int searchRep(String sname)throws RepresentativeException
    {
        for(Appoinment s:a)
        {
            if(s.repName.equals(sname))
            {
                line1+="Date :"+s.date;
                line1+="\n Whom To Meet :"+s.meet;
                error.setText(line1);
                return 1;
            }
        }
        throw new RepresentativeException("The Given representative name is not in the list");
    }
    public void searchDate(String sdate)throws DateException
    {
        for(Appoinment s1:a)
        {
            System.out.println(k);
            System.out.println(s1.date);
            if((s1.date.trim()).equals(sdate))
            {
                line+="\nRep Name :"+s1.repName;
                line+="\nWhom To Meet :"+s1.meet;
            }
        }
        error.setText(line);
        if(line.isEmpty())
        {
        throw new DateException("The given date is not in the list");
        }
    }
    public static void main(String args[])
    {
        new OrganisedAppointment();
    }
}