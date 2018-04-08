package com.ym.designMode.FactoryMethodPattern;

/**
 * @description  交通工具子类 ： 公交
 * @author ym
 */
public class Bus implements Transportation{

	@Override
	public void gotoWork() {
		System.out.println("坐公交上班... ...");
	}
	
	
}
