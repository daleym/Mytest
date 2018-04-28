package com.ym.JVM;

/**
 * JVM动态绑定和静态绑定：动态绑定仅针对对象实例的方法，普通变量和静态变量以及静态方法在编译期就确定了和类的关系！！！
 * eg：访问成员变量时，引用Father所在的变量；访问非静态成员方法时，引用实例对象的方法！
 * @author Administrator
 *
 */
public class TestDynamicAndStaticBinding {
	public static void main(String[] args) {
		Father father = new Son();
		System.out.println(father.getName());
		System.out.println(father.name);
		System.out.println(father.age);
		System.out.println(Father.getAge());
	}
}
