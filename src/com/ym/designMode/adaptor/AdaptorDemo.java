package com.ym.designMode.adaptor;

/**
 * ������ģʽ���ӿ�������ģʽ
 * @author Administrator
 *
 */
public class AdaptorDemo extends DemoAbstract {

	@Override
	public void push(){
		System.out.println("���ʹ��뵽git......");
	}
	
	public static void main(String[] args) {
		DemoInterface demoInterface =  new AdaptorDemo();
		demoInterface.push();
	}
	
}
