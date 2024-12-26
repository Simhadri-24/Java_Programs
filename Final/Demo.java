import javax.swing.*;
import java.awt.event.*;
import java.util.*;
abstract class Employee
{
    String EmpName;
    int EmpId;
    abstract void calcNetSalary();
}
class PerEmployee extends Employee
{
    int bp,hra,da,pf;
    public void calcNetSalary()
    {

    }
}
class TempEmployee extends Employee
{
    int hwages,hwork;
    public void calcNetSalary()
    {

    }
}
class EmployeeManagement extends JFrame
{
    JRadioButton per,tem;
    ButtonGroup bg;
    ArrayList<PerEmployee> pa=new ArrayList<>();
    ArrayList<TempEmployee> ta=new ArrayList<>();
    EmployeeManagement()
    {
        per=new JRadioButton("Temporary");
        per.setBounds(80,50,80,40);
        add(per);
        tem=new JRadioButton("Permanent");
        tem.setBounds(200,50,80,40);
        add(tem);
        bg=new ButtonGroup();
        bg.add(per);
        bg.add(tem);
        //add(bg);
        if(tem.isSelected())
        {

        }
        setVisible(true);
        setLayout(null);
        setSize(1000,1000);

    }
    public void PermanentEmployee()
    {
        PerEmployee p=new PerEmployee();
    }
    public static void main(String args[])
    {
        new EmployeeManagement();
    }
}