package com.ym.switch_;

/**
 * @description 条件1、2，执行同一逻辑块
 * @author ming.yang TM-30
 *
 */
public class MyTestDemo2 {
	
	public static void main(String[] args) {
		switchExecutive(1);
		switchExecutive(2);
		switchExecutive(3);
	}
	
	
	private static  void switchExecutive(Integer number){
		switch(number){
			case 1:
			case 2:
				System.out.println("进入到2逻辑块...");
				break;
			default:
				System.out.println("进入到缺省逻辑块...");
		}
		System.out.println("switch块已结束... ...");
	}
}
