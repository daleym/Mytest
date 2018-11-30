package com.ym.thread.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue; 

/**
 * 阻塞队列（blocking queue）的应用---LinkedBlockingQueue
 * eg:若生产者生产过快，那么会阻塞休眠，等待消费者取出消费，待阻塞队列有空闲位置，自动被唤醒；；；反之，消费者同理~~~
 * @author Administrator
 *
 */
public class TestBlockingQueue {
 
    public static void main(String[] args) throws InterruptedException {
        // 声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
 
        //new了三个生产者和一个消费者
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);
 
        // 借助Executors
        ExecutorService service = Executors.newCachedThreadPool();
        // 启动线程
        System.out.println(String.format("开始执行生产者消费者线程...当前时间[%s]", DateUtils.getToday(DateUtils.DEFAULT_FORMAT) ));
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);
 
        // 执行3s
        Thread.sleep(3 * 1000);
        System.out.println(String.format("结束执行生产者消费者线程...当前时间[%s]", DateUtils.getToday(DateUtils.DEFAULT_FORMAT) ));
        producer1.stop();
        producer2.stop();
        producer3.stop();
 
        Thread.sleep(2000);
        // 退出Executor
        service.shutdown();
    }
}
