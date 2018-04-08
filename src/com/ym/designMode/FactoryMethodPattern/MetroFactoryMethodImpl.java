package com.ym.designMode.FactoryMethodPattern;

/**
 * @description 工厂方法 实现类  ： 具体产生地铁工具类
 * @author ym
 */
public class MetroFactoryMethodImpl implements IFactoryMethod{

	@Override
	public Transportation getTransportation() {
		return new Metro();
	}

}
