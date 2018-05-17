package com.ym.designMode.adaptor;

/**
 * 适配器模式应用：有三个组成部分
 * 调用目标对象（接口）ThreeElectricOutlet、适配者TreeElecricAdapter、被适配者（子类）TwoElectricOutlet
 * 注意：适配者拥有和目标对象一样的接口，但是改变了其接口实现，以便兼容被适配者！！！
 * @author Administrator
 *
 */
public class TestAppliction {

	public static void main(String[] args) {  
        ThreeElectricOutlet outlet;  //目标接口三相插座  
        Wash wash=new Wash();  
        outlet=wash;  
        System.out.println("使用三相插座接通电流");  
        outlet.connectElectricCurrent();  
          
        Tv tv=new Tv();  
        TreeElecricAdapter adapter=new TreeElecricAdapter(tv);  
        outlet= adapter;  
        System.out.println("使用三相插座接通电流");  
        outlet.connectElectricCurrent();  
    } 
	
}
