package com.ym.shiftOperator;

/**
 * @description  "移位运算符"的应用
 * 1.左移位运算符：
 * a.定义：<< ,一个long类型的数值，向左移动n位，那么相当于乘以了2 ^n
 * b.eg:若2的二进制是10，那么2<<3 后,二进制是10000,->16
 * 
 * 2.与位运算符：			             
 * a.定义：&,若一个long类型的数值a，和数值b做&操作，那么某一位同时为1，则为1，否则为0
 * b.eg:若2 & 6，二进制分别是 10、110，则结果为010,->2
 * 						       
 * 3.或位运算符：						   
 * a.定义：|,若一个long类型的数值a,和数值b做|操作，那么某一位存在1，则为1，否则为0
 * b.eg:若2 | 6，二进制分别为10、110，则结果为110,->6
 * 
 * 4.异或运算符
 * a.定义：^,若一个long类型的数值a,和数值b做^操作，那么只有一位存在1，则为1，否则为0
 * b.eg:若2^6,二进制分别为10,110，则结果为100，->4		
 * 
 * 5.无符号右移运算符>>>
 * a.定义：>>>,一个long类型的数值，向右移动N位，那么相当于除以了2^n,左边空位用0补齐
 * 
 * 
 * 6.带符号右移运算符>>
 * a.定义：>>,一个long类型的数值，向右移动N位，那么相当于除以了2^n,左边空位用符号位（负数用1，正数用0）补齐
 * 
 */
public class TestShiftOperator {
	
	public static void main(String[] args) {
		long number1   = 2L;
		long moveCount = 3L;
		
		//左移位运算符 <<  start
		outPutNumber1(253);
		outPutNumber1(253 << moveCount);//向左移动一位
		//左移位运算符 <<  end
		
		//与位运算符  &   start
		outPutNumber2(2 , 6);
		outPutNumber2(2 , 3);
		outPutNumber2(2 , 2);
		//与位运算符  &   end
		
		//或位运算符  |   start
		outPutNumber3(2 , 6);
		outPutNumber3(2 , 3);
		outPutNumber3(2 , 2);
		//或位运算符  |   end
		
		//异或运算符 ^ start
		outPutNumber4(2, 6);
		outPutNumber4(2, 3);
		outPutNumber4(2, 2);
		//异或运算符 ^ end
		
		//无符号右移位运算符 >>>  start
		outPutNumber1(8);
		outPutNumber1(8 >>> moveCount);
		outPutNumber1(-8L);
		outPutNumber1(-8L >>> moveCount);//明确赋值long类型！！！
		//无符号右移位运算符 >>>  end
		
		//带符号右移位运算符 >>  start
		outPutNumber1(8);
		outPutNumber1(8 >> moveCount);
		outPutNumber1(-8);
		outPutNumber1(-8 >> moveCount);
		//带符号右移位运算符 >>  end
		
	    //基本类型Long   最大值最小值 start
		System.out.println(String.format("long类型最大值【%s】", Long.MAX_VALUE));//2^63 -1
		System.out.println(String.format("Long类型最小值【%s】", Long.MIN_VALUE));//-2^63
		//基本类型Long   最大值最小值 end
	}
	
	/**
	 * 对于整数number,输出二进制和十进制数的表示形式（有返回值）
	 * @param descPreFix
	 * @param number
	 */
	public static String outPutNumber(long number){
		return String.format("十进制表示形式：【%s】，二进制表示：【%s】",number, Long.toBinaryString(number)) ;
	}
	
	/**
	 * 对于整数number,输出二进制和十进制数的表示形式（无返回值）
	 * @param number
	 */
	public static void outPutNumber1(long number){
		System.out.println( String.format("十进制表示形式：【%s】，二进制表示：【%s】",number, Long.toBinaryString(number)) );
	}
	
	/**
	 * 与运算符的使用    &
	 * @param number
	 * @param number2
	 */
	public static void outPutNumber2(long number1,long number2){
		System.out.println(String.format("与运算符（&）对于两个数【%s】(%s)、【%s】(%s)的运算结果是【%s】", number1 ,outPutNumber(number1) , number2 ,outPutNumber(number2) ,number1 & number2 ));
	}
	
	/**
	 * 或运算符的使用    |
	 * @param number
	 * @param number2
	 */
	public static void outPutNumber3(long number1,long number2){
		System.out.println(String.format("或运算符（|）对于两个数【%s】(%s)、【%s】(%s)的运算结果是【%s】", number1 ,outPutNumber(number1) , number2 ,outPutNumber(number2) ,number1 | number2 ));
	}
	
	/**
	 * 异或运算符  ^
	 * @param number1
	 * @param number2
	 */
	public static void outPutNumber4(long number1,long number2){
		System.out.println(String.format("异或运算符^对于两个数【%s %s】、【%s %s】的运算结果是【%s】" , number1 , outPutNumber(number1),number2,outPutNumber(number2), number1 ^ number2));
	}
	
}
