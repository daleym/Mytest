package com.ym.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ym.entity.Student;

/**
 * 反射
 * @author ym
 *
 */
public class TestDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		
		Scanner scanner = null ;
		for(int i=0 ;i<100;i++){
			scanner = new Scanner(System.in);
			System.out.println("请输入类名...");
			String inputStr = scanner.next();
			System.out.println("接收到的输入类名为："+inputStr);
			
			getSuperClass(inputStr);
			getFields(inputStr);
			getMethods(inputStr);
			
			
			getContent(new Student("100"));
		}
		
		scanner.close();
	}
	
	//得到父类相关属性
	public static void getSuperClass(String inputStr) throws ClassNotFoundException{
		Class<?> myClass  = Class.forName(inputStr);
		Class<?> superClass = myClass.getSuperclass();
		System.out.println("对应的父类名称为："+superClass.getName());
		System.out.println("---------------------------------");
	}
	
	//得到成员变量属性
	public static void getFields(String inputStr) throws ClassNotFoundException{
		Class<?> myClass  =Class.forName(inputStr);
		
		Field [] fields = myClass.getDeclaredFields();
		for(Field f: fields){
			String type = f.getType().getName();
			System.out.println("对应的成员变量名称："+f.getName()+"，类型："+type);
		}
		System.out.println("---------------------------------");
	}
	
	//得到成员方法
	public static void getMethods(String inputStr) throws ClassNotFoundException{
		Class<?> myclass = Class.forName(inputStr);
		
		Method [] methods = myclass.getDeclaredMethods();
		for(Method method : methods){
			String modifier = Modifier.toString(method.getModifiers());
			String returnType = method.getReturnType().getName();
			System.out.println("对应的成员方法名称："+method.getName()+",修饰符："+modifier+",返回类型："+returnType);
		}
		System.out.println("---------------------------------");
	}
	
	//替换占位符的内容
	public static String getContent(Student student) throws IllegalArgumentException, IllegalAccessException{
		String content = "你好，世界；你的分数是{grade},我的分数是：{grade}";
		Class<?> c = student.getClass();
		Field [] fs = c.getDeclaredFields();
		for(Field f : fs){
			f.setAccessible(true);
			if("grade".equals(f.getName())){
				content = content.replace("{"+f.getName()+"}", f.get(student).toString());
				System.out.println("替换占位符后的内容是："+content);
			}
		}
		System.out.println("-----------------------------------------------");
		return content;
	}
	
	
}
