package com.ym.thread;

/** 
* @author ym: 
* @version 创建时间：2019年11月7日 下午5:29:39 
@description
	volatile 解决数据竞争引发的干扰，
	利用内存模型的happens-before关系，增加了内存可见性
	注：多线程环境下，若b=1 先执行，那么happens-before r2 = b 

*/

public class TestVolatile {

	int a = 0;
//    volatile int b = 0;
    int b = 0;
	
	public void method1(){
		int r1 = a;
		b = 1;
		System.out.println("!!!r1!!!!" + r1);
	}
	
	public void method2(){
		int r2 = b;
		a = 2;
		System.out.println("!!!r2!!!!" + r2);
	}
	
	public static void main(String[] args) {
		TestVolatile testVolatile = new TestVolatile();
		
		new Thread(() -> {
			testVolatile.method1();
		}).start();
		
		
		
		new Thread(() -> {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			testVolatile.method2();
		}).start();
		
		
		
		
		
	}
	
}
