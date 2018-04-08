package com.ym.designMode.abstractFactoryPattern;

/**
 * @description 抽象工厂接口，指定产生某种产品族
 * @author ym
 */
public interface IAbstractFactoryDesComputer {
	
	//得到CUP
	public ICPU getCPU();
	
	//得到内存条
	public IMemoryBank getMemoryBank();
	
	//得到硬盘
	public IHardDisk getHardDisk();
}
