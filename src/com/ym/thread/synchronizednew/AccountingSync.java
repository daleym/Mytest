package com.ym.thread.synchronizednew;

/**
 * 互斥锁:synchronized
 * 可见性、共享资源访问排他性
 * eg：No.1 当共享资源i被并发访问时，受到synchronized获取实例对象的锁保障！
 *     No.2 是非线程安全的,因为synchronized获取的是不同实例的锁！！！
 * @author Administrator
 *
 */
public class AccountingSync implements Runnable {

	//共享资源(临界资源)
    static int i=0;

    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
    	//**********No.1 start
    	/*AccountingSync instance=new AccountingSync();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);*/
        //***********No.2 end
    	
    	//*************No.2 start
    	//new新实例
        Thread t1=new Thread(new AccountingSync());
        //new新实例
        Thread t2=new Thread(new AccountingSync());
        t1.start();
        t2.start();
        //join含义:当前线程A等待thread线程终止之后才能从thread.join()返回
        t1.join();
        t2.join();
        System.out.println(i);
    	//*************No.2 end
    }
	
}
