package com.ym.String;

/**
 * @des String API用法：
 * eg:占位符s可以相连，，，如%ss 输出后就是 XXXs
 * @author Administrator
 *
 */
public class TestString {
	
	public static void main(String[] args) {
		String dateStr = "201707081331";
		System.out.println(dateStr.substring(0, 6));
		System.out.println(dateStr.substring(6));
		System.out.println("格式化为2位十进制整数："+  String.format("%02d", Long.valueOf(dateStr)%100));
		
		System.out.println(String.format("%sdubbo", "日志插入！"));
		
		String a1 = "String";
		String a2 = "String";
		System.out.println(a1.equals(a2));
		System.out.println(a1 == a2);
		
		System.out.println(String.format("%ssetValue[%s]", "logPrefix" ,"hello~~~"));
	}
	
}
