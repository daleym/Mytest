package com.ym.designMode.facadePattern;

/**
 * @description ����ģʽ�� �ͻ���    : ����
 * @author ym
 */
public class FacadeClient {
	
	private static HospitalReceptionistFacade hospitalReceptionistFacade = new HospitalReceptionistFacade();
	
	public static void main(String[] args) {
		hospitalReceptionistFacade.seeDoctor();
	}
	
}
