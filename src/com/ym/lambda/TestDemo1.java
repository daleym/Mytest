package com.ym.lambda;

/**
 * 
 * @author Administrator
 * @desc ��() - > {}�� ȡ����������
 * 	     ע����run�������в�������������д����"(a,b) -> {a+b}"
 * 	  ���ܣ�  1.��() - > {}�� ȡ����������
 * 		     ע����run�������в�������������д����"(a,b) -> {a+b}"
 *        2.lambda���Խ���б�ѭ��ʹ��
 *        3.����stream�����lambda����Ԫ��
 * 		      ע��"() -> ���ʽ"  eg: "(m) -> m+m"
 *        4.����stream�����lambda����Ԫ��(Predicate)
 * 		      ע��"() -> ���ʽ"  eg: "(m) -> m+m"
 *        5.����stream�����lambda����Ԫ��(֧�ֶ���Predicateɸѡ����)
 */
public class TestDemo1 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(" hello!");
			}
		}).start();
		
		new Thread(() -> {System.out.println("lambda hello!");}).start();
	}
}
