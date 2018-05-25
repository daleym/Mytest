package com.ym.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add(0 , "1" );
		list1.add(0,  "2");
		System.out.println(list1);
		
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
	}
	
}
