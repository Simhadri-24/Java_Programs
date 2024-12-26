class  ThreadExample3 implements Runnable
{  
    public void run()
    {  
        System.out.println("Child thread is running...");  
    } 
}
 
class  RunnableThreadExample3
{ 
    public static void main(String args[])
    {  
        System.out.println("Main thread is running...");
        ThreadExample3 m1=new ThreadExample3();  
        Thread t1 =new Thread(m1,"My Thread");   // Using the constructor Thread(Runnable r)  
        t1.start(); 

        String str = t1.getName();  
        System.out.println(str);  
    }  
}  
