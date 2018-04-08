package com.ym.staticCodeBlock;

import java.math.BigDecimal;

/**
 * ��̬�����Ͷ�̬�����
 * @author ym
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		User.getInstance();
	}
}

class User{ 	 	
	private static  int number;
	
	static{
		number = 666;
		System.out.println("��̬����飬��ʼ��number:"+number);
	}
	
	private static User user = new User();
	
	public static User getInstance(){
		return user;
	}
	
	private User(){
		number++;
		System.out.println("number��ֵΪ��"+number);
	}
}
