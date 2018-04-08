package com.ym.lambda;

/**
 * 
 * @author Administrator
 * @desc “() - > {}” 取代了匿名类
 * 	     注：若run方法中有参数，则按照如下写法："(a,b) -> {a+b}"
 * 	  汇总：  1.“() - > {}” 取代了匿名类
 * 		     注：若run方法中有参数，则按照如下写法："(a,b) -> {a+b}"
 *        2.lambda可以结合列表循环使用
 *        3.集合stream流结合lambda过滤元素
 * 		      注："() -> 表达式"  eg: "(m) -> m+m"
 *        4.集合stream流结合lambda过滤元素(Predicate)
 * 		      注："() -> 表达式"  eg: "(m) -> m+m"
 *        5.集合stream流结合lambda过滤元素(支持多重Predicate筛选条件)
 */
public class TestDemo1 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(" hello!");
			}
		}).start();
		
		new Thread(() -> {System.out.println("lambda hello!");}).start();
	}
}
