package com.ym.thread.daemon;

public class MyDaemon implements Runnable {

	public void run() { 
		for (long i = 0; i < 9999999L; i++) {
			System.out.println("��̨�̵߳�" + i + "��ִ�У�");
		}
	}
}
