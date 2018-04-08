package com.ym.designMode.facadePattern;

/**
 * @description 门面模式的 客户端    : 看病
 * @author ym
 */
public class FacadeClient {
	
	private static HospitalReceptionistFacade hospitalReceptionistFacade = new HospitalReceptionistFacade();
	
	public static void main(String[] args) {
		hospitalReceptionistFacade.seeDoctor();
	}
	
}
