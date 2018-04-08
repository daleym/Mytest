package com.ym.staticCodeBlock;

import java.math.BigDecimal;

/**
 * 静态代码块和动态代码块
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
		System.out.println("静态代码块，初始化number:"+number);
	}
	
	private static User user = new User();
	
	public static User getInstance(){
		return user;
	}
	
	private User(){
		number++;
		System.out.println("number得值为："+number);
	}
}
