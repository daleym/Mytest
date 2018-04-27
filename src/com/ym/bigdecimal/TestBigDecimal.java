package com.ym.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description  Bigdecimal����ҵ�������Ӧ�� 
 * @author ming.yang 2017-09-25
 * @attention  1.BigDecimal����Ӽ��˳�����������ֲ��䣬��õ�һ���µ�BigDecimal����������
 * 			     eg:BigDecimal result = bigDecimal.divide(divisor).setScale(2 , roundMode)  ->result������������bigDecimal�ǳ�ʼֵ
 *             2.����ģʽ���籣����λС���� : a.DOWN      �����������:�� -1.415->   -1.41   ,  1.415 ->  1.41
 *                                     b.UP        Զ�������: �� -1.415->   -1.42   ,  1.415 ->  1.42
 *                                     c.HALF_DOWN ��������:�� -1.415->   -1.41   , -1.416->   -1.42   ,
 *                                     						 1.415 ->  1.41    ,  1.416 ->  1.42
 *                                     d.HALF_UP   ��������:�� -1.415->   -1.42   ,  -1.414 ->  1.41
 *                                     						-1.415->   -1.42   ,  1.414 ->  1.41
 */
public class TestBigDecimal {

	//��תԪ-����ȡ��
	private static void FengToYuanByDownRound(String amount , int roundMode , String logPrefix){
		BigDecimal divisor = new BigDecimal("1000");
		BigDecimal bigDecimal = new BigDecimal(amount);
		BigDecimal result = bigDecimal.divide(divisor).setScale(2 , roundMode);
		System.out.println(String.format("%s������ģʽ��%s�����������ֵ��%s��,ת����Ĳ���ֵ��%s��", logPrefix ,RoundingMode.valueOf(roundMode) , amount , result));
	}
	
	public static void main(String[] args) {
		System.out.println("******��תԪ-����ȡ��******");
		FengToYuanByDownRound("1234" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("123" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("2" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		
		FengToYuanByDownRound("12345" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12344" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12346" , RoundingMode.DOWN.ordinal() , "��תԪ-����ȡ��");
		
		System.out.println("******��תԪ-����ȡ��******");
		FengToYuanByDownRound("1234" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("123" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("2" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		
		FengToYuanByDownRound("12345" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12344" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		FengToYuanByDownRound("12346" , RoundingMode.UP.ordinal() , "��תԪ-����ȡ��");
		
		System.out.println("******��תԪ-��������******");
		FengToYuanByDownRound("1234" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("123" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("2" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		
		FengToYuanByDownRound("12345" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12344" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12346" , RoundingMode.HALF_UP.ordinal() , "��תԪ-��������");
		
		System.out.println("******��תԪ-��������******");
		FengToYuanByDownRound("1234" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("123" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("2" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		
		FengToYuanByDownRound("12345" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12344" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		FengToYuanByDownRound("12346" , RoundingMode.HALF_DOWN.ordinal() , "��תԪ-��������");
		
		
	}
	
}
