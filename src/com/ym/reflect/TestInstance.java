package com.ym.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��8��9�� ����11:36:34 
* @description �ڲ��಻��ͨ�� ��·�� ֱ��ʵ������com.ym.reflect.TestInstance$InnerClass ����·���� ʶ���ˣ�
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
