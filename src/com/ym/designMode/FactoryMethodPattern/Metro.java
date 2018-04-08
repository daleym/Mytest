package com.ym.designMode.FactoryMethodPattern;

/**
 * @description 具体交通工具 子类 ： 地铁
 * @author ym
 */
public class Metro implements Transportation{

	@Override
	public void gotoWork() {
		System.out.println("坐地铁上班... ...");
	}
	
}
