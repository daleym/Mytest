package com.ym.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description  限制 高并发下多个线程 对共享资源的限制访问  semaphore
 * 				基于 AQS，共享模式的实现！
 * 获取许可的2种方式：
 * 1.acquire（） 获取不到许可则阻塞
 * 2.tryacquire()  带超时时间，获取许可...
 * @author Administrator
 */
public class TestSemaphore {
	
	private int a = 0;
	
	// 定义2个新号量
    Semaphore semaphore = new Semaphore(2 );//非公平锁：新来的线程，忽略需要或许许可  等待队列的线程

    /**
     * 银行存钱类
     */
    class Bank {
        private int account = 100;

        public int getAccount() {
            return account;
        }

        public void save(int money) {
            account += money;
        }
    }

    /**
     * 线程执行类，每次存10块钱
     */
    class NewThread implements Runnable {
        private Bank bank;
        private Semaphore semaphore;
        boolean ifRelease = false;

        public NewThread(Bank bank ,Semaphore semaphore) {
            this.bank = bank;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
        	
            int b = a++;
            String threadName = String.format("线程名【%s】:编号【%s】", Thread.currentThread().getName() , b );
            if (semaphore.availablePermits() > 0) {
                System.out.println(threadName + "，进入银行,有位置空闲出来，尝试去存钱......" );
            } else {
                System.out.println(threadName + "启动，进入银行,无位置，去排队等待等待");
            }
            try {
//                semaphore.acquire();//获取不到许可 ，则阻塞中...
                boolean result = semaphore.tryAcquire(2 , TimeUnit.SECONDS); // 带等待时间，尝试许可...
//                semaphore.acquireUninterruptibly(); 
                if(!result ){
                	System.out.println(threadName + "获取许可超时了，直接终止...");
                	return;//获取不到许可，则终止...
                }
                ifRelease = true;
                System.out.println(threadName + "获取到位置---开始存钱,,,等待大片儿人数:"+ semaphore.getQueueLength());
                bank.save(10);
                System.out.println(threadName + "账户余额为：" + bank.getAccount());
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
                
            }finally {
            	if(!ifRelease){
            		System.out.println(threadName + "没有获取到锁，无需释放许可...");
            		return;
            	}
            	System.out.println(threadName + "存钱完毕，离开银行");
            	semaphore.release();
                
			}
        }
    }

    /**
     * 建立线程，调用内部类，开始存钱
     */
    public void useThread() {
        Bank bank = new Bank();
        
        // 建立一个缓存线程池
        ExecutorService es = Executors.newCachedThreadPool();
        // 建立20个线程
        for (int i = 0; i < 6; i++) {
            // 执行一个线程
            es.submit(new Thread(new NewThread(bank , semaphore)));
        }
        // 关闭线程池
        es.shutdown();

        // 从信号量中获取两个许可，并且在获得许可之前，一直将线程阻塞
//        semaphore.acquireUninterruptibly(2);
        System.out.println("到点了，工作人员要吃饭了");
//        // 释放两个许可，并将其返回给信号量
//        semaphore.release(2);
    }

    public static void main(String[] args) {
        TestSemaphore test = new TestSemaphore();
        test.useThread();
    }
	
}
