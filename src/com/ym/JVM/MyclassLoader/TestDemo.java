package com.ym.JVM.MyclassLoader;

/**
 * 类加载机制顺序：用到父类的静态变量时，不会实例化本类！
 * eg:如Subclass引用父类SuperClass的value静态字段，那么不会实例化本类！
 * 			但是会实例化父类SuperClass及上层依赖父类SSClass的静态块！
 * @author ming.yang
 *
 */
public class TestDemo {
	public static void main(String[] args) {
    	System.out.println(SubClass.value);
	}
}
