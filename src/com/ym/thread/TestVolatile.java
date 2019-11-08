package com.ym.thread;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��11��7�� ����5:29:39 
@description
	volatile ������ݾ��������ĸ��ţ�
	�����ڴ�ģ�͵�happens-before��ϵ���������ڴ�ɼ���
	ע�����̻߳����£���b=1 ��ִ�У���ôhappens-before r2 = b 

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
