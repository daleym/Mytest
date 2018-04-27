package com.ym.annotation;

public class Student {

	@NotAllowBlank(desc = "年龄" , value = 001 , alias = "t_age")
	private Integer age;
	 
	@NotAllowBlank(desc = "姓名" , alias = "t_name")
	private String name;
	
	@NotAllowBlank(desc = "家庭住址" , alias = "t_addr")
	public String addr;
	
	@NotAllowBlank(desc = "身份证号码" , value = 004 , alias = "t_id_card_no")
	private String idCardNo;
	
	public Student(Integer age,String name){
		this.age = age;
		this.name = name;
	}
	
	public Student(){
		super();
	}
	
}
