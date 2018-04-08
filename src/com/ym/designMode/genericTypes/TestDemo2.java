package com.ym.designMode.genericTypes;

import java.awt.List;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.ArrayList;

/**
 * @description ���ͽ��� ʹ�� ,ָ��ĳЩ���͵Ķ���  
 * @author ym
 * @ע�⣺�Զ��巺��(T)��ͨ������ͣ�?��������������  �����߿ɴ��������ַ�
 */
public class TestDemo2<T extends AbstractList> {

	private T obj;
	
	public TestDemo2(T obj){
		this.obj = obj;
	}
	
	//���ͷ���
	public <T> Field [] getMemberVar(T obj){
		return obj.getClass().getDeclaredFields();
	}
	
	@Override
	public String toString(){
		return obj.getClass().getName();
	}
	
	public static void main(String[] args) {
//		TestDemo2<MetroBean> testDemo2 = new TestDemo2<MetroBean>(new MetroBean());
		TestDemo2<ArrayList> testDemo2 = new TestDemo2<ArrayList>(new ArrayList());
		System.out.println( testDemo2 + "," + testDemo2.getMemberVar(new MetroBean()));
	}
}

class MetroBean extends List implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6751434101633974606L;
	
	private String name;
	private Integer age;
	
}
