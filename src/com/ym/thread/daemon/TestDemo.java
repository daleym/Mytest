package com.ym.thread.daemon;

/**
 * �ػ��߳�Ӧ��
 * 			�����ػ��̣߳�setDaemon(true)
 *          ���ԣ����߳�����ִ���꣬��JVM��ֹͣ���ػ��̱߳��ʧЧ������
 *          eg:���̺߳��ػ��߳�ͬʱ��daemon.txt׷�����ݣ����ػ��߳������߳�ǰ��ͬʱִ���꣬��ô��׷�����ݳɹ�������׷��ʧ�ܣ�
 * @author Administrator
 *
 */
public class TestDemo {

	public static void main(String[] args) throws InterruptedException     
    {     
        SubThreadRunnable tr=new SubThreadRunnable();     
        Thread thread=new Thread(tr);     
                thread.setDaemon(true); //�����ػ��߳�     
        thread.start(); //��ʼִ���ػ�����     
        new Thread(new SubThreadRunnable()).start();//��ʼִ�����߳�
    }
	
}
