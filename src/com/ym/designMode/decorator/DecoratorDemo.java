package com.ym.designMode.decorator;

/**
 * �b���ģʽ�����ⲿ�������޸�֪����ʱ������һЩ����
 * @author Administrator
 *
 */
public class DecoratorDemo {

	public static void main(String[] args) {
		GuoDi  guodi = new YuanYang() ;//��������D���ԭζ����
		guodi = new MaLaNiuRou(guodi);//��������ţ��
		guodi = new MaoDu(guodi);//������ţ��Ļ�������������ë��
        System.out.println("һ������"+guodi.name()+",������"+guodi.cost());
	}
	
}
