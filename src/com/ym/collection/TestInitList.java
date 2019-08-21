package com.ym.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 
* @author ym: 
* @version 创建时间：2019年8月21日 上午11:30:32 
* @description 初始化list方式分析
* 	>匿名内部类方式 （详见No1）
* 		>>存在内存泄漏的风险
* 		>>执行效率低
* 	>Arrays静态API（详见No2）
* 		>>仅用于list初始化（ArrayList返回实例）
* 	>Stream(jdk8)
* 		>流式处理
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
