package com.ym.thread.daemon;

/**
 * �ػ��߳�Ӧ��2
 * 			�����߳�ִ���꣬���ػ��̻߳�ִֹͣ��
 *          eg:��MyCommon�����߳�ִ����ϣ���new Thread(new MyDaemon())������ִֹͣ�У�����
 *  
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		Thread t1 = new MyCommon();
		Thread t2 = new Thread(new MyDaemon()); 
		t2.setDaemon(true); //����Ϊ�ػ��߳�
		t2.start(); 
		t1.start(); 
	}
	
}

class MyCommon extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("�߳�1��" + i + "��ִ�У�");  
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
