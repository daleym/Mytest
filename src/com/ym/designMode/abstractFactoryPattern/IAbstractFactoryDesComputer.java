package com.ym.designMode.abstractFactoryPattern;

/**
 * @description ���󹤳��ӿڣ�ָ������ĳ�ֲ�Ʒ��
 * @author ym
 */
public interface IAbstractFactoryDesComputer {
	
	//�õ�CUP
	public ICPU getCPU();
	
	//�õ��ڴ���
	public IMemoryBank getMemoryBank();
	
	//�õ�Ӳ��
	public IHardDisk getHardDisk();
}
