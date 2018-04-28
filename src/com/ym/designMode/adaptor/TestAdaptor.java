package com.ym.designMode.adaptor;

/**
 * 适配器模式：接口适配器模式  
 * @author Administrator
 *
 */
public class TestAdaptor extends DemoAbstract {
	public int j  = 9;
	
	@Override
	public void push(){
		System.out.println(String.format("推送代码到git......i[%s],j[%s]", i , j));
	}
	
	public static void main(String[] args) {
		DemoInterface demoInterface =  new TestAdaptor();
		demoInterface.push();
	}
	
}
