package com.ym.thread.unlock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * �������ԣ���֤�̰߳�ȫ��Atomic
 * @author Administrator
 *
 */
public class AtomicIntegerDemo {

	//����AtomicInteger,������������
    static AtomicInteger i=new AtomicInteger();

    public static class AddThread implements Runnable{
        public void run(){
           for(int k=0;k<10000;k++)
               i.incrementAndGet();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts=new Thread[10];
        //����10���߳�ͬʱִ��i����������
        for(int k=0;k<10;k++){
            ts[k]=new Thread(new AddThread());
        }
        //�����߳�
        for(int k=0;k<10;k++){ts[k].start();}

        for(int k=0;k<10;k++){ts[k].join();}

        System.out.println(i);//������:100000
    }
	
}
