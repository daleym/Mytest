package com.ym.thread.synchronized1;

/**
 * ReentrantLock֧���ж�,synchronized��֧���ж�
 * eg:lock.lockInterruptibly();reader.interrupt();
 * @author Administrator
 *
 */
public class TestNew {

	public static void main(String[] args) {
		
		        BufferInterruptibly buff = new BufferInterruptibly();   
		
		 
		
		        final WriterNew writer = new WriterNew(buff);
		
		        final ReaderNew reader = new ReaderNew(buff);   
		
		 
		
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
