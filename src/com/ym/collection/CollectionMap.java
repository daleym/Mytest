package com.ym.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流式数据处理应用 jdk8
 * @author Administrator
 *
 */
public class CollectionMap {
	
	private static  class Student{
		private long  age;
		
		public Student(long age){
			super();
			this.age = age;
		}
		
		public long getAge(){
			return this.age;
		}
	}
	
	

	public static void main(String[] args) {
		List<Student> students = new ArrayList();
		students.add(new Student(18L));
		students.add(new Student(28L));
		long result = students.stream().collect(Collectors.summingLong(Student :: getAge));
		System.out.println(result);
		
		System.out.println("OnePlus ONEPLUS A5010".length());
		
 	}
}
