package com.ym.designMode.template;

/**
 * @description  ʵ���ࣺ��������
 * @author ym
 */
public class MakeCoffee extends ATemplateMethod{

	@Override
	protected void drewMaterial() {
		System.out.println("��ӿɿɶ�... ...");
	}

	@Override
	protected void addFoodStuff() {
		System.out.println("��ӵ���... ...");
	}

	@Override
	protected boolean ifNeed() {
		return true;
	}

	
	
}
