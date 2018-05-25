package com.ym.thread.synchronize;

/**
 * ReentrantLock���ж����ԣ�
 * 					���synchronized����֧���ж�
 * eg:��д�߳�WriterByReentrantLockThreadһֱ�ڶ�ռ������ʱ��lock.lock����
 *          ��ô���߳�ReaderByReentrantLockThreadͨ��������lock.lockInterruptibly()����
 * 			���Խ����ж�ָ��(new Thread(XXX).interrupt())ֹͣ�ȴ����������У�
 * @author Administrator
 *
 */
public class TestReentrantLockInterrupt {

	public static void main(String[] args) {
		
		        BufferInterruptibly buff = new BufferInterruptibly();   
		
		 
		
		        final WriterByReentrantLockThread writer = new WriterByReentrantLockThread(buff);
		
		        final ReaderByReentrantLockThread reader = new ReaderByReentrantLockThread(buff);   
		
		 
		
		        writer.start();
		
		        reader.start();   
		
		 
		
		        new Thread(new Runnable() {   
		
		 
		
		            @Override
		
		            public void run() {
		
		                long start = System.currentTimeMillis();
		                for (;;) {
		                    if (System.currentTimeMillis()
		                            - start > 5000) {
		                        System.out.println("�����ˣ������ж�");
		
		                        reader.interrupt();
		
		                        break;
		
		                    }   
		
		 
		
		                }   
		
		 
		
		            }
		
		        }).start();   
		
		 
		
		    }

	
}
