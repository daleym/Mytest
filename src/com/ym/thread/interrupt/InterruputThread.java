package com.ym.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断应用：
 * 			特性：未阻塞的线程，可以通过内置中断检查，以及处理退出逻辑，来达到中断的目的，但是不会使中断状态复位
 *          eg：Thread执行体中，通过this.isInterrupted()来检测中断状态，那么若处于中断状态
 *          	，则通过中断处理逻辑，达到中断效果，但是不会使中断状态复位
 * @author Administrator
 *
 */
public class InterruputThread {

	public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    //判断当前线程是否被中断
                    if (this.isInterrupted()){
                        System.out.println("线程中断");
                        break;
                    }
                }

                System.out.println("已跳出循环,线程中断!");
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();

        /**
         * 输出结果:
            线程中断
            已跳出循环,线程中断!
         */
    }
	
}
