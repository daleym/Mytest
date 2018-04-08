package com.ym.designMode.abstractFactoryPattern;

/**
 * @description AAA类产品族 ：抽象工厂的实现类
 * @author ym
 */
public class AAASpeciesDesComputer implements IAbstractFactoryDesComputer{

	@Override
	public ICPU getCPU() {
		return new CPUAmdImpl(666);
	}

	@Override
	public IMemoryBank getMemoryBank() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IHardDisk getHardDisk() {
		// TODO Auto-generated method stub
		return null;
	}

}
