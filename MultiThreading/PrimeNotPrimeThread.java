class Prime extends Thread
{
    public void run() 
    {
        for(int i=1; i<=10; i++)
        {
            if(i==2 || i==3 || i==5 || i==7)
                System.out.println("Prime no. : " + i);
        }
    }
}
class NonPrime extends Thread
{
    public void run()
    {
        for(int i=1; i<=10; i++)
        {
            if(i==4 || i==6 || i==8 || i==9 || i==10)
                System.out.println("Non-Prime no. : " + i);
        }
    }
}
public class PrimeNotPrimeThread
{
    public static void main(String[] args)
    {
        new Prime().start();
        new NonPrime().start();
    }
}