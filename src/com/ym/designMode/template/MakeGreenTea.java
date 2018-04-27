package com.ym.designMode.template;

/**
 * @description  实现类：制作绿茶
 * @author ym
 */
public class MakeGreenTea extends ATemplateMethod{

	@Override
	protected void drewMaterial() {
		System.out.println("加入铁观音... ...");
	}

	@Override
	protected void addFoodStuff() {
		System.out.println("添加点枸杞... ...");
	}

	@Override
	protected boolean ifNeed() {
		return false;
	}

}
