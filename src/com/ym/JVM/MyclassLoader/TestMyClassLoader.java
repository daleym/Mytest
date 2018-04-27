package com.ym.JVM.MyclassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * �Զ����������
 * @author Administrator
 * eg:��F:\\lib·���£�Ѱ�Ұ�����������com.ym.jvm.classLoaderNew.Test���µ�class�ֽ����ļ�
 *    �����Զ����������MyClassLoader�����ص��ڴ棬������say����������
 *    ���������������������ط����ڣ��ᱻӦ������������ȼ��أ�����
 *    eg:com.ym.jvm.classLoaderNew.Test->com.ym.jvm.classLoader.Test,�ͻ���Ӧ�������������أ�����
 *
 */
public class TestMyClassLoader {

	public static void main(String []args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
        //�Զ�����������ļ���·��
        MyClassLoader myClassLoader=new MyClassLoader("F:\\lib");
        //����+����
        Class c=myClassLoader.loadClass("com.ym.jvm.classLoaderNew.Test");
        
        if(c!=null){
            Object obj=c.newInstance();
            Method method=c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
	
}
