package com.ym.designMode.adaptor;

/**
 * ������ģʽ���ӿ�������ģʽ  
 * @author Administrator
 *
 */
public class TestAdaptor extends DemoAbstract {
	public int j  = 9;
	
	@Override
	public void push(){
		System.out.println(String.format("���ʹ��뵽git......i[%s],j[%s]", i , j));
	}
	
	public static void main(String[] args) {
		DemoInterface demoInterface =  new TestAdaptor();
		demoInterface.push();
	}
	
}
