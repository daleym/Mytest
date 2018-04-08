package com.ym.designMode.staticFactoryPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description 静态工厂 设计模式 应用
 * @author ym
 */
public class StaticFactoryTest {
	
	
	//创建 对象实例，支持无参 和 有参
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
			
			//若构造方法的参数数量 和 参数值的数量不一致，则...
			if(paramTypeClasses.length != objects.length){
				ifThisConstructor = false;
			}
			
			//判断是否匹配到对应的构造函数
			if(ifThisConstructor){
				return constructor.newInstance(objects);
			}else{
				continue;
			}
			
		}
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Tiger tiger = (Tiger)StaticFactoryTest.getInstance("com.ym.designMode.staticFactoryPattern.Tiger", new Object []{"小老虎"});
		if(null == tiger){
			System.out.println("静态工厂实例化失败...");
		}else{
			tiger.eatingHobby();
		}
		
	}
}
