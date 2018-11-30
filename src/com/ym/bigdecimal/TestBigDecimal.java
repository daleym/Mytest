package com.ym.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description  Bigdecimal����ҵ�������Ӧ�� ��������16λ���ϵ���ֵ���㣩
 * @author       ming.yang 2017-09-25
 * @attention  1.BigDecimal����Ӽ��˳�����������ֲ��䣬��õ�һ���µ�BigDecimal����������
 * 			     eg:BigDecimal result = bigDecimal.divide(divisor).setScale(2 , roundMode) 
 * 					 ->result������������bigDecimal�ǳ�ʼֵ
 *             2.����ģʽ����100������1λ�� : a.RoundingMode.DOWN(Bigdecimal.Round_down)      
 *             						   ---�÷�������ȡ��������λ���䣬<= ԭֵ
 									   ---eg:  12300 -> 123.0 ; 12345 -> 123.4 ; 12344 -> 123.4 ;12346->123.4
 *                                     b.RoundingMode.up.ordinal(Bigdecimal.round_up)     
 *                                     ---�÷�������ȡ��������λ��λ��>= ԭֵ
 *                                     ---eg:  12300 -> 123.0 ; 12345 -> 123.5 ; 12344 -> 123.5 ;12346->123.5
 *                                     c.RoundingMode.HALF_DOWN.ordinal��Bigdecimal.Round_half_down��
 *                                     ---�÷��� ��������
 *                                     ---eg:  12300 -> 123.0 ; 12345 -> 123.4 ; 12344 -> 123.4 ;12346->123.5
 *                                     d.RoundingMode.HALF_UP.ordinal(Bigdecial.Round_half_up)
 *                                     ---�÷�����������
 *                                     ---eg: 12300 -> 123.0 ; 12345 -> 123.5 ; 12344 -> 123.4 ;12346->123.5
 */
public class TestBigDecimal {

	/**
	 * ��תԪ ������1λС��
	 * @param amount
	 * @param roundMode
	 * @param logPrefix
	 */
	private static void FengToYuanByDownRound(String amount , int roundMode , String logPrefix){
		BigDecimal divisor = new BigDecimal("100");
		BigDecimal bigDecimal = new BigDecimal(amount);
		BigDecimal result = bigDecimal.divide(divisor).setScale(1 , roundMode);
		System.out.println(String.format("%s������ģʽ��%s�����������ֵ��%s��,ת����Ĳ���ֵ��%s��", logPrefix ,RoundingMode.valueOf(roundMode) , amount , result));
	}
	
	public static void main(String[] args) {
		System.out.println("******��תԪ-����ȡ��(down)******start");
		
		FengToYuanByDownRound("12300" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12345" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12344" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12346" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		
		System.out.println("******��תԪ-����ȡ��(down)******end");
		
		System.out.println("******��תԪ(����һλ)-����ȡ��UP******start");
		
		FengToYuanByDownRound("12300" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12345" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12344" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12346" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		
		System.out.println("******��תԪ-����ȡ��(����һλ)UP******end");
		
		System.out.println("******��תԪ-��������(����һλ)******start");
		
		FengToYuanByDownRound("12300" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12345" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12344" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12346" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		
		System.out.println("******��תԪ-��������(����һλ)******end");
		
		System.out.println("******��תԪ-��������(����һλ)******start");
		
		FengToYuanByDownRound("12300" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12345" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12344" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12346" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		
		System.out.println("******��תԪ-��������(����һλ)******end");
		
		
	}
	
}
