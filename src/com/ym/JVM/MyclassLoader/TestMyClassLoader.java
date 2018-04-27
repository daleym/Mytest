package com.ym.JVM.MyclassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义加载器：
 * @author Administrator
 * eg:在F:\\lib路径下，寻找包名与类名（com.ym.jvm.classLoaderNew.Test）下的class字节流文件
 *    并由自定义类加载器MyClassLoader，加载到内存，并调用say方法！！！
 *    若包名与类名，在其他地方存在，会被应用类加载器优先加载！！！
 *    eg:com.ym.jvm.classLoaderNew.Test->com.ym.jvm.classLoader.Test,就会由应用器加载器加载！！！
 *
 */
public class TestMyClassLoader {

	public static void main(String []args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
        //自定义类加载器的加载路径
        MyClassLoader myClassLoader=new MyClassLoader("F:\\lib");
        //包名+类名
        Class c=myClassLoader.loadClass("com.ym.jvm.classLoaderNew.Test");
        
        if(c!=null){
            Object obj=c.newInstance();
            Method method=c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
	
}
