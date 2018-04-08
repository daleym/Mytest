package com.ym.shiftOperator;

/**
 * @description  左移位运算符、与位运算符的应用
 * 			             左移位运算符：
 * 						       定义：<< ,一个long类型的数值，向左移动n位，那么相当于乘以了2 ^n
 * 						   eg:若2的二进制是10，那么2<<3 后,二进制是10000，变成了16
 * 			             与位运算符：
 * 				                        定义：&,若一个long类型的数值a，和数值b做&操作，那么某一位同时为1，则为1，否则为0
 * 				          eg:若2 & 6，二进制分别是 10、110，则结果为010，数值为2
 * 
 * 				    或位运算符：
 * 					              定义：|,若一个long类型的数值a,和数值b做|操作，那么某一位存在1，则为1，否则为0
 * 						  eg:若2 | 6，二进制分别为10、110，则结果为110.数值为6
 * @author ym
 */
public class TestShiftOperator {
	
	public static void main(String[] args) {
		long number1   = 2L;
		long number2   = 8L;
		long moveCount = 3L;
		
		//左移位运算符 <<  start
		outPutNumber1(number1);
		outPutNumber1(number1 << moveCount);//向左移动一位
		outPutNumber1(number2);
		outPutNumber1(number2 >> moveCount);//向右移动一位
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
	
}
