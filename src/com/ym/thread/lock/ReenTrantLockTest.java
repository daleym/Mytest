package com.ym.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ����AQS���������̰߳�ȫReenTrantLock
 * @author Administrator
 *
 */
public class ReenTrantLockTest implements Runnable {

	public static ReentrantLock lock=new ReentrantLock();
    public static int i=0;
    @Override
    public void run() {
        for(int j=0;j<10000000;j++){
            lock.lock();
            //֧��������
            lock.lock();
            try{
                i++;
            }finally{
                //ִ�����ν���
            	System.out.println(lock.getHoldCount() );
                lock.unlock();
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
    	ReenTrantLockTest tl=new ReenTrantLockTest();
        Thread t1=new Thread(tl);
        Thread t2=new Thread(tl);
        t1.start();t2.start();
        t1.join();t2.join();
        //��������20000000
        System.out.println(i);
    }
	
}
