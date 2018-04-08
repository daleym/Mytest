package com.ym.designMode.abstractFactoryPattern;

/**
 * @description �û��ͻ���  �����󹤳���Ӧ�ã�
 * @author ym
 * @���ƣ��ͻ�����ϵͳʵ������ֻ��ע�ӿ��������࣬�������ʵ����
 * @���ƣ���ӽӿڻ�����๦�ܣ��򲻱�����չ����Ϊ����ʵ���� Ҫͬ�� �޸ģ�
 * @�ص㣺 �ӿ�ʵ�ַ��룬�ͻ��˲���עʵ��
 */
public class UserClient {
	
	public static void main(String[] args) {
		IAbstractFactoryDesComputer abstractFactoryDesComputer = new AAASpeciesDesComputer();
		ICPU cpu = abstractFactoryDesComputer.getCPU();
		cpu.frequency(888);
	}
	
}
