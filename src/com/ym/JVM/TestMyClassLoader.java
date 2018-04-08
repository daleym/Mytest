package com.ym.JVM;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyClassLoader {

	public static void main(String []args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
        //�Զ�����������ļ���·��
        MyClassLoader myClassLoader=new MyClassLoader("E:\\");
        //����+����
        Class c=myClassLoader.loadClass("com.ym.JVM.MyClassLoader");
        
        if(c!=null){
            Object obj=c.newInstance();
            Method method=c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
	
}
