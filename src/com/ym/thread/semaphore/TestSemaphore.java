package com.ym.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description  ���� �߲����¶���߳� �Թ�����Դ�����Ʒ���  semaphore
 * 				���� AQS������ģʽ��ʵ�֣�
 * ��ȡ��ɵ�2�ַ�ʽ��
 * 1.acquire���� ��ȡ�������������
 * 2.tryacquire()  ����ʱʱ�䣬��ȡ���...
 * @author Administrator
 */
public class TestSemaphore {
	
	private int a = 0;
	
	// ����2���º���
    Semaphore semaphore = new Semaphore(2 );//�ǹ�ƽ�����������̣߳�������Ҫ�������  �ȴ����е��߳�

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
        boolean ifRelease = false;

        public NewThread(Bank bank ,Semaphore semaphore) {
            this.bank = bank;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
        	
            int b = a++;
            String threadName = String.format("�߳�����%s��:��š�%s��", Thread.currentThread().getName() , b );
            if (semaphore.availablePermits() > 0) {
                System.out.println(threadName + "����������,��λ�ÿ��г���������ȥ��Ǯ......" );
            } else {
                System.out.println(threadName + "��������������,��λ�ã�ȥ�Ŷӵȴ��ȴ�");
            }
            try {
//                semaphore.acquire();//��ȡ������� ����������...
                boolean result = semaphore.tryAcquire(2 , TimeUnit.SECONDS); // ���ȴ�ʱ�䣬�������...
//                semaphore.acquireUninterruptibly(); 
                if(!result ){
                	System.out.println(threadName + "��ȡ��ɳ�ʱ�ˣ�ֱ����ֹ...");
                	return;//��ȡ������ɣ�����ֹ...
                }
                ifRelease = true;
                System.out.println(threadName + "��ȡ��λ��---��ʼ��Ǯ,,,�ȴ���Ƭ������:"+ semaphore.getQueueLength());
                bank.save(10);
                System.out.println(threadName + "�˻����Ϊ��" + bank.getAccount());
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
                
            }finally {
            	if(!ifRelease){
            		System.out.println(threadName + "û�л�ȡ�����������ͷ����...");
            		return;
            	}
            	System.out.println(threadName + "��Ǯ��ϣ��뿪����");
            	semaphore.release();
                
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
        for (int i = 0; i < 6; i++) {
            // ִ��һ���߳�
            es.submit(new Thread(new NewThread(bank , semaphore)));
        }
        // �ر��̳߳�
        es.shutdown();

        // ���ź����л�ȡ������ɣ������ڻ�����֮ǰ��һֱ���߳�����
//        semaphore.acquireUninterruptibly(2);
        System.out.println("�����ˣ�������ԱҪ�Է���");
//        // �ͷ�������ɣ������䷵�ظ��ź���
//        semaphore.release(2);
    }

    public static void main(String[] args) {
        TestSemaphore test = new TestSemaphore();
        test.useThread();
    }
	
}
