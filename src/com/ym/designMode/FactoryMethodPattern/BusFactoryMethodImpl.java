package com.ym.designMode.FactoryMethodPattern;


/**
 * @description 工厂方法 实现类 ： 具体产生 公交 工具类
 * @author ym
 */
public class BusFactoryMethodImpl implements IFactoryMethod{

	@Override
	public Transportation getTransportation() {
		return new Bus();
	}
	
	
	
}
