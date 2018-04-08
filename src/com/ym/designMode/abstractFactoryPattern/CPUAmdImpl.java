package com.ym.designMode.abstractFactoryPattern;

/**
 * @description ĳ��Ʒʵ���ࣺcmd��CPU
 * @author ym
 */
public class CPUAmdImpl implements ICPU{
	private int size;
	
	public CPUAmdImpl(int size) {
		this.size = size;
	}
	
	@Override
	public void frequency(int size) {
		System.out.println("amd��˾������CPU,�ͺ��ǣ���"+size+"��");
	}
	
	
	
}
