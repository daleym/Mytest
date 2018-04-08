package com.ym.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestDemo {
	
	public static void main(String[] args) {
		Double  f = 1.9686;
		BigDecimal bigDecimal = new BigDecimal(f);
		System.out.println(bigDecimal.setScale(3, BigDecimal.ROUND_UP).doubleValue());
		
		Double a = 0.06;
		Double b = 0.01;
		System.out.println("处理前相加："+(a+b)+"，处理后相加："+BigDecimalUtils.addition(a, b,2,BigDecimal.ROUND_UP));
		System.out.println("处理前相减："+(a-b)+"，处理后相减："+BigDecimalUtils.subTract(a, b,2,BigDecimal.ROUND_UP));
		System.out.println("处理前相乘："+(4.015*100)+"，处理后相乘："+BigDecimalUtils.multiplication(4.015D, 100D,3,BigDecimal.ROUND_UP));
		System.out.println("处理前相除："+(303.1/1000)+"，处理后相除："+BigDecimalUtils.division(303.1D, 1000D,2,BigDecimal.ROUND_UP));
		
		int intervalUpDay = 0;
		int intervalDownDay = 0;//被除数不能为零
		long expectInterest = 24;
		System.out.println( new BigDecimal(expectInterest).multiply(new BigDecimal(intervalUpDay)).divide(new BigDecimal(intervalDownDay), 0, RoundingMode.DOWN).longValue());
	}
	
}
