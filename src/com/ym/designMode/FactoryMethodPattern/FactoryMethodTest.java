package com.ym.designMode.FactoryMethodPattern;

import com.ym.designMode.staticFactoryPattern.Tiger;

/**
 * @description �������� ���ģʽ Ӧ��
 * @ע��㣺 �Ĳ��ֹ���  �� ��Ʒ���ࡢ��Ʒ�����ʵ���ࡢ������Ʒʵ����Ĺ������ࡢ������Ʒʵ����Ĺ���ʵ����
 * @eg:   ��ͨ���� ����  Transportation
 * 	               ��ͨ���� ʵ���� Metro  ��  Bus
 * 	               ������ͨ������Ļ��� IFactoryMethod
 * 	               ������ͨ���ߵ�ʵ���� MetroFactoryMethodImpl �� BusFactoryMethodImpl
 * 		  so,���ݳ��󹤳���ͬ��ʵ�����࣬�õ������򹫽��Ľ�ͨ����ʵ���࣬��ִ�ж�Ӧ��ҵ�񷽷�... ...
 * @author ym
 */
public class FactoryMethodTest {

	public static void main(String[] args) {
		new BusFactoryMethodImpl().getTransportation().gotoWork();
		new MetroFactoryMethodImpl().getTransportation().gotoWork();
	}
}
