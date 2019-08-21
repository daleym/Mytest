package com.ym.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/** 
* @author ym: 
* @version 创建时间：2019年8月9日 上午11:36:34 
* @description 内部类不能通过 包路径 直接实例化（com.ym.reflect.TestInstance$InnerClass 这种路径名 识别不了）
*/

public class TestInstance {

	public class InnerClass{
		
		private String name;
		
		public InnerClass(){
			super();
		}
		
	}
	
	public static void main(String[] args) {
//		try{
//			Class<InnerClass>  c  = (Class<InnerClass>) Class.forName("com.ym.reflect.TestInstance$InnerClass");
//			InnerClass inner = c.newInstance();
//			System.out.println(inner);
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}catch(IllegalAccessException e){
//			e.printStackTrace();
//		}catch(InstantiationException e){
//			e.printStackTrace();
//		}
		
//		Constructor<?> [] constructors =InnerClass.class.getConstructors();
//		try{
//			InnerClass instance = (InnerClass) constructors[0].newInstance(new TestInstance());
//			System.out.println(instance);
//		}catch(InvocationTargetException e){
//			e.printStackTrace();
//		}catch(IllegalAccessException e){
//			e.printStackTrace();
//		}catch(InstantiationException e){
//			e.printStackTrace();
//		}
		
	}
		
	
}
