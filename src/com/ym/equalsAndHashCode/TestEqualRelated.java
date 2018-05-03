package com.ym.equalsAndHashCode;

/**
 * 主题：equals和==的区别
 * 前者是比较的引用地址的内容是否相同，而后者是比较指向的值的内存地址是否相同
 * eg:No.1  常量 数字和字符串，比较特殊，在“方法区”中，相同的数字或字符串仅存在唯一的一份
 *    No.2  但是new String("XXX")，每次都会在“堆”中，创建一个新的实例对象
 * @author Administrator
 *
 */
public class TestEqualRelated {

	static int a1 = 1;
	static long a2 =1;
	static double a3=1;
	
	public static void main(String[] args) {
		//No.1-------------------------
		System.out.println(String.format("a1?=a2 [%s] ", a1==a2));
		System.out.println(String.format("a1?=a3 [%s] ", a1==a3));
		System.out.println(String.format("a2?=a3 [%s] ", a2==a3));
		
		//No.2--------------------------
		String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }
	}
	
}
