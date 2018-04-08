package com.ym.designMode.decorator;

/**
 * 裝飾者模式：对外部调用者无感知，临时增加了一些功能
 * @author Administrator
 *
 */
public class DecoratorDemo {

	public static void main(String[] args) {
		GuoDi  guodi = new YuanYang() ;//点个大龙燚火锅原味锅底
		guodi = new MaLaNiuRou(guodi);//来个麻辣牛肉
		guodi = new MaoDu(guodi);//在麻辣牛肉的基础上再来个大刀毛肚
        System.out.println("一共点了"+guodi.name()+",共消费"+guodi.cost());
	}
	
}
