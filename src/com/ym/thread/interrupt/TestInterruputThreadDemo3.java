package com.ym.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * �߳��жϵ�Ӧ�ã�
 * 			���ԣ��������е��̣߳�����ͨ��this.interrupt()ֱ���ж��̡߳�
 * 			eg:��Thread�߳�����ִ�У���ô���ܱ��жϵ���this.interrupt()��
 * @author Administrator
 *
 */
public class TestInterruputThreadDemo3 {

	public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    System.out.println("δ���ж�");
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();

        /**
         * ������(����ִ��):
             δ���ж�
             δ���ж�
             δ���ж�
             ......
         */
    }
	
}
