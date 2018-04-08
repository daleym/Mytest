package com.ym.designMode.genericTypes;

/**
 * @description 泛型基本使用
 * @author ym
 * @注意： T 相当于 Object，可以传入任意类型
 * @eg:如传入整型 66,则输出66；传入字符串“hello-world”，则输出“hello-world”... ...
 */
public class TestDemo1<T> {
	
	private T obj;
	
	public TestDemo1(T obj){
		this.obj = obj;
	}
	
	@Override
	public String toString(){
		return obj.toString();
	}
	
	//得到泛型类的名称
	public String getClassName(){
		return obj.getClass().getName();
	}
	
	public static void main(String[] args) {
		System.out.println("传入Integer 66,其中对象值：【"+new TestDemo1<Integer>(66)+"】，类名称：【"+new TestDemo1<Integer>(66).getClassName()+"】");
		System.out.println("传入String hello-world,其中对象值：【"+new TestDemo1<String>("hello-world")+"】，类名称：【"+new TestDemo1<String>("hello-world").getClassName()+"】");
	}
	
}
