package com.ym.designMode.decorator;

/**
 * 裝飾者模式应用：对外部调用者无感知，临时增加了一些功能
 * 四个要素：被装饰目标对象GuoDi、被装饰目标对象实现类YuanYang、装饰者（抽象类）GuoDi、装饰者子类MaLaNiuRou
 * eg:装饰者实现了被装饰目标对象接口，并且组合或聚合了被装饰接口。动态的扩展实现的内容！！！
 * @author Administrator
 *
 */
public class TestDecorator {

	public static void main(String[] args) {
		GuoDi  guodi = new YuanYang() ;//点个大龙燚火锅原味锅底
		guodi = new MaLaNiuRou(guodi);//来个麻辣牛肉
		guodi = new MaoDu(guodi);//在麻辣牛肉的基础上再来个大刀毛肚
        System.out.println("一共点了"+guodi.name()+",共消费"+guodi.cost());
	}
	
}
