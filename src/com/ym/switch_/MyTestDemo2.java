package com.ym.switch_;

/**
 * @description ����1��2��ִ��ͬһ�߼���
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
				System.out.println("���뵽2�߼���...");
				break;
			default:
				System.out.println("���뵽ȱʡ�߼���...");
		}
		System.out.println("switch���ѽ���... ...");
	}
}
