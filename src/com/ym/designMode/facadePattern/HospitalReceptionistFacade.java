package com.ym.designMode.facadePattern;


/**
 * @description  ����ģʽ  Ӧ�� : ҽԺ�Ӵ�Ա     
 * @���� �� �ṩ��ϵͳ���ⲿ�ͻ��˵�ר�ùܵ������棩��������ϸ�ڣ���������ϵ�����
 * @���� �� �����Ͽ���ԭ��֧����չ����֧�ּ���... ...(����ҵ�񳡾������ܼ̳�����...)
 * @eg  �� �Ӵ�Ա�൱�����棬��ϵͳ�൱�ڹҺš��ɷѡ���ҩ���ͻ����൱�ڲ��ˡ�����ֻ���Ŀ�������ô���Ը��߽Ӵ�Ա��Ȼ�� �Ӵ�Ա���������� ȥ�Һš��ɷѡ�ȡҩ��ϸ�ڣ������˲������ȹ�����Щ... ...
 * @author ym
 */
public class HospitalReceptionistFacade {
	
	private static Registration registration = new Registration();
	private static PayOff payOff = new PayOff();
	private static GetMedicine getMedicine = new GetMedicine();
	
	//����
	public void seeDoctor(){
		//����Ϊ �Һš��ɷѡ�ȡҩ
		registration.register();
		payOff.payOff();
		getMedicine.getMedicine();
	}
	
}
