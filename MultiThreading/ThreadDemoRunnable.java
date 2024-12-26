class NewThread implements Runnable
{
    Thread t;
    NewThread()
    {
        // Create a new, second thread
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
        //t.start(); // Start the thread
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


class ThreadDemoRunnable
{
    public static void main(String args[ ] )
    {
        NewThread n1 = new NewThread(); // create a new thread
        
        //NewThread n2 = new NewThread();
        //NewThread n3 = new NewThread();
        n1.t.start();
        //n2.t.start();
        //n3.t.start();
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