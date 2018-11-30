package com.ym.thread.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue; 

/**
 * �������У�blocking queue����Ӧ��---LinkedBlockingQueue
 * eg:���������������죬��ô���������ߣ��ȴ�������ȡ�����ѣ������������п���λ�ã��Զ������ѣ�������֮��������ͬ��~~~
 * @author Administrator
 *
 */
public class TestBlockingQueue {
 
    public static void main(String[] args) throws InterruptedException {
        // ����һ������Ϊ10�Ļ������
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
 
        //new�����������ߺ�һ��������
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer = new Consumer(queue);
 
        // ����Executors
        ExecutorService service = Executors.newCachedThreadPool();
        // �����߳�
        System.out.println(String.format("��ʼִ���������������߳�...��ǰʱ��[%s]", DateUtils.getToday(DateUtils.DEFAULT_FORMAT) ));
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer);
 
        // ִ��3s
        Thread.sleep(3 * 1000);
        System.out.println(String.format("����ִ���������������߳�...��ǰʱ��[%s]", DateUtils.getToday(DateUtils.DEFAULT_FORMAT) ));
        producer1.stop();
        producer2.stop();
        producer3.stop();
 
        Thread.sleep(2000);
        // �˳�Executor
        service.shutdown();
    }
}
