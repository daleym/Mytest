package com.ym.JVM.MyclassLoader;

/**
 * 类加载机制顺序:当多线程并发初始化同一个类时，那么静态块只会被其中一个初始化，且另一个会被阻塞
 * eg:如No.1中，初始化静态块时，永真循环，那么另一个线程会被阻塞，且不再初始化改静态块！
 * 	    No.2中，也证明了，当静态块被初始化完成且仅被初始化一次后，另一个线程才会继续执行下去！
 * 		实际上，初始化静态块时，是被加锁了！！！
 * @author Administrator
 *
 */
public class DeadLoopTest{
	static class DeadLoopClass
    {
		//********No.1 start****
        /*static
        {
            if(true)
            {
                System.out.println(Thread.currentThread()+"init DeadLoopClass");
                while(true)
                {
                }
            }
        }*/
      //**********No.1 end
        //********NO.2 start
		static
        {
            System.out.println(Thread.currentThread() + "init static DeadLoopClass");
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
      //********NO.2 end
    }
	
	public static void main(String[] args)
    {
        Runnable script = new Runnable(){
            public void run()
            {
                System.out.println(Thread.currentThread()+" start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread()+" run over");
            }
        };
 
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
} 