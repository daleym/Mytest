package com.ym.designMode.template;

/**
 * @description : ģ�巽�� ���ģʽӦ��
 * @author ym
 * @���ƣ����Ͽ���ԭ����չ�Ժã����Ҫ���ӳ�����ֱ������һ��ʵ���༴��
 * @eg: ���һ��ͨ�õ���ڻ��� ATemplateMethod,Ȼ��������з�ͨ�õ�ģ�飬�����ࣨMakeCoffee��MakeGreenTea��ȥʵ�ּ��ɡ�
 * @ע�⣺����ӿ��ƿ��أ�ifNeed��,��ѡ���ͨ��ģ�飬���������Ƿ���Ҫ��
 */
public abstract class  ATemplateMethod {
	
	public final void makeDrink(){
		//1.��ˮ
		this.heatUpWater();
		//2.���ݲ���
		this.drewMaterial();
		//3.���뱭��
		this.pourIntoCup();
		//4.���ʳ��
		if(this.ifNeed()){
			this.addFoodStuff();
		}
		
	}
	
	//��ˮ
	private void heatUpWater(){
		System.out.println("��ˮ... ... ");
	}
	
	//���ݲ���
	protected abstract void drewMaterial();
	
	//���뱭��
	private void pourIntoCup(){
		System.out.println("���뱭��... ...");
	}
	
	//���ʳ��
	protected abstract void addFoodStuff();
	
	//����
	protected abstract boolean ifNeed();
	
	public static void main(String[] args) {
		ATemplateMethod aTemplateMethod = new MakeGreenTea();
		ATemplateMethod aTemplateMethod2 = new MakeCoffee();
		aTemplateMethod.makeDrink();
		System.out.println("*************************");
		aTemplateMethod2.makeDrink();
	}
}
