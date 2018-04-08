package com.ym.designMode.abstractFactoryPattern;

/**
 * @description AAA���Ʒ�� �����󹤳���ʵ����
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
