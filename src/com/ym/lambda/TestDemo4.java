package com.ym.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * @author Administrator
 * @desc   集合stream流结合lambda过滤元素(Predicate)
 * 		      注："() -> 表达式"  eg: "(m) -> m+m"
 */
public class TestDemo4 {
	public static void main(String[] args) {
		List<String> l = Arrays.asList("daly","lily","alice");
		filter(l, (m) -> m.contains("li"));
		System.out.println("---");
		filter(l, (m) -> true);
	}
	
	private static void filter(List<String> l , Predicate<String> p){
		l.stream().filter((n) -> p.test(n)).forEach((n) -> {System.out.println(n);});
	}
}
