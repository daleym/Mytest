package com.ym.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * �߳��жϵ�Ӧ�ã�
 *			���ԣ�ֻ���ж������е��߳�(��sleep),�� this.interrupt()ʱ��
 *				��Ҫ�����쳣InterruptException,��ʱ�ͻ�ʹ�ж�״̬��λ(�ﵽ���ж�״̬)
 *			eg��	Thread t1��˯������ʱ��ͨ��this.interrupt�жϣ�����ֹͣ	
 * @author Administrator
 *
 */
public class TestInterruputSleepThread3 {

	public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                //while��try�У�ͨ���쳣�жϾͿ����˳�runѭ��
                try {
                    while (true) {
                        //��ǰ�̴߳�������״̬���쳣���벶׽�����޷������׳�
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interruted When Sleep");
                    boolean interrupt = this.isInterrupted();
                    //�ж�״̬����λ
                    System.out.println("interrupt:"+interrupt);
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        //�жϴ�������״̬���߳�
        t1.interrupt();

        /**
         * ������:
           Interruted When Sleep
           interrupt:false
         */
    }
	
}
