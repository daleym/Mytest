package com.ym.thread.threadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池 拒绝策略的应用  ：
 * 			直接丢弃、
 * 			丢弃并抛异常、
 * 			丢弃等待队列头的任务，再重试、
 * 			由调用线程串行执行！
 * @author Administrator
 *
 */
public class ExecutorDemo {

	private static  SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        int corePoolSize = 1;
        int maximumPoolSize = 1;
        BlockingQueue queue = new  ArrayBlockingQueue<Runnable>(1);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize,  maximumPoolSize, 
                0, TimeUnit.SECONDS, queue ) ;
        //拒绝策略1  DiscardPolicy：只有task0和task1被执行了
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy ());
        //拒绝策略2  DiscardOldestPolicy：只有task0和task9被执行了
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        //拒绝策略3    DiscardOldestPolicy：都将被执行  ，线程池阻塞队列、最大线程数都满了的情况，交给主线程执行！！！
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //拒绝策略4    AbortPolicy：只有task0和task1被执行，并抛出RejectedExecutionException异常！
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        for(int i=0;i<10;i++){
            final int index = i;
            pool.submit(new Runnable(){

                @Override
                public void run() {
                    log(Thread.currentThread().getName()+"begin run task :"+index);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log(Thread.currentThread().getName()+" finish run  task :"+index);
                }

            });
        }

        log("main thread before sleep!!!");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log("before shutdown()");

        pool.shutdown();

        log("after shutdown(),pool.isTerminated=" + pool.isTerminated());
        try {
            pool.awaitTermination(1000L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log("now,pool.isTerminated=" + pool.isTerminated());
    }

    protected static void log(String string) {
        System.out.println(sdf.format(new Date())+"  "+string);
    }
	
}
