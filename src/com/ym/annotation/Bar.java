package com.ym.annotation;

/** 
* @author ym: 
* @version 创建时间：2019年11月19日 下午4:35:57 
* 类说明 ~~~
*/

//Bar.java
import java.util.function.IntBinaryOperator;

public class Bar {
	@Adapt(IntBinaryOperator.class)
	public static int add(int a, int b) {
		return a + b;
	}
}
