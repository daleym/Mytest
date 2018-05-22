package com.ym.thread.daemon;

public class MyDaemon implements Runnable {

	public void run() { 
		for (long i = 0; i < 9999999L; i++) {
			System.out.println("后台线程第" + i + "次执行！");
		}
	}
}
