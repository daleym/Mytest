package com.ym.JVM;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest1 {

	public static void main(String[] args) throws Exception {
        // �Զ����������
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(fileName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);   
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        // ʹ��ClassLoaderTest������������ر���
        Object obj1 = ClassLoaderTest1.class.getClassLoader().loadClass("com.ym.JVM.ClassLoaderTest1").newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof com.ym.JVM.ClassLoaderTest1);

        // ʹ���Զ�������������ر���
        Object obj2 = myLoader.loadClass("com.ym.JVM.ClassLoaderTest1").newInstance();
        System.out.println(obj2.getClass());
        System.out.println(obj2 instanceof com.ym.JVM.ClassLoaderTest1);
    }
	
}
