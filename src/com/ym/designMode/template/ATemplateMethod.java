package com.ym.designMode.template;

/**
 * @description : 模板方法 设计模式应用
 * @author ym
 * @优势：符合开闭原则，扩展性好，如果要增加场景，直接增加一个实现类即可
 * @eg: 设计一个通用的入口基类 ATemplateMethod,然后根据其中非通用的模块，让子类（MakeCoffee、MakeGreenTea）去实现即可。
 * @注意：可添加控制开关（ifNeed）,来选择非通用模块，对于子类是否需要。
 */
public abstract class  ATemplateMethod {
	
	public final void makeDrink(){
		//1.烧水
		this.heatUpWater();
		//2.冲泡茶料
		this.drewMaterial();
		//3.倒入杯中
		this.pourIntoCup();
		//4.添加食料
		if(this.ifNeed()){
			this.addFoodStuff();
		}
		
	}
	
	//烧水
	private void heatUpWater(){
		System.out.println("烧水... ... ");
	}
	
	//冲泡茶料
	protected abstract void drewMaterial();
	
	//倒入杯中
	private void pourIntoCup(){
		System.out.println("倒入杯中... ...");
	}
	
	//添加食料
	protected abstract void addFoodStuff();
	
	//开关
	protected abstract boolean ifNeed();
	
	public static void main(String[] args) {
		ATemplateMethod aTemplateMethod = new MakeGreenTea();
		ATemplateMethod aTemplateMethod2 = new MakeCoffee();
		aTemplateMethod.makeDrink();
		System.out.println("*************************");
		aTemplateMethod2.makeDrink();
	}
}
