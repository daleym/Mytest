package com.ym.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * @author Administrator
 * @desc   集合stream流结合lambda过滤元素(支持多重Predicate筛选条件)
 * 		      注："() -> 表达式"  eg: "(m) -> m+m"
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
