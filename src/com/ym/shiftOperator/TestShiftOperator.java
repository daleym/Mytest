package com.ym.shiftOperator;

/**
 * @description  ����λ���������λ�������Ӧ��
 * 			             ����λ�������
 * 						       ���壺<< ,һ��long���͵���ֵ�������ƶ�nλ����ô�൱�ڳ�����2 ^n
 * 						   eg:��2�Ķ�������10����ô2<<3 ��,��������10000�������16
 * 			             ��λ�������
 * 				                        ���壺&,��һ��long���͵���ֵa������ֵb��&��������ôĳһλͬʱΪ1����Ϊ1������Ϊ0
 * 				          eg:��2 & 6�������Ʒֱ��� 10��110������Ϊ010����ֵΪ2
 * 
 * 				    ��λ�������
 * 					              ���壺|,��һ��long���͵���ֵa,����ֵb��|��������ôĳһλ����1����Ϊ1������Ϊ0
 * 						  eg:��2 | 6�������Ʒֱ�Ϊ10��110������Ϊ110.��ֵΪ6
 * @author ym
 */
public class TestShiftOperator {
	
	public static void main(String[] args) {
		long number1   = 2L;
		long number2   = 8L;
		long moveCount = 3L;
		
		//����λ����� <<  start
		outPutNumber1(number1);
		outPutNumber1(number1 << moveCount);//�����ƶ�һλ
		outPutNumber1(number2);
		outPutNumber1(number2 >> moveCount);//�����ƶ�һλ
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
	
}
