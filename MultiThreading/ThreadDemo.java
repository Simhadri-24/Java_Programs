import java.util.Scanner;
class Factorial implements Runnable
{
    int n,fact=1,i=1;
    Factorial(int n)
    {
        this.n=n;
    }
    public void run()
    {
        while(n>=i)
        {
           fact=fact*i;
           i++;
        }
        System.out.println("\n Factorial value="+fact);
     }
}
class SumofSeries implements Runnable
{
    int n,sum,rem;
    SumofSeries(int n)
    {
        this.n=n;
    }
    public void run()
    {
        while(n>0)
        {
            sum=sum+n;
            n--;
        }
        System.out.println("Sum of digits ="+sum);
    }
}
class MultiplicationTable implements Runnable
{
    int n,i=1;
    MultiplicationTable(int n)
    {
        this.n=n;
    }
    public void run()
    {
        System.out.println("Multiplication Table is");
        while(i<=10)
        {
            System.out.println(n+" * "+i+" = "+n*i);
            i++;
        }
    }
}
class ThreadDemo
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Main Thread Strating");
        System.out.println("Enter  a Number ");
        int n=in.nextInt();
        Factorial f1=new Factorial(n);
        SumofSeries s1=new SumofSeries(n);
        MultiplicationTable m1=new MultiplicationTable(n);
        Thread f=new Thread(f1);
        Thread s=new Thread(s1);
        Thread m=new Thread(m1);
        f.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Main Thread Interrupted");
        }
        s.start();
        m.start();
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println("Main Thread Interrupted");
        }
        System.out.println("Main Thread Terminating");
    }
}