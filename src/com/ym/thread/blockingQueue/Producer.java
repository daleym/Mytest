package com.ym.thread.blockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
 
/**
 * �������߳�
 * 
 * @author jackyuj
 */
public class Producer implements Runnable {
    
    private volatile boolean  isRunning = true;//�Ƿ������б�־
    private BlockingQueue queue;//��������
    private static AtomicInteger count = new AtomicInteger();//�Զ����µ�ֵ
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;
 
    //���캯��
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
 
    public void run() {
        String data = null;
        Random r = new Random();
 
        System.out.println("�����������̣߳�");
        try {
            while (isRunning) {
                System.out.println("������������...");
                Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));//ȡ0~DEFAULT_RANGE_FOR_SLEEPֵ��һ�������
 
                data = "data:" + count.incrementAndGet();//��ԭ�ӷ�ʽ��count��ǰֵ��1
                System.out.println("�����ݣ�" + data + "�������...");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {//�趨�ĵȴ�ʱ��Ϊ2s���������2s��û�ӽ�ȥ����false
                    System.out.println("��������ʧ�ܣ�" + data);
                }
                System.out.println(String.format("����[%s]�ɹ�����blocking queue........"  ,  data ));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("�˳��������̣߳�");
        }
    }
 
    public void stop() {
        isRunning = false;
    }
}
