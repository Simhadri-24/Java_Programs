public class MyThread extends Thread
{
	public void run()
	{
		System.out.println("r1");
		try
		{
        	Thread.sleep(5000);
    	}
    	catch(InterruptedException ie) 
    	{ 
    		// do something
    	}
       	System.out.println("r2");
  	}
	public static void main(String[] args)
	{
		MyThread t1=new MyThread();
		MyThread t2=new MyThread();
		t1.start();
		//t2.start();
		//System.out.println(t1.isAlive());
		//System.out.println(t2.isAlive());
		
		try
		{
  			t1.join();	//Waiting for t1 to finish
		}
		catch(InterruptedException ie){}

		t2.start();
		
		
		
	}
}