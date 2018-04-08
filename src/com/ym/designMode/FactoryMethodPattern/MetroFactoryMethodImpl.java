package com.ym.designMode.FactoryMethodPattern;

/**
 * @description �������� ʵ����  �� �����������������
 * @author ym
 */
public class MetroFactoryMethodImpl implements IFactoryMethod{

	@Override
	public Transportation getTransportation() {
		return new Metro();
	}

}
