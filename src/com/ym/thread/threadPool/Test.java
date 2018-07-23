package com.ym.thread.threadPool;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的应用：
 * 
 * @author Administrator
 */
public class Test {

	public static void main(String[] args) {   
		RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();//设置丢弃策略！---丢弃该线程任务，不抛出异常！
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),handler);
		
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<Runnable>(10));
        
         
        for(int i=0;i<21;i++){//如果创建的线程大于10 + 10，那么此处会实行拒绝策略！！！
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
            executor.getQueue().size()+"，已执行完别的任务数目："+executor.getCompletedTaskCount());
        }
//        executor.shutdown();
        List<Runnable> notFinishedTask = executor.shutdownNow();
        System.out.println(String.format("notFinishedTask【%s】" , notFinishedTask.toArray()));
        try {
			boolean result = executor.awaitTermination(1 , TimeUnit.MICROSECONDS);
			System.out.println(String.format("主线程执行完毕,其中等待结果【%s】", result));
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
       System.out.println("正在执行task "+taskNum);
       try {
           Thread.currentThread().sleep(4000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("task "+taskNum+"执行完毕");
   }
   
   @Override
   public String toString(){
	   return String.format("线程名称【%s】：【%s】", taskNum);
   }
}
