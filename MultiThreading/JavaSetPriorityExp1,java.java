public class JavaSetPriorityExp1 extends Thread  
{    
    public void run()  
    {    
        System.out.println("Priority of thread is: "+Thread.currentThread().getPriority()); 
		System.out.println("child thread");			
    }    
    public static void main(String args[])  
    {    
        // creating one thread   
        JavaSetPriorityExp1 t1=new JavaSetPriorityExp1();    
        // print the maximum priority of this thread  
        t1.setPriority(Thread.MAX_PRIORITY);
		//t1.setPriority(12);		
        // call the run() method  
        t1.start(); 
		System.out.println("Main thread");		
    }    
}  
