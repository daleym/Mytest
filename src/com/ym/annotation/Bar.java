package com.ym.annotation;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��11��19�� ����4:35:57 
* ��˵�� ~~~
*/

//Bar.java
import java.util.function.IntBinaryOperator;

public class Bar {
	@Adapt(IntBinaryOperator.class)
	public static int add(int a, int b) {
		return a + b;
	}
}
