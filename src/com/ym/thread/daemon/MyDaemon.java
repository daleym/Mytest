package com.ym.thread.daemon;

public class MyDaemon implements Runnable {

	public void run() { 
		for (long i = 0; i < 9999999L; i++) {
			System.out.println("�ػ��̵߳�" + i + "��ִ�У�");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
	}
}
