package com.ym.JVM;

/**
 * JVM��̬�󶨺;�̬�󶨣���̬�󶨽���Զ���ʵ���ķ�������ͨ�����;�̬�����Լ���̬�����ڱ����ھ�ȷ���˺���Ĺ�ϵ������
 * eg�����ʳ�Ա����ʱ������Father���ڵı��������ʷǾ�̬��Ա����ʱ������ʵ������ķ�����
 * @author Administrator
 *
 */
public class TestDynamicAndStaticBinding {
	public static void main(String[] args) {
		Father father = new Son();
		System.out.println(father.getName());
		System.out.println(father.name);
		System.out.println(father.age);
		System.out.println(Father.getAge());
	}
}
