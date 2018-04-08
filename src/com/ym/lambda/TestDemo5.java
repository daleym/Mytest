package com.ym.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * @author Administrator
 * @desc   ����stream�����lambda����Ԫ��(֧�ֶ���Predicateɸѡ����)
 * 		      ע��"() -> ���ʽ"  eg: "(m) -> m+m"
 */
public class TestDemo5 {
	public static void main(String[] args) {
		List<String> l = Arrays.asList("daly","lily","alice");
		filter(l, (m) -> m.contains("li") ,  (m) -> m.startsWith("l"));
	}
	
	private static void filter(List<String> l , Predicate<String> p , Predicate<String> p1){
		l.stream().filter((n) -> p.and(p1).test(n)).forEach((n) -> {System.out.println(n);});
	}
}
