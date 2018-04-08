package com.ym.designMode.staticFactoryPattern;

/**
 * @description 特征抽象类 ：动物
 * @author ym
 *
 */
public abstract class Animal {
	
	//名字
	public String name ;
	
	public Animal(String name ){
		super();
		this.name = name;
	}
	
	//吃的动作
	public abstract void eatingHobby();
}
