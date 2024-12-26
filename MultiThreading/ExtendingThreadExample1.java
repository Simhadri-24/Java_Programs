class SampleThread extends Thread
{
	
	public void run() {
		System.out.println("Thread is under Running...");
		for(int i= 1; i<=10; i++) {
			System.out.println("Child = " + i);
		}
	}	
}

public class ExtendingThreadExample1 
{

	public static void main(String[] args) 
	{
		System.out.println("Main Thread");
		SampleThread t1 = new SampleThread();
		SampleThread t2 = new SampleThread();
		System.out.println("Thread about to start...");
		t1.start();
		t2.start();
	}
}