package com.ym.dataStructuresAndAlgorithms;

public class TestDemo {
	
	public static void main(String[] args) {
		System.out.println(fun());
		System.out.println(String.format("hi��%s��:", hi(16)));
		System.out.println(String.format("hello:��%s��", hello(16)));
		System.out.println(String.format("what:��%s��", what(3 , 4)));
		System.out.println(String.format("midNight:��%s��", midNight(3)));
		System.out.println(String.format("beforeDawn:��%s��", beforeDawn(3)));
	}
	
	//ʱ�临�Ӷ�O(1),ִ������11��12��13,�������ݹ�ģ���������仯��û�б仯���ƣ�
	private static int fun(){
		int m = 1;
		int n = 2;
		return m + n++;
	}
	
	//ʱ�临�Ӷ�O(log2n),ִ���������У�21��ִ�еĴ��������ģ����ﵽ2^n>=nʱ���Ż���ֹ��
	private static int hi(int n){
		int i = 1;
		while(i < n){
			i = i * 2;
		}
		return i*n;
	}
	
	//ʱ�临�Ӷ�O(nlog2n),ִ��������32��19,��Ƕ�׵ģ���ȡ����ִ�д����ĳ˻���
	private static int hello(int n){
		int i = 0;
		int k = 0;
		for(;i<n;i++){
			k = k + hi(n);
		}
		return k;
	}
	
	//ʱ�临�Ӷ�O(m+n),ִ��������43��49��������ͬ���ݹ�ģ����ȡ����ִ�д���֮�ͣ�
	private static int what(int m , int n){
		int i = 0 ;
		int k = 0;
		for(;i < m; i++){
			k = k + i;
		}
		
		int j = 0 ;
		int l = 0;
		for(;j < n; j++){
			l = l + j;
		}
		return k + l;
	}
	
	//ʱ�临�Ӷ�O(n)��
	//������ִ����57��58ִ��ʱ��ֱ�Ϊ1UnitTime , 59��60ִ��ʱ��ֱ�ΪnUnitTime
	//�ܼƣ�T��n�� = O��2n + 2�� = O(n) ,ȡӰ��ִ��ʱ���������������ֵn��
	private static int midNight(int n){
		int i = 0;
		int m = 0;
		for(;i < n ; i++){
			m = m + i;
		}
		return m;
	}
	
	//ʱ�临�Ӷ�O(n^2)...O(n^k)
	//������ִ����70��71��72ִ��ʱ��ֱ�Ϊ1UnitTime,73��742ִ��ʱ��ֱ�Ϊn,75ִ��ʱ��Ϊn^2
	//�ܼƣ�T(n) = O(2n^2 + 2n + 3) = O(n^2),ȡӰ��ִ��ʱ���������������ֵn^2.
	private static int beforeDawn(int n){
		int i = 0;
		int m = 0;
		int k = 0;
		for(;i < n ; i++){
			m = m + i;
			k = k + midNight(n);
		}
		return m + k;
	}
	
	//�ռ临�Ӷ�O��n��
	//������85��ռ��1Unit,86��ռ��nUnit
	//�ܼƣ�ȡ�����ݹ�ģ����Ӱ�����������ռ临�Ӷ�ֵ����ΪO(n)
	private static void size(int n){
		int i = 0;
		int []  a  = new int[n];
		for(;i < n; ++ i){
			a[i] = i * i;
		}
	}
	
}
