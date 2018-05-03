package com.ym.generics;

/**
 * 泛型边界符的使用：T extends Comparable<T>
 * eg:指定是comparable的子类，那么就可以使用大小比较的功能了
 * @author Administrator
 *
 */
public class BoundOperator {

	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray)
	        if (e.compareTo(elem) > 0)
	            ++count;
	    return count;
	}
	
}
