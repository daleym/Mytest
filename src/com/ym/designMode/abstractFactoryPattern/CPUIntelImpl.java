package com.ym.designMode.abstractFactoryPattern;

/**
 * @description ĳ��ƷCPU:Ӣ�ض����� 
 * @author ym
 */
public class CPUIntelImpl implements ICPU{

	private int size;
	
	public CPUIntelImpl() {
		this.size = size;
	}
	
	@Override
	public void frequency(int size) {
		System.out.println("Ӣ�ض���˾����CPU,�ͺ��ǣ���"+size+"��");
	}

}
