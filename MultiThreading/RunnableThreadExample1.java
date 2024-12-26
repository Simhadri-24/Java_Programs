class  ThreadExample1 implements Runnable
{  
    public void run()
    {  
        System.out.println("child thread is running...");  
    } 
}
class  RunnableThreadExample1
{ 
    public static void main(String args[])
    {  
        System.out.println("Main thread is running...");
        ThreadExample1 m1=new ThreadExample1();  
        Thread t1 =new Thread(m1);   // Using the constructor Thread(Runnable r)  
        t1.start(); 
    } 
}  