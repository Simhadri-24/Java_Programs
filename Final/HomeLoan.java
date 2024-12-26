import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class NotEligibleForSchemeException extends Exception
{
    NotEligibleForSchemeException(String s)
    {
        super(s);
    }
}
class Beneficiary
{
    int beneficiaryId,amount,years;
    int carpetArea;
    Beneficiary(int beneficiaryId,int amount,int years,int carpetArea)
    {
        this.beneficiaryId=beneficiaryId;
        this.amount=amount;
        this.years=years;
        this.carpetArea=carpetArea;
    }
}
class HomeLoan extends JFrame
{
    JLabel lid,lamt,ly,lc,dot;
    JTextField jid,jamt,jy,jc;
    JButton sub;
    int id,amt,y,c;
    int a,s;
    double z;
    JTextArea error;
    ArrayList<Beneficiary> arr=new ArrayList<>();
    HomeLoan()
    {
        lid=new JLabel("Identification Number");
        lid.setBounds(50,50,120,50);
        add(lid);
        jid=new JTextField();
        jid.setBounds(180,50,80,35);
        add(jid);
        lamt=new JLabel("Principal Amount");
        lamt.setBounds(50,100,120,50);
        add(lamt);
        jamt=new JTextField();
        jamt.setBounds(180,100,80,35);
        add(jamt);
        lc=new JLabel("Carpet Area");
        lc.setBounds(50,150,120,50);
        add(lc);
        jc=new JTextField();
        jc.setBounds(180,150,50,35);
        add(jc);
        ly=new JLabel("No of Years");
        ly.setBounds(50,200,120,50);
        add(ly);
        jy=new JTextField();
        jy.setBounds(180,200,50,35);
        add(jy);
        sub=new JButton("Submit");
        sub.setBounds(80,250,100,40);
        add(sub);
        error=new JTextArea();
        error.setBounds(350,100,200,200);
        add(error);
        dot=new JLabel(".");
        dot.setBounds(500,500,1,1);
        add(dot);

        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String line=" ";
                id=Integer.parseInt(jid.getText().trim());
                amt=Integer.parseInt(jamt.getText().trim());
                y=Integer.parseInt(jy.getText().trim());
                c=Integer.parseInt(jc.getText().trim());
                arr.add(new Beneficiary(id,amt,y,c));
                jid.setText(" ");
                jamt.setText(" ");
                jy.setText(" ");
                jc.setText(" ");
                z=calculate(amt,c,y);
                if(z==0)
                {
                    error.setText("Not eligible for the scheme");
                }
                else
                {
                    line+="Principal Amount :"+amt+"\nSubsidy :"+s;
                    line+="\nEmi :"+z;
                    error.setText(line);
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);
        setLayout(null);
    }
    public static void main(String args[])
    {
        new HomeLoan();
    }
    public int eligibility(int amt,int y,int c)throws NotEligibleForSchemeException
    {
        if(y>=15)
        {
            if(amt<3500000 && c<30)
            {
                amt=amt-260000;
            }
        }
        else 
        {
            throw new NotEligibleForSchemeException("Not eligible for the scheme");
        }
        return amt;
    }
    public double calculate(int amt,int c,int y)
    {
        double emi,interest;
        try
        {
        s=eligibility(amt,y,c);
        }
    catch(NotEligibleForSchemeException x)
    {
        error.setText("Not eligible for the scheme");
    }
        interest=s*y*7.4;
        emi=(s+interest)/(y*12);
        return emi;
    }
}