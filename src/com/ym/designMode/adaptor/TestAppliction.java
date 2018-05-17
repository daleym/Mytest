package com.ym.designMode.adaptor;

/**
 * ������ģʽӦ�ã���������ɲ���
 * ����Ŀ����󣨽ӿڣ�ThreeElectricOutlet��������TreeElecricAdapter���������ߣ����ࣩTwoElectricOutlet
 * ע�⣺������ӵ�к�Ŀ�����һ���Ľӿڣ����Ǹı�����ӿ�ʵ�֣��Ա���ݱ������ߣ�����
 * @author Administrator
 *
 */
public class TestAppliction {

	public static void main(String[] args) {  
        ThreeElectricOutlet outlet;  //Ŀ��ӿ��������  
        Wash wash=new Wash();  
        outlet=wash;  
        System.out.println("ʹ�����������ͨ����");  
        outlet.connectElectricCurrent();  
          
        Tv tv=new Tv();  
        TreeElecricAdapter adapter=new TreeElecricAdapter(tv);  
        outlet= adapter;  
        System.out.println("ʹ�����������ͨ����");  
        outlet.connectElectricCurrent();  
    } 
	
}
