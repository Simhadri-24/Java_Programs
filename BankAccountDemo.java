import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
class InvalidAmountException extends Exception
{
    InvalidAmountException(String s)
    {
        super(s);
    }
}
class BankAccount
{
    long customerid,accounted;
    String customerName;
    double balance;
    Scanner in=new Scanner(System.in);
    BankAccount(int i)
    {
        System.out.println("Enter customer "+(i+1)+" Details");
        System.out.println("Enter your Customer id");
        customerid=in.nextLong();
        System.out.println("Enter your Customer Name");
        in.nextLine();
        customerName=in.nextLine();
        System.out.println("Enter your current balance");
        balance=in.nextDouble();
    }
    double DepositAmount(double amount)throws InvalidAmountException
    {
        if(amount<0)
        {
            throw new InvalidAmountException("Invalid Amount,Amount shouldn't be Negative");
        }
        else
        {
            balance=balance+amount;
            System.out.println("Amount deposited Successfully ");
            return balance;
        }
    }
    double withdrawAmount(double amount)throws InvalidAmountException
    {
        if(amount<0)
        {
            throw new InvalidAmountException("Invalid Amount,amount shouldn't be Negative");
        }
        if(balance>=amount)
        {
            balance=balance-amount;
            System.out.println("Amount Withdrawn Successfully");
            return balance;
        }
        else
        {
            return -1;
        }
    }
    double AddInterest(double percent)
    {
	  balance=balance+(balance*percent*12*0.01);
	  return balance;
    }
    void display(int i)
    {
        System.out.println("Customer "+(i+1)+" details are ");
        System.out.println("Customer Id ="+customerid);
        System.out.println("Customer Name ="+customerName);
    }
}
class BankAccountDemo
{
    public static void main(String args[])
    {
        double res,amount;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter no of Customers");
        int n=in.nextInt();
        BankAccount b[]=new BankAccount[n];
        for(int i=0;i<n;i++)
        {
            b[i]=new BankAccount(i);
            System.out.println("1.Deposit \n2.Withdraw \n3.AddInterest");
            System.out.println("Enter your option");
            int op=in.nextInt();
            try
            {
                switch(op)
                {
                    case 1:
                        System.out.println("Enter Amount to deposit");
                        try
                        {
                            amount=in.nextDouble();
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input,Please enter a valid numerical value.");
                            continue;
                        }
                        res=b[i].DepositAmount(amount);
                        b[i].display(i);
                        System.out.println("Your Balance ="+res);
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw");
                        try
                        {
                            amount=in.nextDouble();
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input,Please enter a valid numerical value.");
                            continue;
                        }
                        res=b[i].withdrawAmount(amount);
                        b[i].display(i);
                        if(res>0)
                        {
                            System.out.println("Your Balance ="+res);
                        }
                        else
                        {
                            System.out.println("Insufficient Balance");
                        }
                        break;
                    case 3:
                        System.out.println("Enter interest percent");
                        double percent=in.nextDouble();
                        res=b[i].AddInterest(percent);
                        b[i].display(i);
                        System.out.println("After adding interest Your Account balance =" + res);
                        break;
                }
            } 
            catch(InvalidAmountException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}