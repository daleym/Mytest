package com.ym.designMode.adaptor;

/**
 * 适配器模式：接口适配器模式
 * @author Administrator
 *
 */
public class AdaptorTest extends DemoAbstract {

	@Override
	public void push(){
		System.out.println("推送代码到git......");
	}
	
	public static void main(String[] args) {
		DemoInterface demoInterface =  new AdaptorTest();
		demoInterface.push();
	}
	
}
