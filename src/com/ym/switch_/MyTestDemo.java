package com.ym.switch_;

/**
 * @description switch...Ӧ�ã�break�ؼ�������ֹЧ����defaultλ�ÿ������⣡����
 * @attention   ö��ֵ����Ϊ�գ���������ָ���쳣������
 * @author Administrator
 *
 */
public class MyTestDemo {
	
	public static void main(String[] args) {
//		switchExecutive(1);
//		switchExecutive(2);
//		switchExecutive(3);
//		switchExecutive(null);
		
		Long amount = null;
		System.out.println(String.format("����Ϊ0,ת��Ϊ�ַ�������,�����%s��", String.valueOf( amount / 100)));
	}
	
	//switchִ����
	private static  void switchExecutive(Integer number){
		switch(number){
		case 1:
			System.out.println("1");
			break;
		default:
			System.out.println("default");
			return ;//��ֹ����...
		case 2:
			System.out.println("2");
			break;
		}
		System.out.println("switch���ѽ���... ...");
	}
	
}
