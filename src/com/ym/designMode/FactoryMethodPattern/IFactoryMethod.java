package com.ym.designMode.FactoryMethodPattern;

/**
 * @description 抽象工厂 接口基类 
 * @author ym
 */
public interface IFactoryMethod {
	
	// 得到交通工具类
	public Transportation getTransportation();
}
