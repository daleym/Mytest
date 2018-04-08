package com.ym.designMode.abstractFactoryPattern;

/**
 * @description 某产品CPU:英特尔产的 
 * @author ym
 */
public class CPUIntelImpl implements ICPU{

	private int size;
	
	public CPUIntelImpl() {
		this.size = size;
	}
	
	@Override
	public void frequency(int size) {
		System.out.println("英特尔公司产的CPU,型号是：【"+size+"】");
	}

}
