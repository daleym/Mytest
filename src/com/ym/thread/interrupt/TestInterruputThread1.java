package com.ym.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * �߳��ж�Ӧ�ã�
 * 			���ԣ�δ�������̣߳�����ͨ�������жϼ�飬�Լ������˳��߼������ﵽ�жϵ�Ŀ�ģ����ǻ�ʹ�ж�״̬��λ
 *          eg��Threadִ�����У�ͨ��Thread.interrupted()������ж�״̬����ô�������ж�״̬
 *          	����ͨ���жϴ����߼����ﵽ�ж�Ч�������ǻ�ʹ�ж�״̬��λ
 * @author Administrator
 *
 */
public class TestInterruputThread1 {

	public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run(){
                try {
                //�жϵ�ǰ�߳��Ƿ����ж�,ע��interrupted�����Ǿ�̬��,ִ�к����ж�״̬���и�λ
                while (!Thread.interrupted()) {
                    TimeUnit.SECONDS.sleep(2);
                }
                } catch (InterruptedException e) {
                	boolean result = this.interrupted();
                	System.out.println("�Ѿ��ж��ˣ��Ҹ�λ��"+result);
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();

        /**
         * ������:
            �߳��ж�
            ������ѭ��,�߳��ж�!
         */
    }
	
}
