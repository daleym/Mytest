package com.ym.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Administrator
 * @desc lambda���Խ���б�ѭ��ʹ��
 */
public class TestDemo2 {
	public static void main(String[] args) {
		List<String> l = Arrays.asList("daly","lily");
		l.forEach((n) -> {System.out.println(n);});
	}
}
