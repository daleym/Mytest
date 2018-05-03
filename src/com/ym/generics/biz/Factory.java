package com.ym.generics.biz;

public interface Factory<T> {
	
	T create();
	static <T> void create(T value){}//T是自己定义的，所以编译正确！
	//不能用类的T，因为那个需要对象实例化后，才能确定T的类型，static是不需要实例化对象确定的!
	
}
