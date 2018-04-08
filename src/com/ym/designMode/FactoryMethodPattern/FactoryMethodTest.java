package com.ym.designMode.FactoryMethodPattern;

import com.ym.designMode.staticFactoryPattern.Tiger;

/**
 * @description 工厂方法 设计模式 应用
 * @注意点： 四部分构成  ： 产品基类、产品具体的实现类、产生产品实现类的工厂基类、产生产品实现类的工厂实现类
 * @eg:   交通工具 基类  Transportation
 * 	               交通工具 实现类 Metro  、  Bus
 * 	               产生交通工具类的基类 IFactoryMethod
 * 	               产生交通工具的实现类 MetroFactoryMethodImpl 、 BusFactoryMethodImpl
 * 		  so,根据抽象工厂不同的实现子类，得到地铁或公交的交通工具实现类，则执行对应的业务方法... ...
 * @author ym
 */
public class FactoryMethodTest {

	public static void main(String[] args) {
		new BusFactoryMethodImpl().getTransportation().gotoWork();
		new MetroFactoryMethodImpl().getTransportation().gotoWork();
	}
}
