package com.ym.collection;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Administrator
 * @description ������ظ�  ArrayList
 */
public class TestArrayList {
	
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add(0 , "1" );
		list1.add(0,  "2");
		System.out.println(list1);//�����±� ����������
		
		List<String> list2 = new ArrayList<>();
		list2.add(0, "0");
		list2.set(0 , "1" );
		list2.set(0,  "2");
		System.out.println(list2);
		
		List<String > list3 = new ArrayList<>();
		list3.add("dale");
		list3.add("lily");
		list3.add("lily");
		System.out.println(list3);
		
		//�ᷢ���쳣������Խ�磩��sizeΪ�㣬��ô�ж��±�>sizeʱ�������쳣~~~
		List<String> initLists = new ArrayList<>(10);
		initLists.set(1 , "lily");
	}
	
}
