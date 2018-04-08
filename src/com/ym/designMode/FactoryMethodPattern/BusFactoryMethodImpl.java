package com.ym.designMode.FactoryMethodPattern;


/**
 * @description �������� ʵ���� �� ������� ���� ������
 * @author ym
 */
public class BusFactoryMethodImpl implements IFactoryMethod{

	@Override
	public Transportation getTransportation() {
		return new Bus();
	}
	
	
	
}
