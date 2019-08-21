package com.ym.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��8��21�� ����11:30:32 
* @description ��ʼ��list��ʽ����
* 	>�����ڲ��෽ʽ �����No1��
* 		>>�����ڴ�й©�ķ���
* 		>>ִ��Ч�ʵ�
* 	>Arrays��̬API�����No2��
* 		>>������list��ʼ����ArrayList����ʵ����
* 	>Stream(jdk8)
* 		>��ʽ����
*/

public class TestInitList {

	private static List<String> anonymousInnerClassists; 
	
	public static void main(String[] args) {
		initByAnonymousInnerClass();
		System.out.println(anonymousInnerClassists);
		
		initByArrays();
		System.out.println(anonymousInnerClassists);
		
		initByStream();
		System.err.println(anonymousInnerClassists);
	}
	
	/**
	 *No1
	 */
	private static void initByAnonymousInnerClass(){
		anonymousInnerClassists = new ArrayList<String>(){
			{
				add("anan~~~");
				add("lily~~~");
				add("anan~~~");
			}
		};
	}
	
	/**
	 * No2
	 */
	private static void initByArrays(){
		anonymousInnerClassists = Arrays.asList("an an uncle" , "lily sister" ,"an an uncle");
	}
	
	/**
	 * No3
	 */
	private static void initByStream(){
		anonymousInnerClassists = Stream.of("xiao an an", "lily lily" , "xiao an an").collect(Collectors.toList());
	}
	
}
