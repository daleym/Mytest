package com.ym.designMode.abstractFactoryPattern;

/**
 * @description 某产品实现类：cmd的CPU
 * @author ym
 */
public class CPUAmdImpl implements ICPU{
	private int size;
	
	public CPUAmdImpl(int size) {
		this.size = size;
	}
	
	@Override
	public void frequency(int size) {
		System.out.println("amd公司出产的CPU,型号是：【"+size+"】");
	}
	
	
	
}
