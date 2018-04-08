package com.ym.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestDemo {
	
	//����Ƿ���ָ���ַ�
	public static void ifContainSpecChar(String content,String reg) throws IllegalArgumentException, IllegalAccessException{
		System.out.println("content:"+content);
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(content);
		
		System.out.println(matcher.matches()?"��Ȼ����ռλ��������":"����ռλ��������");
		
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		String content = "156}8{";
		String reg = "^\\d*[\\{\\}]\\d*[\\{\\}]$";
		ifContainSpecChar(content,reg);
	}
	
}
