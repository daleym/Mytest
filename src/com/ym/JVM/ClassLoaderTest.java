package com.ym.JVM;

import java.util.List;

/**
 * ��������ļ���˳����ʾ������
 * Ӧ�ü�����->��չ������->���ļ�������C++��д��
 * @author Administrator
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args){  
        //���ClassLoaderText�������������  
        System.out.println("ClassLoaderText��ļ�����������:"+ClassLoaderTest.class.getClassLoader().getClass().getName());  
        System.out.println("System��ļ�����������:"+System.class.getClassLoader());  
        System.out.println("List��ļ�����������:"+List.class.getClassLoader());  
  
        ClassLoader cl = ClassLoaderTest.class.getClassLoader();  
        while(cl != null){  
                System.out.print(cl.getClass().getName()+"->");  
                cl = cl.getParent();  
        }  
        System.out.println(cl);
	}
	
}
