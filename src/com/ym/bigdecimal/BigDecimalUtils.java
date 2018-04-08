package com.ym.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalUtils {
	
	//�ӷ�
	public static Double addition(Double a,Double b,int scale,int type){
		BigDecimal bigDecimalA = new BigDecimal(a);
		BigDecimal bigDecimalB = new BigDecimal(b);
		return bigDecimalA.add(bigDecimalB).setScale(scale,type).doubleValue();
	}
	
	//���
	public static Double subTract(Double a,Double b,int scale,int type){
		BigDecimal bigDecimalA = new BigDecimal(a);
		BigDecimal bigDecimalB = new BigDecimal(b);
		return bigDecimalA.subtract(bigDecimalB).setScale(scale, type).doubleValue();
	}
	
	//���
	public static Double multiplication(Double a,Double b,int scale,int type){
		BigDecimal bigDecimalA = new BigDecimal(a);
		BigDecimal bigDecimalB = new BigDecimal(b);
		return bigDecimalA.multiply(bigDecimalB).setScale(scale, type).doubleValue();
	}
	
	/**
	 * ���
	 * ע������ ��С���㱣����ʽ�����в�ͬ��ע�⼴��
	 * @param a
	 * @param b
	 * @param scale
	 * @param type
	 * @return
	 */
	public static Double division(Double a,Double b,int scale,int type){
		BigDecimal bigDecimalA = new BigDecimal(a);
		BigDecimal bigDecimalB = new BigDecimal(b);
		return bigDecimalA.divide(bigDecimalB, scale, type).doubleValue();
	}
	
	public static void main(String[] args) {
		BigDecimalUtils bigDecimalUtils = new BigDecimalUtils();
		System.out.println(bigDecimalUtils.multiplication(0.25D, 10000D, 0, BigDecimal.ROUND_UP));
	}
	
}
