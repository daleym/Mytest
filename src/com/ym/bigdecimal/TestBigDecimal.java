package com.ym.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description  Bigdecimal在商业金额计算的应用 （适用于16位以上的数值计算）
 * @author ming.yang 2017-09-25
 * @attention  1.BigDecimal做完加减乘除运算后，自身保持不变，会得到一个新的BigDecimal运算结果对象。
 * 			     eg:BigDecimal result = bigDecimal.divide(divisor).setScale(2 , roundMode) 
 * 					 ->result便是运算结果，bigDecimal是初始值
 *             2.舍入模式（如保留两位小数） : a.DOWN      保留的最后一位进位: 如 -1.415->   -1.41   ,  1.415 ->  1.41
 *                                     b.RoundingMode.up.ordinal(Bigdecimal.round_up)     
 *                                     ---效果：保留位进位，至少大于原值
 *                                     ---eg:  0.14->0.2 ;0.15->0.2; 0.16->0.2
 *                                     c.HALF_DOWN 五舍六入                   :如 -1.415->   -1.41   , -1.416->   -1.42   ,
 *                                     						        1.415 ->  1.41    ,  1.416 ->  1.42
 *                                     d.HALF_UP   四舍五入                   :如 -1.415->   -1.42   ,  -1.414 ->  1.41
 *                                     						       -1.415->   -1.42   ,  1.414 ->  1.41
 */
public class TestBigDecimal {

	//分转元-向下取整
	private static void FengToYuanByDownRound(String amount , int roundMode , String logPrefix){
		BigDecimal divisor = new BigDecimal("100");
		BigDecimal bigDecimal = new BigDecimal(amount);
		BigDecimal result = bigDecimal.divide(divisor).setScale(1 , roundMode);
		System.out.println(String.format("%s，舍入模式【%s】：传入参数值【%s】,转化后的参数值【%s】", logPrefix ,RoundingMode.valueOf(roundMode) , amount , result));
	}
	
	public static void main(String[] args) {
		System.out.println("******分转元-向下取整******");
		FengToYuanByDownRound("1234" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		FengToYuanByDownRound("123" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		FengToYuanByDownRound("12" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		FengToYuanByDownRound("2" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		
		FengToYuanByDownRound("12345" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		FengToYuanByDownRound("12344" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		FengToYuanByDownRound("12346" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		
		System.out.println("******分转元(保留一位)-向上取整UP******start");
		
		FengToYuanByDownRound("12345" , RoundingMode.UP.ordinal() , "分转元-向上取整");
		FengToYuanByDownRound("12344" , RoundingMode.UP.ordinal() , "分转元-向上取整");
		FengToYuanByDownRound("12346" , RoundingMode.UP.ordinal() , "分转元-向上取整");
		
		System.out.println("******分转元-向上取整(保留一位)UP******end");
		
		System.out.println("******分转元-四舍五入******");
		FengToYuanByDownRound("1234" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		FengToYuanByDownRound("123" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		FengToYuanByDownRound("12" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		FengToYuanByDownRound("2" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		
		FengToYuanByDownRound("12345" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		FengToYuanByDownRound("12344" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		FengToYuanByDownRound("12346" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		
		System.out.println("******分转元-五舍六入******");
		FengToYuanByDownRound("1234" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		FengToYuanByDownRound("123" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		FengToYuanByDownRound("12" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		FengToYuanByDownRound("2" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		
		FengToYuanByDownRound("12345" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		FengToYuanByDownRound("12344" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		FengToYuanByDownRound("12346" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		
		
	}
	
}
