package com.ym.dataStructuresAndAlgorithms.TimeAndSpaceComplex;

import java.util.Arrays;

public class TestDemo2 {

	//最好时间复杂度：o(1) ->假如要查找的元素j，在arr数组第一个位置，则仅仅遍历一次！
	//最坏时间复杂度：O(n) ->假设要查找的元素J,在arr数组末尾或是不存在其中，则要遍历n次！！！
	//平均时间复杂度：O(n) ->假设元素j可能出现第1、2、、、、n、不存在，总计n+1中情况，那么累加，然后取平均值
	//				   ->1+2+3+...+n+n /(n+1)  ->去除系数、低阶、常数   -> 时间复杂度
	//				   ->引入概率论后，存在数组中的发生的概率是  (1/n) *(1/2) ,不存在数组中发生的概率 1/2
	//			       -》1 * 1/2n + 2* 1/2n +....+n * 1/2n + n*1/2  ->时间复杂度o(n)
	public static int getPosition(int [] arr , int n , int j){
		
		int i = 0;
		int pos = -1;
		for(; i < n ; ++i){
			if(arr[i] == j){
				pos = i;
				break;
			}
		}
		return pos;
		
	}
	
	//最好时间复杂度：o(1) ->假如要插入的元素data，插入位置insertPos刚好小于或大于arr长度，那么直接插入，时间复杂度为1
	//最坏时间复杂度：O(n) ->假设要插入的元素data，插入位置InsertPos刚好=arr长度，那么遍历Arr，得到累计值，再插入，时间复杂度n
	//平均时间复杂度：O(1) ->假设要插入的元素data,插入位置InsertPos可能是arr[0]、arr[1]...arr[arr.length]
	//				   ->引入概率论后，发生的概率都是  1/(n+1) , 插入的时间复杂度是 o(1)、o(1)...o(n)
	//			       -》1 * 1/(n+1)、1 * 1/(n+1).....n * 1/(n+1)  ->时间复杂度o(1)
	/**
	 * @param arr     数组
	 * @param data    要插入的数据值
	 * @param insertPos  //insertPos至多为arr.length
	 * @return
	 */
	public static int [] insertArr(int [] arr , int data  , int insertPos ){ 
		if(insertPos == arr.length){
			int sum = 0;
			int i = 0;
			for(;i < arr.length ; ++i){
				sum += arr[i];
				arr[0] = sum;
				insertPos = 0;
			}
			
		}
		arr[insertPos] = data;
		++insertPos;
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println("数组位置：" + getPosition(new int[]{1,2,3 }, 3, 8));
		System.out.println("插入数组：" + Arrays.toString(insertArr(new int[]{1,2,3}, 8 , 2)));
	}
	
}
