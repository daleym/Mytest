package com.ym.designMode.template;

/**
 * @description  ʵ���ࣺ�����̲�
 * @author ym
 */
public class MakeGreenTea extends ATemplateMethod{

	@Override
	protected void drewMaterial() {
		System.out.println("����������... ...");
	}

	@Override
	protected void addFoodStuff() {
		System.out.println("��ӵ����... ...");
	}

	@Override
	protected boolean ifNeed() {
		return false;
	}

}
