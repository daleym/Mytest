package com.ym.designMode.staticFactoryPattern;

/**
 * @description �ϻ�
 * @author ym
 *
 */
public class Tiger extends Animal implements FemaleBehavior {
	
	private Integer age;
	
	public Tiger(String name){
		super(name);
		if(null == this.age){
			this.age = 999999;//�����
		}
	}
	
	public Tiger(String name ,Integer age){
		super(name);
		this.age = age;
		if(this.age == null){
			this.age = 999999;//�����
		}
	}

	@Override
	public void eatingHobby() {
		System.out.println( "��"+name+"��ϲ����¹,���У����䣺��"+age+"��... ...");
	}

	@Override
	public void giveBirth() {
		System.out.println("�ϻ���������"+name+"��... ...");
	}
	
}
