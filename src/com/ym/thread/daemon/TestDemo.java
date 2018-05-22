package com.ym.thread.daemon;

/**
 * 守护线程应用
 * 			设置守护线程：setDaemon(true)
 *          特性：子线程若先执行完，则JVM会停止，守护线程便会失效！！！
 *          eg:子线程和守护线程同时往daemon.txt追加数据，若守护线程在子线程前或同时执行完，那么会追加数据成功，否则追加失败！
 * @author Administrator
 *
 */
public class TestDemo {

	public static void main(String[] args) throws InterruptedException     
    {     
        SubThreadRunnable tr=new SubThreadRunnable();     
        Thread thread=new Thread(tr);     
                thread.setDaemon(true); //设置守护线程     
        thread.start(); //开始执行守护进程     
        new Thread(new SubThreadRunnable()).start();//开始执行子线程
    }
	
}
