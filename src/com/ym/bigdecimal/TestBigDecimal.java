package com.ym.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description  Bigdecimal在商业金额计算的应用 （适用于16位以上的数值计算）
 * @author       ming.yang 2017-09-25
 * @attention  1.BigDecimal做完加减乘除运算后，自身保持不变，会得到一个新的BigDecimal运算结果对象。
 * 			     eg:BigDecimal result = bigDecimal.divide(divisor).setScale(2 , roundMode) 
 * 					 ->result便是运算结果，bigDecimal是初始值
 *             2.舍入模式（除100，保留1位） : a.RoundingMode.DOWN(Bigdecimal.Round_down)      
 *             						   ---用法：向下取整，保留位不变，<= 原值
 									   ---eg:  12300 -> 123.0 ; 12345 -> 123.4 ; 12344 -> 123.4 ;12346->123.4
 *                                     b.RoundingMode.up.ordinal(Bigdecimal.round_up)     
 *                                     ---用法：向上取整，保留位进位，>= 原值
 *                                     ---eg:  12300 -> 123.0 ; 12345 -> 123.5 ; 12344 -> 123.5 ;12346->123.5
 *                                     c.RoundingMode.HALF_DOWN.ordinal（Bigdecimal.Round_half_down）
 *                                     ---用法： 五舍六入
 *                                     ---eg:  12300 -> 123.0 ; 12345 -> 123.4 ; 12344 -> 123.4 ;12346->123.5
 *                                     d.RoundingMode.HALF_UP.ordinal(Bigdecial.Round_half_up)
 *                                     ---用法：四舍五入
 *                                     ---eg: 12300 -> 123.0 ; 12345 -> 123.5 ; 12344 -> 123.4 ;12346->123.5
 */
public class TestBigDecimal {

	/**
	 * 分转元 ，保留1位小数
	 * @param amount
	 * @param roundMode
	 * @param logPrefix
	 */
	private static void FengToYuanByDownRound(String amount , int roundMode , String logPrefix){
		BigDecimal divisor = new BigDecimal("100");
		BigDecimal bigDecimal = new BigDecimal(amount);
		BigDecimal result = bigDecimal.divide(divisor).setScale(1 , roundMode);
		System.out.println(String.format("%s，舍入模式【%s】：传入参数值【%s】,转化后的参数值【%s】", logPrefix ,RoundingMode.valueOf(roundMode) , amount , result));
	}
	
	public static void main(String[] args) {
		System.out.println("******分转元-向下取整(down)******start");
		
		FengToYuanByDownRound("12300" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		FengToYuanByDownRound("12345" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		FengToYuanByDownRound("12344" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		FengToYuanByDownRound("12346" , RoundingMode.DOWN.ordinal() , "分转元-向下取整");
		
		System.out.println("******分转元-向下取整(down)******end");
		
		System.out.println("******分转元(保留一位)-向上取整UP******start");
		
		FengToYuanByDownRound("12300" , RoundingMode.UP.ordinal() , "分转元-向上取整");
		FengToYuanByDownRound("12345" , RoundingMode.UP.ordinal() , "分转元-向上取整");
		FengToYuanByDownRound("12344" , RoundingMode.UP.ordinal() , "分转元-向上取整");
		FengToYuanByDownRound("12346" , RoundingMode.UP.ordinal() , "分转元-向上取整");
		
		System.out.println("******分转元-向上取整(保留一位)UP******end");
		
		System.out.println("******分转元-四舍五入(保留一位)******start");
		
		FengToYuanByDownRound("12300" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		FengToYuanByDownRound("12345" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		FengToYuanByDownRound("12344" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		FengToYuanByDownRound("12346" , RoundingMode.HALF_UP.ordinal() , "分转元-四舍五入");
		
		System.out.println("******分转元-四舍五入(保留一位)******end");
		
		System.out.println("******分转元-五舍六入(保留一位)******start");
		
		FengToYuanByDownRound("12300" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		FengToYuanByDownRound("12345" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		FengToYuanByDownRound("12344" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		FengToYuanByDownRound("12346" , RoundingMode.HALF_DOWN.ordinal() , "分转元-五舍六入");
		
		System.out.println("******分转元-五舍六入(保留一位)******end");
		
		
	}
	
}
