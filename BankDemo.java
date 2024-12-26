import java.util.Scanner;
import pkcustomer.*;//importing pkcustomer package
import pkbanking.pkinterface.*;//importing pkinterface package
import pkaccount.*;//importing pkaccount package
import pkaccount.sbpackage.*;//importing sbpackage package
class BankDemo
{
    public static void main(String args[])
    {
        int n,i;
        Scanner sc=new Scanner(System.in);//creating scanner object
        System.out.println("Enter number of customers");
        n=sc.nextInt();
        Customer c[]=new Customer[5];//creating array of objects for customer class
        for(i=0;i<n;i++)
        {
            System.out.println("Enter details of "+(i+1)+" customer");
            System.out.println("Enter customer Id :");
            int cust_id=sc.nextInt();
            System.out.println("Enter account number :");
            int Accnumber=sc.nextInt();
            System.out.println("Enter customer name :");
            sc.nextLine();
            String Name=sc.nextLine();
            System.out.println("Enter customer address ");
            String Address=sc.nextLine();
            System.out.println("Enter initial balance ");
            double balance=sc.nextDouble();
            c[i]=new Customer(cust_id,Name,Address,Accnumber,balance);
            c[i].transaction();
        }
    }
}