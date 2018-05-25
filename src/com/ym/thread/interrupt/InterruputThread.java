package com.ym.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * �߳��ж�Ӧ�ã�
 * 			���ԣ�δ�������̣߳�����ͨ�������жϼ�飬�Լ������˳��߼������ﵽ�жϵ�Ŀ�ģ����ǲ���ʹ�ж�״̬��λ
 *          eg��Threadִ�����У�ͨ��this.isInterrupted()������ж�״̬����ô�������ж�״̬
 *          	����ͨ���жϴ����߼����ﵽ�ж�Ч�������ǲ���ʹ�ж�״̬��λ
 * @author Administrator
 *
 */
public class InterruputThread {

	public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run(){
                while(true){
                    //�жϵ�ǰ�߳��Ƿ��ж�
                    if (this.isInterrupted()){
                        System.out.println("�߳��ж�");
                        break;
                    }
                }

                System.out.println("������ѭ��,�߳��ж�!");
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
