package com.ym.designMode.facadePattern;


/**
 * @description  门面模式  应用 : 医院接待员     
 * @优势 ： 提供子系统与外部客户端的专用管道（门面），屏蔽了细节，具有松耦合的作用
 * @劣势 ： 不符合开闭原则，支持扩展，不支持减少... ...(基于业务场景，不能继承门面...)
 * @eg  ： 接待员相当于门面，子系统相当于挂号、缴费、拿药，客户端相当于病人。病人只关心看病，那么可以告诉接待员，然后 接待员会引导病人 去挂号、缴费、取药的细节，而病人不必事先关心这些... ...
 * @author ym
 */
public class HospitalReceptionistFacade {
	
	private static Registration registration = new Registration();
	private static PayOff payOff = new PayOff();
	private static GetMedicine getMedicine = new GetMedicine();
	
	//看病
	public void seeDoctor(){
		//依次为 挂号、缴费、取药
		registration.register();
		payOff.payOff();
		getMedicine.getMedicine();
	}
	
}
