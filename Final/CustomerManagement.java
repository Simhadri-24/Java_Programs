
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;
class Customer
{
    String CustomerName,State,City;
    int CustomerNumber,pincode;
    Customer(String CustomerName,int CustomerNumber,String State,String City,int pincode)
    {
        this.CustomerName=CustomerName;
        this.CustomerNumber=CustomerNumber;
        this.State=State;
        this.City=City;
        this.pincode=pincode;
    }
}
class CustomerManagement extends JFrame implements ActionListener
{
    JLabel lname,lnumber,lstate,lcity,lpincode,lsearch;
    JTextField jname,jnumber,jstate,jcity,jpincode,jsearch;
    JButton Add,Search,Display;
    JTextArea error;
    //Customer c;
    ArrayList<Customer> a=new ArrayList<Customer>();
    CustomerManagement()
    {
        setTitle("Customer Details");
        setVisible(true);
        setSize(700,700);
        setLayout(null);
        lname=new JLabel("Customer Name ");
        lname.setBounds(50,50,100,50);
        lnumber=new JLabel("Customer Number ");
        lnumber.setBounds(50,100,150,50);
        lstate=new JLabel("State ");
        lstate.setBounds(50,150,100,50);
        lcity=new JLabel("City ");
        lcity.setBounds(50,200,100,50);
        lpincode=new JLabel("Pincode ");
        lpincode.setBounds(50,250,100,50);
        add(lname);
        add(lnumber);
        add(lstate);
        add(lcity);
        add(lpincode);
        jname=new JTextField();
        jname.setBounds(200,50,100,30);
        jnumber=new JTextField();
        jnumber.setBounds(200,100,100,30);
        jstate=new JTextField();
        jstate.setBounds(200,150,100,30);
        jcity=new JTextField();
        jcity.setBounds(200,200,100,30);
        jpincode=new JTextField();
        jpincode.setBounds(200,250,100,30);
        add(jname);
        add(jnumber);
        add(jstate);
        add(jcity);
        add(jpincode);
        Add=new JButton("Add");
        Add.setBounds(80,320,80,40);
        add(Add);
        Add.addActionListener(this);
        lsearch=new JLabel("search ");
        lsearch.setBounds(400,50,60,50);
        add(lsearch);
        jsearch=new JTextField();
        jsearch.setBounds(470,50,100,30);
        add(jsearch);
        Search=new JButton("Search");
        Search.setBounds(220,320,80,40);
        add(Search);
        Search.addActionListener(this);
        error=new JTextArea();
        error.setBounds(400,120,300,100);
        add(error);
        Display=new JButton("Display");
        Display.setBounds(400,320,120,40);
        add(Display);
        Display.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void addCustomer(String CustomerName,int CustomerNumber,String State,String City,int pincode)
    {
        a.add(new Customer(CustomerName,CustomerNumber,State,City,pincode));
    }
    public Customer searchCustomer(int num)
    {
        for(Customer c:a)
        {
            if(c.CustomerNumber==num)
            {
                return c;
            }
        }
        return null;
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==Add)
        {
            String name=jname.getText();
            int number=Integer.parseInt(jnumber.getText());
            String state=jstate.getText();
            String city=jcity.getText();
            int pincode=Integer.parseInt(jpincode.getText());
            addCustomer(name,number,state,city,pincode);
        }
        else if(e.getSource()==Search)
        {
            int num=Integer.parseInt(jsearch.getText().trim());
            Customer c1=searchCustomer(num);
            if(c1!=null)
            {
                try
                {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("customer_names.txt", true));
                    writer.write(c1.CustomerName + "\n");
                    writer.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            else
            {
                error.setText("Customer Not Found !");
            }
        }
        else if(e.getSource()==Display)
        {
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader("customer_names.txt"));
                String line;
                StringBuilder customerNames = new StringBuilder();
                while ((line = reader.readLine()) != null)
                {
                    customerNames.append(line).append("\n");
                }
                error.setText(customerNames.toString());
                reader.close();
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
                error.setText("Error reading customer names from the file.");
            }
        }
    }
    public static void main(String args[])
    {
        new CustomerManagement();
    }
}