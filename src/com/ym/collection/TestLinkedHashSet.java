package com.ym.collection;

import java.util.LinkedHashSet;

import com.google.gson.Gson;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��8��2�� ����3:57:20 
* @description ���� �����ظ�  �ļ���  
* @usage  ʹ��HashMap��putVal ���в����
*/

public class TestLinkedHashSet {
	
	static Gson gs = new Gson();

	public static void main(String[] args) {
		LinkedHashSet<Object> lists = new LinkedHashSet<>();
		boolean result1 = lists.add(new Student("lily" , 110));
		lists.add(new Student("anan" , 111));
		lists.add(new Student("dale" , 112));
		boolean result4 = lists.add(new Student("lily" , 113));
		
		/**ִ�н����
		 * [{"name":"lily","mobile":110},{"name":"anan","mobile":111},{"name":"dale","mobile":112}]
		 */
		System.out.println(lists.toString());
	}
	
}

class Student{
	
	public String name ;
	
	public int mobile;
	
	public Student(String name , int mobile){
		this.name = name;
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", mobile=" + mobile + "]";
	}
	
	
	
}
