package com.ym.designMode.staticFactoryPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description ��̬���� ���ģʽ Ӧ��
 * @author ym
 */
public class StaticFactoryTest {
	
	
	//���� ����ʵ����֧���޲� �� �в�
	public static Object getInstance(String className,Object ...objects) throws ClassNotFoundException,InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<?> c = Class.forName(className);
		Constructor<?>[] constructors = c.getConstructors();
		for(int i = 0 ;i < constructors.length ; i++){
			Constructor<?> constructor = constructors[i];
			Class<?>[] paramTypeClasses = constructor.getParameterTypes();
			Boolean ifThisConstructor = true;
			for(int j = 0 ;j < paramTypeClasses.length ; j++){
				if(! paramTypeClasses[j].isInstance(objects[j])){
					ifThisConstructor = false;
					continue;
				}
			}
			
			//�����췽���Ĳ������� �� ����ֵ��������һ�£���...
			if(paramTypeClasses.length != objects.length){
				ifThisConstructor = false;
			}
			
			//�ж��Ƿ�ƥ�䵽��Ӧ�Ĺ��캯��
			if(ifThisConstructor){
				return constructor.newInstance(objects);
			}else{
				continue;
			}
			
		}
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Tiger tiger = (Tiger)StaticFactoryTest.getInstance("com.ym.designMode.staticFactoryPattern.Tiger", new Object []{"С�ϻ�"});
		if(null == tiger){
			System.out.println("��̬����ʵ����ʧ��...");
		}else{
			tiger.eatingHobby();
		}
		
	}
}
