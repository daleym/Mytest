package com.ym.entity;

public class Student extends People {
	
	private String grade;
	
	public Student(String grade){
		this.grade = grade;
	}
	
	public Student(){
		super();
	}
	
	private String getGrade(){
		return this.grade;
	}
	
	public void setGrade(String grade){
		this.grade = grade;
	}
	
	public static  boolean ifSameClass(Object obj1){
		return obj1 instanceof Student;
	}
	
	public static void main(String[] args) {
		System.out.println(ifSameClass(new Student()));
		System.out.println(ifSameClass(new People()));
		System.out.println(ifSameClass(null));
	}
	
}
