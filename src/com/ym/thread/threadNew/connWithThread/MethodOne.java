package com.ym.thread.threadNew.connWithThread;

/**
 * 线程通信之 wait、notify
 * @author Administrator
 *
 */
public class MethodOne {

	private final ThreadToGo threadToGo = new ThreadToGo();  
    public Runnable newThreadOne() {  
        final String[] inputArr = Helper.buildNoArr(52);  
        return new Runnable() {  
            private String[] arr = inputArr;  
            public void run() {  
                try {  
                    for (int i = 0; i < arr.length; i=i+2) {  
                        synchronized (threadToGo) {  
                            if (threadToGo.value == 2)  
                                threadToGo.wait();  
                            Helper.print(arr[i], arr[i + 1]);  
                            threadToGo.value = 2;  
                            threadToGo.notify();  
                        }  
                    }  
                } catch (InterruptedException e) {  
                    System.out.println("Oops...");  
                }  
            }  
        };  
    }  
    public Runnable newThreadTwo() {  
        final String[] inputArr = Helper.buildCharArr(26);  
        return new Runnable() {  
            private String[] arr = inputArr;  
            public void run() {  
                try {  
                    for (int i = 0; i < arr.length; i++) {  
                        synchronized (threadToGo) {  
                            if (threadToGo.value == 1)  
                                threadToGo.wait();  
                            Helper.print(arr[i]);  
                            threadToGo.value = 1;  
                            threadToGo.notify();  
                        }  
                    }  
                } catch (InterruptedException e) {  
                    System.out.println("Oops...");  
                }  
            }  
        };  
    }  
    class ThreadToGo {  
        int value = 1;  
    }  
    public static void main(String args[]) throws InterruptedException {  
        MethodOne one = new MethodOne();  
        Helper.instance.run(one.newThreadOne());  
        Helper.instance.run(one.newThreadTwo());  
        Helper.instance.shutdown();  
    }
	
}
