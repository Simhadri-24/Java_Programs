class  ThreadExample2 implements Runnable
{  
	public void run()
	{  
		System.out.println("Child thread is running...");
		try
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println("Child Thread"+i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException E)
		{
			System.out.println("Child Interrupted");	
		}	
	}
}
class  RunnableThreadExample2
{ 
	public static void main(String args[])
	{  
		System.out.println("Main thread is running...");
		ThreadExample2 m1=new ThreadExample2();  
		Thread t1 =new Thread(m1);   // Using the constructor Thread(Runnable r)  
		t1.start();
        try
        {
            t1.join();
        }
        catch(InterruptedException E)	
		{
			System.out.println("Main Interrupted");
		} 
		System.out.println("Came to Main Thread"); 
		try
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println("Main Thread"+i);
				Thread.sleep(10000);
			}
		}
		catch(InterruptedException E)	
		{
			System.out.println("Main Interrupted");
		} 
 	}  
}  