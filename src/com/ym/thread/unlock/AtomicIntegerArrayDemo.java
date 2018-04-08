package com.ym.thread.unlock;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {

	static AtomicIntegerArray arr = new AtomicIntegerArray(10);

    public static class AddThread implements Runnable{
        public void run(){
           for(int k=0;k<10000;k++)
               //ִ��������Ԫ����������,����Ϊindex,�������±�
               arr.getAndIncrement(k%arr.length());
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread[] ts=new Thread[10];
        //����10���߳�
        for(int k=0;k<10;k++){
            ts[k]=new Thread(new AddThread());
        }
        //����10���߳�
        for(int k=0;k<10;k++){ts[k].start();}
        for(int k=0;k<10;k++){ts[k].join();}
        //ִ�н��
        //[10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]
        System.out.println(arr);
    }
	
}
