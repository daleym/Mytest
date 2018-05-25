package com.ym.thread.synchronize;

/**
 * ReentrantLock的中断特性：
 * 					相比synchronized，其支持中断
 * eg:当写线程WriterByReentrantLockThread一直在独占锁运行时（lock.lock），
 *          那么读线程ReaderByReentrantLockThread通过加锁后（lock.lockInterruptibly()），
 * 			可以接受中断指令(new Thread(XXX).interrupt())停止等待并结束运行！
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
		                        System.out.println("不等了，尝试中断");
		
		                        reader.interrupt();
		
		                        break;
		
		                    }   
		
		 
		
		                }   
		
		 
		
		            }
		
		        }).start();   
		
		 
		
		    }

	
}
