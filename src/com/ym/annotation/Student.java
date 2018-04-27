package com.ym.annotation;

public class Student {

	@NotAllowBlank(desc = "����" , value = 001 , alias = "t_age")
	private Integer age;
	 
	@NotAllowBlank(desc = "����" , alias = "t_name")
	private String name;
	
	@NotAllowBlank(desc = "��ͥסַ" , alias = "t_addr")
	public String addr;
	
	@NotAllowBlank(desc = "���֤����" , value = 004 , alias = "t_id_card_no")
	private String idCardNo;
	
	public Student(Integer age,String name){
		this.age = age;
		this.name = name;
	}
	
	public Student(){
		super();
	}
	
}
