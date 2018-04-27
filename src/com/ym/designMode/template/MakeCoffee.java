package com.ym.designMode.template;

/**
 * @description  实现类：制作咖啡
 * @author ym
 */
public class MakeCoffee extends ATemplateMethod{

	@Override
	protected void drewMaterial() {
		System.out.println("添加可可豆... ...");
	}

	@Override
	protected void addFoodStuff() {
		System.out.println("添加点糖... ...");
	}

	@Override
	protected boolean ifNeed() {
		return true;
	}

	
	
}
