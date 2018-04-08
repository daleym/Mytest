package com.ym.designMode.staticFactoryPattern;

/**
 * @description 老虎
 * @author ym
 *
 */
public class Tiger extends Animal implements FemaleBehavior {
	
	private Integer age;
	
	public Tiger(String name){
		super(name);
		if(null == this.age){
			this.age = 999999;//无穷大
		}
	}
	
	public Tiger(String name ,Integer age){
		super(name);
		this.age = age;
		if(this.age == null){
			this.age = 999999;//无穷大
		}
	}

	@Override
	public void eatingHobby() {
		System.out.println( "【"+name+"】喜欢吃鹿,其中，年龄：【"+age+"】... ...");
	}

	@Override
	public void giveBirth() {
		System.out.println("老虎可以生【"+name+"】... ...");
	}
	
}
