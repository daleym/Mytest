package com.ym.thread.threadPool;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * �̳߳ص�Ӧ�ã�
 * 
 * @author Administrator
 */
public class Test {

	public static void main(String[] args) {   
		RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();//���ö������ԣ�---�������߳����񣬲��׳��쳣��
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
//        executor.shutdown();
        List<Runnable> notFinishedTask = executor.shutdownNow();
        System.out.println(String.format("notFinishedTask��%s��" , notFinishedTask.toArray()));
        try {
			boolean result = executor.awaitTermination(1 , TimeUnit.MICROSECONDS);
			System.out.println(String.format("���߳�ִ�����,���еȴ������%s��", result));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


class MyTask implements Runnable {
   
	private static final String ThreadName = Thread.currentThread().getName();
	
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
   
   @Override
   public String toString(){
	   return String.format("�߳����ơ�%s������%s��", taskNum);
   }
}
