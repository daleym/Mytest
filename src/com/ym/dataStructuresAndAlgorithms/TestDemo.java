package com.ym.dataStructuresAndAlgorithms;

public class TestDemo {
	
	public static void main(String[] args) {
		System.out.println(fun());
		System.out.println(String.format("hi【%s】:", hi(16)));
		System.out.println(String.format("hello:【%s】", hello(16)));
		System.out.println(String.format("what:【%s】", what(3 , 4)));
		System.out.println(String.format("midNight:【%s】", midNight(3)));
		System.out.println(String.format("beforeDawn:【%s】", beforeDawn(3)));
	}
	
	//时间复杂度O(1),执行行数11、12、13,不随数据规模的增长而变化，没有变化趋势！
	private static int fun(){
		int m = 1;
		int n = 2;
		return m + n++;
	}
	
	//时间复杂度O(log2n),执行行行数中，21行执行的次数是最多的，当达到2^n>=n时，才会终止！
	private static int hi(int n){
		int i = 1;
		while(i < n){
			i = i * 2;
		}
		return i*n;
	}
	
	//时间复杂度O(nlog2n),执行行行数32、19,是嵌套的，故取两次执行次数的乘积！
	private static int hello(int n){
		int i = 0;
		int k = 0;
		for(;i<n;i++){
			k = k + hi(n);
		}
		return k;
	}
	
	//时间复杂度O(m+n),执行行行数43、49，分属不同数据规模，故取两者执行次数之和！
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
	
	//时间复杂度O(n)，
	//分析：执行行57、58执行时间分别为1UnitTime , 59、60执行时间分别为nUnitTime
	//总计：T（n） = O（2n + 2） = O(n) ,取影响执行时间趋势最大量级的值n！
	private static int midNight(int n){
		int i = 0;
		int m = 0;
		for(;i < n ; i++){
			m = m + i;
		}
		return m;
	}
	
	//时间复杂度O(n^2)...O(n^k)
	//分析：执行行70、71、72执行时间分别为1UnitTime,73、742执行时间分别为n,75执行时间为n^2
	//总计：T(n) = O(2n^2 + 2n + 3) = O(n^2),取影响执行时间趋势最大量级的值n^2.
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
	
	//空间复杂度O（n）
	//分析：85行占用1Unit,86行占用nUnit
	//总计：取随数据规模增大影响最大的量级空间复杂度值，即为O(n)
	private static void size(int n){
		int i = 0;
		int []  a  = new int[n];
		for(;i < n; ++ i){
			a[i] = i * i;
		}
	}
	
}
