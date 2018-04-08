package com.ym.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestDemo {
	
	//检查是否含有指定字符
	public static void ifContainSpecChar(String content,String reg) throws IllegalArgumentException, IllegalAccessException{
		System.out.println("content:"+content);
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(content);
		
		System.out.println(matcher.matches()?"依然含有占位符！！！":"不含占位符！！！");
		
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		String content = "156}8{";
		String reg = "^\\d*[\\{\\}]\\d*[\\{\\}]$";
		ifContainSpecChar(content,reg);
	}
	
}
