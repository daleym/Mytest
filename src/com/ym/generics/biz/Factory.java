package com.ym.generics.biz;

public interface Factory<T> {
	
	T create();
	static <T> void create(T value){}//T���Լ�����ģ����Ա�����ȷ��
	//���������T����Ϊ�Ǹ���Ҫ����ʵ�����󣬲���ȷ��T�����ͣ�static�ǲ���Ҫʵ��������ȷ����!
	
}
