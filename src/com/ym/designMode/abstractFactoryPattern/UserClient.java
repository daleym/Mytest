package com.ym.designMode.abstractFactoryPattern;

/**
 * @description 用户客户端  （抽象工厂的应用）
 * @author ym
 * @优势：客户端与系统实现类解耦，只关注接口类或抽象类，不用理会实现类
 * @劣势：添加接口或抽象类功能，则不便于扩展，因为所有实现类 要同步 修改！
 * @特点： 接口实现分离，客户端不关注实现
 */
public class UserClient {
	
	public static void main(String[] args) {
		IAbstractFactoryDesComputer abstractFactoryDesComputer = new AAASpeciesDesComputer();
		ICPU cpu = abstractFactoryDesComputer.getCPU();
		cpu.frequency(888);
	}
	
}
