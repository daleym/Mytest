package com.ym.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断的应用：
 * 			特性：正在运行的线程，不能通过this.interrupt()直接中断线程。
 * 			eg:如Thread线程正在执行，那么不能被中断掉（this.interrupt()）
 * @author Administrator
 *
 */
public class TestInterruputThreadDemo3 {

	public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    System.out.println("未被中断");
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();

        /**
         * 输出结果(无限执行):
             未被中断
             未被中断
             未被中断
             ......
         */
    }
	
}
