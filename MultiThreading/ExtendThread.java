// Create a second thread by extending Thread
class NewThread extends Thread 
{
    NewThread() 
    {
        // Create a new, second thread
        super("Demo Thread");
        System.out.println("Child thread: " + this);
        //start(); // Start the thread
    }
    // This is the entry point for the second thread.
    public void run()
    {
        try 
        {
            for(int i = 5; i > 0; i--) 
            {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) 
        {   
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}


class ExtendThread 
{
    public static void main(String args[]) 
    {
        NewThread nt1 = new NewThread();
        NewThread nt2 = new NewThread();
        NewThread nt3 = new NewThread();// create a new thread
        nt1.start();
        try
        {
            nt1.join();
        }
        catch(InterruptedException E)	
		{
			System.out.println("1st Thread Interrupted");
		}
        nt2.start();
        try
        {
            nt1.join();
        }
        catch(InterruptedException E)	
		{
			System.out.println("2nd Thread Interrupted");
		}
        nt3.start();
        try
        {
            nt1.join();
        }
        catch(InterruptedException E)	
		{
			System.out.println("3rd thread Interrupted");
		}
        try 
        {
            for(int i = 5; i > 0; i--) 
            {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) 
        {
            System.out.println("Main thread interrupted.");
        }
    System.out.println("Main thread exiting.");
    }
}