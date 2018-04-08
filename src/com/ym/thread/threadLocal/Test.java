package com.ym.thread.threadLocal;

public class Test {

	static ThreadLocal<Long> longLocal = new ThreadLocal<Long>();  
    static ThreadLocal<String> stringLocal = new ThreadLocal<String>();  
  
    public void set() {  
        longLocal.set(Thread.currentThread().getId());  
        stringLocal.set(Thread.currentThread().getName());  
    }  
  
    public long getLong() {  
        return longLocal.get();  
    }  
  
    public String getString() {  
        return stringLocal.get();  
    }  
  
    public static void main(String[] args) throws InterruptedException {  
        final Test test = new Test();  
        System.out.println(longLocal.get());//不set的话，会取出null
        test.set();  
        System.out.println(test.getLong());  
        System.out.println(test.getString());  
  
        Thread thread1 = new Thread() {  
            public void run() {  
                test.set();  
                System.out.println(test.getLong());  
                System.out.println(test.getString());  
            };  
        };  
        thread1.start();  
        thread1.join();  
  
        System.out.println(test.getLong());  
        System.out.println(test.getString());  
    } 
	
}
