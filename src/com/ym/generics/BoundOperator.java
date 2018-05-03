package com.ym.generics;

/**
 * ���ͱ߽����ʹ�ã�T extends Comparable<T>
 * eg:ָ����comparable�����࣬��ô�Ϳ���ʹ�ô�С�ȽϵĹ�����
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
