package com.ym.designMode.adaptor;

public abstract class  DemoAbstract implements DemoInterface{
	public int i = 8;
	public DemoAbstract(){System.out.println("抽象类初始化...");}
	
	public void push(){};
	
	public void pull(){};
	
	public  void get(){};

}
