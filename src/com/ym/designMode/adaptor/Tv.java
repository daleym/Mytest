package com.ym.designMode.adaptor;

/**
 * 被适配对象的实现类
 * @author Administrator
 *
 */
public class Tv implements TwoElectricOutlet {

	private String name;  
    public Tv() {  
        name="长江电视机";  
    }  
    public Tv(String s){  
        this.name=s;  
    }  
      
    @Override  
    public void connectElectricCurrent() {  
        turnOn();  
    }  
    private void turnOn(){  
        System.out.println(name+"开始播放节目");  
    } 

}
