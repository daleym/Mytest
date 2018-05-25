package com.ym.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断的应用：
 *			特性：只能中断阻塞中的线程(如sleep),若 this.interrupt()时，
 *				需要捕获异常InterruptException,这时就会使中断状态复位(达到非中断状态)
 *			eg：	Thread t1在睡眠阻塞时，通过this.interrupt中断，即可停止	
 * @author Administrator
 *
 */
public class TestInterruputSleepThread3 {

	public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                //while在try中，通过异常中断就可以退出run循环
                try {
                    while (true) {
                        //当前线程处于阻塞状态，异常必须捕捉处理，无法往外抛出
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interruted When Sleep");
                    boolean interrupt = this.isInterrupted();
                    //中断状态被复位
                    System.out.println("interrupt:"+interrupt);
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        //中断处于阻塞状态的线程
        t1.interrupt();

        /**
         * 输出结果:
           Interruted When Sleep
           interrupt:false
         */
    }
	
}
