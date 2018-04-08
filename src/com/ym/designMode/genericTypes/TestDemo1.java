package com.ym.designMode.genericTypes;

/**
 * @description ���ͻ���ʹ��
 * @author ym
 * @ע�⣺ T �൱�� Object�����Դ�����������
 * @eg:�紫������ 66,�����66�������ַ�����hello-world�����������hello-world��... ...
 */
public class TestDemo1<T> {
	
	private T obj;
	
	public TestDemo1(T obj){
		this.obj = obj;
	}
	
	@Override
	public String toString(){
		return obj.toString();
	}
	
	//�õ������������
	public String getClassName(){
		return obj.getClass().getName();
	}
	
	public static void main(String[] args) {
		System.out.println("����Integer 66,���ж���ֵ����"+new TestDemo1<Integer>(66)+"���������ƣ���"+new TestDemo1<Integer>(66).getClassName()+"��");
		System.out.println("����String hello-world,���ж���ֵ����"+new TestDemo1<String>("hello-world")+"���������ƣ���"+new TestDemo1<String>("hello-world").getClassName()+"��");
	}
	
}
