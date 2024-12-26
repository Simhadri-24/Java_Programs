import java.util.*;
class Two extends Runnable
{
    synchronized public void run()
    {
        System.out.println("-----------2 Table-----------");
        for(int i=1;i<=10;i++)
        {
            System.out.println(2+" * "+i+" = "+(2*i));
        }
    }
}
class Ten extends Runnable
{
    synchronized public void run()
    {
        System.out.println("-----------10 Table-----------");
        for(int i=1;i<=10;i++)
        {
            System.out.println(10+" * "+i+" = "+(10*i));
        }
    }
}
class MultiplicationTable
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Two t=new Two();
        Thread th=new Thread(t);
        th.start();
        try
        {
            th.join();
        }
        catch(InterruptedException e)
        {
            System.out.println("Interrupted");
        }
        System.out.println("-----------5 Table-----------");
        for(int i=1;i<=10;i++)
        {
            System.out.println(5+" * "+i+" = "+(5*i));
        }
        Ten t1=new Ten();
        Thread the=new Thread(t1);
        the.start();
    }
}