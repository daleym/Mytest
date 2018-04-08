package com.ym.staticCodeBlock;

public class TestDemo2{
	public static void main(String[] args) {
		System.out.println(SonClass.number);
		System.out.println(SonClass.number2);
	}
}

class FatherClass{
	
	static {
		System.out.println("初始化【父类】的静态代码块...");
	}
	
	public static  Integer number = 2;
	
}

class SonClass extends FatherClass{
	
	public final  static Integer number2 = 3; 
	
	static{
		System.out.println("初始化【子类】的静态代码块...");
	}
}
