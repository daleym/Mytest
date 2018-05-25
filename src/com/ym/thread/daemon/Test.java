package com.ym.thread.daemon;

/**
 * 守护线程应用2
 * 			若子线程执行完，则守护线程会停止执行
 *          eg:若MyCommon工作线程执行完毕，则new Thread(new MyDaemon())会立即停止执行！！！
 *  
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		Thread t1 = new MyCommon();
		Thread t2 = new Thread(new MyDaemon()); 
		t2.setDaemon(true); //设置为守护线程
		t2.start(); 
		t1.start(); 
	}
	
}

class MyCommon extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("线程1第" + i + "次执行！");  
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
