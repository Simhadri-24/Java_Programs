import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class QuantityNotEnteredException extends Exception
{
    QuantityNotEnteredException(String s)
    {
        super(s);
    }
}
class SelectItemFirst extends Exception
{
    SelectItemFirst(String str)
    {
        super(str);
    }
}
class CustomerException extends Exception
{
    CustomerException(String stri)
    {
        super(stri);
    }
}
class EnterCustomerIdException extends Exception
{
    EnterCustomerIdException(String so)
    {
        super(so);
    }
}
class Compliments
{
    int coke200=0;
    int sprite500=0;
}
class Pizza extends Compliments
{
    int type[]=new int[10];
}
class CustomerDetails 
{
    int amount;
    String id,name,address,sel;
    CustomerDetails(String id,int amount,String name,String address,String sel)
    {
        this.id=id;
        this.amount=amount;
        this.name=name;
        this.address=address;
        this.sel=sel;
    }
}
class Customer extends JFrame
{
    int id,amount;
    String name,address;
    Pizza p=new Pizza();
    String a[]={"Paneer-50","chicken-100","Corn-80","Butter-110"};
    JList<String> l;
    JLabel j,lid,lname,ladd,dot;
    JTextField w,x,y,z,jid,jname,jadd;
    JButton order,history;
    JTextArea error,error1;
    JScrollPane js;
    ArrayList<CustomerDetails> arr=new ArrayList<>();
    Customer()
    {
        j=new JLabel("Pizza");
        j.setBounds(50,50,60,50);
        add(j);
        l=new JList<>(a);
        l.setBounds(100,50,90,80);
        add(l);
        l.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
        w=new JTextField();
        w.setBounds(190,50,25,20);
        add(w);
        x=new JTextField();
        x.setBounds(190,70,25,20);
        add(x);
        y=new JTextField();
        y.setBounds(190,90,25,20);
        add(y);
        z=new JTextField();
        z.setBounds(190,110,25,20);
        add(z);
        lid=new JLabel("Customer Id");
        lid.setBounds(50,150,120,50);
        add(lid);
        jid=new JTextField();
        jid.setBounds(180,150,80,30);
        add(jid);
        lname=new JLabel("Name");
        lname.setBounds(50,200,60,50);
        add(lname);
        jname=new JTextField();
        jname.setBounds(180,200,60,30);
        add(jname);
        ladd=new JLabel("Address");
        ladd.setBounds(50,250,120,50);
        add(ladd);
        jadd=new JTextField();
        jadd.setBounds(180,250,150,30);
        add(jadd);
        order=new JButton("Place-an-order");
        order.setBounds(80,300,150,40);
        add(order);
        error=new JTextArea();
        error.setBounds(400,50,250,150);
        add(error);

        order.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String line=" ";
                String id=jid.getText();
                String name=jname.getText();
                String add=jadd.getText();
                String sel=l.getSelectedValue();
                try
                {
                    if(name.length()==0||add.length()==0||id.length()==0)
                    {
                        throw new CustomerException("Enter customer Deteils!");
                    }
                    
                }
                catch(CustomerException e3)
                {
                    error.setText("Enter customer Details");
                    return;
                }
                try
                {
                if(sel==null||sel.isEmpty())
                {
                    throw new SelectItemFirst("Select an item first ");
                }
                }
                catch(SelectItemFirst e1)
                {
                    error.setText("Select an item first ");
                    return;
                }
                int amt=0;
                try{
                if(sel.equals("Paneer-50"))
                {
                    if(!w.getText().isEmpty())
                    {
                    int n=Integer.parseInt(w.getText().trim());
                    amt=(50*n);
                    }
                    else
                    {
                        throw new QuantityNotEnteredException("Enter quantity for selected items");
                    }
                }
                else if(sel.equals("chicken-100"))
                {
                    if(!x.getText().isEmpty())
                    {
                    int n=Integer.parseInt(x.getText().trim());
                    amt=(100*n);
                    }
                    else
                    {
                        throw new QuantityNotEnteredException("Enter quantity for selected items");
                    }
                }
                else if(sel.equals("Corn-80"))
                {
                    if(!y.getText().isEmpty())
                    {
                    int n=Integer.parseInt(y.getText().trim());
                    amt=(80*n);
                    }
                    else
                    {
                        throw new QuantityNotEnteredException("Enter quantity for selected items");
                    }
                }
                else if(sel.equals("Butter-110"))
                {
                    if(!z.getText().isEmpty())
                    {
                    int n=Integer.parseInt(z.getText().trim());
                    amt=(110*n);
                    }
                    else
                    {
                        throw new QuantityNotEnteredException("Enter quantity for selected items");
                    }
                }}
                catch(QuantityNotEnteredException e2)
                {
                    error.setText("Enter quantity for selected items");
                    return;
                }
                p.type[0]=amt;
                p.coke200=0;
                p.sprite500=0;
                if(amt>500 && amt<=1000)
                {
                    p.coke200++;
                }
                else if(amt>1000 && amt<=1500)
                {
                    p.coke200+=2;
                }
                else if(amt>1500)
                {
                    p.coke200++;
                    p.sprite500++;
                }
                line+="\nCustomer Id :"+jid.getText();
                line+="\nName :"+jname.getText();
                line+="\nAddress :"+jadd.getText();
                line+="\nPurchased Items :"+l.getSelectedValue();
                line+="\nPurchased Amount :"+amt;
                error.setText(line);
                boolean ce=false;
                for(CustomerDetails c:arr)
                {
                    
                    if(c.id.equals(id))
                    {
                        ce=true;
                        c.amount+=amt;
                        break;
                    }
                }
                if(!ce)
                {
                   arr.add(new CustomerDetails(id,amt,name,add,sel)); 
                }
                jid.setText(" ");
                jname.setText(" ");
                jadd.setText(" ");
                w.setText(" ");
                x.setText(" ");
                y.setText(" ");
                z.setText(" ");
            }
        });
        error1=new JTextArea();
        js=new JScrollPane(error1);
        js.setBounds(400,250,250,70);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(js);
        history=new JButton("History");
        history.setBounds(250,300,80,40);
        add(history);
        history.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e5)
            {
                String id=jid.getText();
                try
                {
                    if(id.length()==0)
                    {
                        throw new EnterCustomerIdException("Enter Customer Id");
                    }
                    else
                    {
                        String line=" ";
                        for(CustomerDetails c1:arr)
                        {
                            line+="\nCustomer id :"+c1.id+"\nName:"+c1.name;
                            line+="\naddress:"+c1.address+"\npurchased amount:"+c1.amount;
                            error1.setText(line);
                        }
                    }
                }
                catch(EnterCustomerIdException e6)
                {
                    error1.setText("Enter Customer Id");
                }
            }
        });
        dot=new JLabel(".");
        dot.setBounds(500,500,1,1);
        add(dot);
        setVisible(true);
        setLayout(null);
        setSize(1000,1000);
        
    }
    public static void main(String args[])
    {
        new Customer();
    }
}