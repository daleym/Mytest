package com.ym.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestSemaphore {
	
	private int a = 0;
	
	// ����2���º���
    Semaphore semaphore = new Semaphore(2,true);//��ƽ���ԣ�����

    /**
     * ���д�Ǯ��
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
     * �߳�ִ���࣬ÿ�δ�10��Ǯ
     */
    class NewThread implements Runnable {
        private Bank bank;
        private Semaphore semaphore;

        public NewThread(Bank bank ,Semaphore semaphore) {
            this.bank = bank;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            int b = a++;
//            if (semaphore.availablePermits() > 0) {
//                System.out.println("�߳�" + b + "��������������,��λ������ȥ��Ǯ......" );
//            } else {
//                System.out.println("�߳�" + b + "��������������,��λ�ã�ȥ�Ŷӵȴ��ȴ�");
//            }
            try {
                semaphore.acquire();
                System.out.println("�߳�" + b + "����,,,�ȴ���Ƭ������:"+ semaphore.getQueueLength());
                bank.save(10);
                System.out.println(b + "�˻����Ϊ��" + bank.getAccount());
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
                
            }finally {
            	semaphore.release();
                System.out.println("�߳�" + b + "��Ǯ��ϣ��뿪����");
			}
        }
    }

    /**
     * �����̣߳������ڲ��࣬��ʼ��Ǯ
     */
    public void useThread() {
        Bank bank = new Bank();
        
        // ����һ�������̳߳�
        ExecutorService es = Executors.newCachedThreadPool();
        // ����20���߳�
        for (int i = 0; i < 10; i++) {
            // ִ��һ���߳�
            es.submit(new Thread(new NewThread(bank , semaphore)));
        }
        // �ر��̳߳�
        es.shutdown();

        // ���ź����л�ȡ�������ɣ������ڻ������֮ǰ��һֱ���߳�����
//        semaphore.acquireUninterruptibly(2);
        System.out.println("�����ˣ�������ԱҪ�Է���");
//        // �ͷ��������ɣ������䷵�ظ��ź���
//        semaphore.release(2);
    }

    public static void main(String[] args) {
        TestSemaphore test = new TestSemaphore();
        test.useThread();
    }
	
}