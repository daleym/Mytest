package com.ym.designMode.adaptor;

/**
 * 目标对象的实现类
 * @author Administrator
 *
 */
public class Wash implements ThreeElectricOutlet {

	 private String name;  
	    public Wash() {  
	        name="洗衣机";  
	    }  
	    public Wash(String name){  
	        this.name=name;  
	    }  
	    @Override  
	    public void connectElectricCurrent() {  
	        turnOn();  
	    }  
	    private void turnOn(){  
	        System.out.println(name+"开始洗衣服");  
	    } 

}
