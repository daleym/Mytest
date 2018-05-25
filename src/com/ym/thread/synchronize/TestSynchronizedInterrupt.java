package com.ym.thread.synchronize;

/**
 * synchronized中断方面特性（new Thread(XXX).interupt()）：
 *     总结：不支持中断。当ReaderThread写线程持续运行时，读线程ReaderThread尝试中断时会不起作用
 *     eg:由于synchronized不支持中断，导致ReaderThread写线程持续运行占用锁（Buffer实例），
 *     读线程ReaderThread一直阻塞...
 * @author Administrator
 */
public class TestSynchronizedInterrupt {

	public static void main(String[] args) {
		
		        Buffer buff = new Buffer();   
		
		 
		
		        final WriterThread writer = new WriterThread(buff);
		
		        final ReaderThread reader = new ReaderThread(buff);   
		
		 
		
		        writer.start();
		
		        reader.start();   
		
		 
		
		        new Thread(new Runnable() {   
		
		 
		
		            @Override
		
		            public void run() {
		
		                long start = System.currentTimeMillis();
		
		                for (;;) {
		
		                    //等5秒钟去中断读
		
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
