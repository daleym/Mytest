package com.ym.shiftOperator;

/**
 * @description  "��λ�����"��Ӧ��
 * 1.����λ�������
 * a.���壺<< ,һ��long���͵���ֵ�������ƶ�nλ����ô�൱�ڳ�����2 ^n
 * b.eg:��2�Ķ�������10����ô2<<3 ��,��������10000,->16
 * 
 * 2.��λ�������			             
 * a.���壺&,��һ��long���͵���ֵa������ֵb��&��������ôĳһλͬʱΪ1����Ϊ1������Ϊ0
 * b.eg:��2 & 6�������Ʒֱ��� 10��110������Ϊ010,->2
 * 						       
 * 3.��λ�������						   
 * a.���壺|,��һ��long���͵���ֵa,����ֵb��|��������ôĳһλ����1����Ϊ1������Ϊ0
 * b.eg:��2 | 6�������Ʒֱ�Ϊ10��110������Ϊ110,->6
 * 
 * 4.��������
 * a.���壺^,��һ��long���͵���ֵa,����ֵb��^��������ôֻ��һλ����1����Ϊ1������Ϊ0
 * b.eg:��2^6,�����Ʒֱ�Ϊ10,110������Ϊ100��->4		
 * 
 * 5.�޷������������>>>
 * a.���壺>>>,һ��long���͵���ֵ�������ƶ�Nλ����ô�൱�ڳ�����2^n,��߿�λ��0����
 * 
 * 
 * 6.���������������>>
 * a.���壺>>,һ��long���͵���ֵ�������ƶ�Nλ����ô�൱�ڳ�����2^n,��߿�λ�÷���λ��������1��������0������
 * 
 */
public class TestShiftOperator {
	
	public static void main(String[] args) {
		long number1   = 2L;
		long moveCount = 3L;
		
		//����λ����� <<  start
		outPutNumber1(253);
		outPutNumber1(253 << moveCount);//�����ƶ�һλ
		//����λ����� <<  end
		
		//��λ�����  &   start
		outPutNumber2(2 , 6);
		outPutNumber2(2 , 3);
		outPutNumber2(2 , 2);
		//��λ�����  &   end
		
		//��λ�����  |   start
		outPutNumber3(2 , 6);
		outPutNumber3(2 , 3);
		outPutNumber3(2 , 2);
		//��λ�����  |   end
		
		//�������� ^ start
		outPutNumber4(2, 6);
		outPutNumber4(2, 3);
		outPutNumber4(2, 2);
		//�������� ^ end
		
		//�޷�������λ����� >>>  start
		outPutNumber1(8);
		outPutNumber1(8 >>> moveCount);
		outPutNumber1(-8L);
		outPutNumber1(-8L >>> moveCount);//��ȷ��ֵlong���ͣ�����
		//�޷�������λ����� >>>  end
		
		//����������λ����� >>  start
		outPutNumber1(8);
		outPutNumber1(8 >> moveCount);
		outPutNumber1(-8);
		outPutNumber1(-8 >> moveCount);
		//����������λ����� >>  end
		
	    //��������Long   ���ֵ��Сֵ start
		System.out.println(String.format("long�������ֵ��%s��", Long.MAX_VALUE));//2^63 -1
		System.out.println(String.format("Long������Сֵ��%s��", Long.MIN_VALUE));//-2^63
		//��������Long   ���ֵ��Сֵ end
	}
	
	/**
	 * ��������number,��������ƺ�ʮ�������ı�ʾ��ʽ���з���ֵ��
	 * @param descPreFix
	 * @param number
	 */
	public static String outPutNumber(long number){
		return String.format("ʮ���Ʊ�ʾ��ʽ����%s���������Ʊ�ʾ����%s��",number, Long.toBinaryString(number)) ;
	}
	
	/**
	 * ��������number,��������ƺ�ʮ�������ı�ʾ��ʽ���޷���ֵ��
	 * @param number
	 */
	public static void outPutNumber1(long number){
		System.out.println( String.format("ʮ���Ʊ�ʾ��ʽ����%s���������Ʊ�ʾ����%s��",number, Long.toBinaryString(number)) );
	}
	
	/**
	 * ���������ʹ��    &
	 * @param number
	 * @param number2
	 */
	public static void outPutNumber2(long number1,long number2){
		System.out.println(String.format("���������&��������������%s��(%s)����%s��(%s)���������ǡ�%s��", number1 ,outPutNumber(number1) , number2 ,outPutNumber(number2) ,number1 & number2 ));
	}
	
	/**
	 * ���������ʹ��    |
	 * @param number
	 * @param number2
	 */
	public static void outPutNumber3(long number1,long number2){
		System.out.println(String.format("���������|��������������%s��(%s)����%s��(%s)���������ǡ�%s��", number1 ,outPutNumber(number1) , number2 ,outPutNumber(number2) ,number1 | number2 ));
	}
	
	/**
	 * ��������  ^
	 * @param number1
	 * @param number2
	 */
	public static void outPutNumber4(long number1,long number2){
		System.out.println(String.format("��������^������������%s %s������%s %s�����������ǡ�%s��" , number1 , outPutNumber(number1),number2,outPutNumber(number2), number1 ^ number2));
	}
	
}
