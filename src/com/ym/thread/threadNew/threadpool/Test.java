package com.ym.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {   
		RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();//���ö������ԣ�
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),handler);
		
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<Runnable>(10));
        
         
        for(int i=0;i<21;i++){//����������̴߳���10 + 10����ô�˴���ʵ�оܾ����ԣ�����
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("�̳߳����߳���Ŀ��"+executor.getPoolSize()+"�������еȴ�ִ�е�������Ŀ��"+
            executor.getQueue().size()+"����ִ������������Ŀ��"+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}


class MyTask implements Runnable {
   private int taskNum;
    
   public MyTask(int num) {
       this.taskNum = num;
   }
    
   @Override
   public void run() {
       System.out.println("����ִ��task "+taskNum);
       try {
           Thread.currentThread().sleep(4000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("task "+taskNum+"ִ�����");
   }
}
