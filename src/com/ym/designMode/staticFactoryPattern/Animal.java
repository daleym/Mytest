package com.ym.designMode.staticFactoryPattern;

/**
 * @description ���������� ������
 * @author ym
 *
 */
public abstract class Animal {
	
	//����
	public String name ;
	
	public Animal(String name ){
		super();
		this.name = name;
	}
	
	//�ԵĶ���
	public abstract void eatingHobby();
}
