package com.ym.thread.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	private Semaphore smp = new Semaphore(3,true); //��ƽ����
    private Random rnd = new Random();
    
    class Task implements Runnable{
        private String id;
        Task(String id){
            this.id = id;
        }
        
        public void run(){
            try {
                smp.acquire();
                //smp.acquire(int permits);//ʹ���в�����������ʹ��permits�����
                System.out.println("Thread " + id + " is working");
                //System.out.println("�ڵȴ����߳���Ŀ��"+ smp.getQueueLength());
                work();
                System.out.println("Thread " + id + " is over");
            } catch (InterruptedException e) {
            }
            finally 
            {
                smp.release();
            }
        }
        
        public void work() {//��װ�ڹ�����ʵ����˯��
            int worktime = rnd.nextInt(1000);
            System.out.println("Thread " + id + " worktime  is "+ worktime);
            try {
                Thread.sleep(worktime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        ExecutorService se = Executors.newCachedThreadPool();
        se.submit(semaphoreDemo.new Task("a"));
        se.submit(semaphoreDemo.new Task("b"));
        se.submit(semaphoreDemo.new Task("c"));
        se.submit(semaphoreDemo.new Task("d"));
        se.submit(semaphoreDemo.new Task("e"));
        se.submit(semaphoreDemo.new Task("f"));
        se.shutdown();
    }
	
}
