package com.ym.String;

public class MyTestDemo {
	
	public static void main(String[] args) {
		String dateStr = "201707081331";
		System.out.println(dateStr.substring(0, 6));
		System.out.println(dateStr.substring(6));
		System.out.println("格式化为2位十进制整数："+  String.format("%02d", Long.valueOf(dateStr)%100));
		
		System.out.println(String.format("%sdubbo", "日志插入！"));
	}
	
}
