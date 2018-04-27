package com.ym.entity;

import com.ym.compare.User;

public class People {
	
	public Double height;
	public Double weight;
	
	public People(){
		height = 1.70D;
		weight = 130D;
	}
	
	public People(Double height , Double weight){
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public String toString(){
		return "height:"+this.height+",weight:"+this.weight;
	}
	
	public static boolean ifSameClass(Object obj){
		return obj instanceof People;
	}
	
	public static void main(String[] args) {
		System.out.println(ifSameClass(new Student()));
		System.out.println(ifSameClass(new People()));
		System.out.println(ifSameClass(new Object()));
		
		/***
		 * 验证：对象A被对象B赋值后，对象A原有的成员值，会被覆盖！！！
		 */
		People people = new People();
		people.height = 1D;
		people.weight = 2D;
		System.out.println(String.format("原始的people对象【%s】", people));
		people = packagePeople();
		System.out.println(String.format("最新的people对象【%s】", people));
		
	}
	
	private static People packagePeople(){
		People people = new People();
		people.height = 3D;
//		people.weight = 4D;
		return people;
	}
}
