package com.ym.thread.synchronize;

/**
 * synchronized�жϷ������ԣ�new Thread(XXX).interupt()����
 *     �ܽ᣺��֧���жϡ���ReaderThreadд�̳߳�������ʱ�����߳�ReaderThread�����ж�ʱ�᲻������
 *     eg:����synchronized��֧���жϣ�����ReaderThreadд�̳߳�������ռ������Bufferʵ������
 *     ���߳�ReaderThreadһֱ����...
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
		
		                    //��5����ȥ�ж϶�
		
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
