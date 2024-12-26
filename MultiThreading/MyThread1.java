public class MyThread1 extends Thread
{ 
	MyThread1(String str)
    {
	   	super(str);
	}
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args)
    {
        MyThread1 t1=new MyThread1("first thread");
        MyThread1 t2=new MyThread1("second thread");
        t1.start();
		//t2.start();
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
        try
        {
            t1.join();      //Waiting for t1 to finish
        }
        catch(InterruptedException ie)
        {
        	System.out.println(ie);
        }
		System.out.println(t1.isAlive());
        t2.start();            
        try
        {
            t2.join();      //Waiting for t2 to finish
        }
        catch(InterruptedException ie)
        {
        	System.out.println(ie);
        }
    }
}
