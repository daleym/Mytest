package com.ym.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ym.entity.Student;

/**
 * ����
 * @author ym
 *
 */
public class TestDemo {
	
	public static void main(String[] args) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		
		Scanner scanner = null ;
		for(int i=0 ;i<100;i++){
			scanner = new Scanner(System.in);
			System.out.println("����������...");
			String inputStr = scanner.next();
			System.out.println("���յ�����������Ϊ��"+inputStr);
			
			getSuperClass(inputStr);
			getFields(inputStr);
			getMethods(inputStr);
			
			
			getContent(new Student("100"));
		}
		
		scanner.close();
	}
	
	//�õ������������
	public static void getSuperClass(String inputStr) throws ClassNotFoundException{
		Class<?> myClass  = Class.forName(inputStr);
		Class<?> superClass = myClass.getSuperclass();
		System.out.println("��Ӧ�ĸ�������Ϊ��"+superClass.getName());
		System.out.println("---------------------------------");
	}
	
	//�õ���Ա��������
	public static void getFields(String inputStr) throws ClassNotFoundException{
		Class<?> myClass  =Class.forName(inputStr);
		
		Field [] fields = myClass.getDeclaredFields();
		for(Field f: fields){
			String type = f.getType().getName();
			System.out.println("��Ӧ�ĳ�Ա�������ƣ�"+f.getName()+"�����ͣ�"+type);
		}
		System.out.println("---------------------------------");
	}
	
	//�õ���Ա����
	public static void getMethods(String inputStr) throws ClassNotFoundException{
		Class<?> myclass = Class.forName(inputStr);
		
		Method [] methods = myclass.getDeclaredMethods();
		for(Method method : methods){
			String modifier = Modifier.toString(method.getModifiers());
			String returnType = method.getReturnType().getName();
			System.out.println("��Ӧ�ĳ�Ա�������ƣ�"+method.getName()+",���η���"+modifier+",�������ͣ�"+returnType);
		}
		System.out.println("---------------------------------");
	}
	
	//�滻ռλ��������
	public static String getContent(Student student) throws IllegalArgumentException, IllegalAccessException{
		String content = "��ã����磻��ķ�����{grade},�ҵķ����ǣ�{grade}";
		Class<?> c = student.getClass();
		Field [] fs = c.getDeclaredFields();
		for(Field f : fs){
			f.setAccessible(true);
			if("grade".equals(f.getName())){
				content = content.replace("{"+f.getName()+"}", f.get(student).toString());
				System.out.println("�滻ռλ����������ǣ�"+content);
			}
		}
		System.out.println("-----------------------------------------------");
		return content;
	}
	
	
}
