package com.ym.String;

/**
 * @des String API�÷���
 * eg:ռλ��s����������������%ss �������� XXXs
 * @author Administrator
 *
 */
public class TestString {
	
	public static void main(String[] args) {
		String dateStr = "201707081331";
		System.out.println(dateStr.substring(0, 6));
		System.out.println(dateStr.substring(6));
		System.out.println("��ʽ��Ϊ2λʮ����������"+  String.format("%02d", Long.valueOf(dateStr)%100));
		
		System.out.println(String.format("%sdubbo", "��־���룡"));
		
		String a1 = "String";
		String a2 = "String";
		System.out.println(a1.equals(a2));
		System.out.println(a1 == a2);
		
		System.out.println(String.format("%ssetValue[%s]", "logPrefix" ,"hello~~~"));
	}
	
}
