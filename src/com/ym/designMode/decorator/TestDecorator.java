package com.ym.designMode.decorator;

/**
 * �b���ģʽӦ�ã����ⲿ�������޸�֪����ʱ������һЩ����
 * �ĸ�Ҫ�أ���װ��Ŀ�����GuoDi����װ��Ŀ�����ʵ����YuanYang��װ���ߣ������ࣩGuoDi��װ��������MaLaNiuRou
 * eg:װ����ʵ���˱�װ��Ŀ�����ӿڣ�������ϻ�ۺ��˱�װ�νӿڡ���̬����չʵ�ֵ����ݣ�����
 * @author Administrator
 *
 */
public class TestDecorator {

	public static void main(String[] args) {
		GuoDi  guodi = new YuanYang() ;//��������D���ԭζ����
		guodi = new MaLaNiuRou(guodi);//��������ţ��
		guodi = new MaoDu(guodi);//������ţ��Ļ�������������ë��
        System.out.println("һ������"+guodi.name()+",������"+guodi.cost());
	}
	
}
