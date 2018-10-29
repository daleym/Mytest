package com.ym.dataStructuresAndAlgorithms.TimeAndSpaceComplex;

import java.util.Arrays;

public class TestDemo2 {

	//���ʱ�临�Ӷȣ�o(1) ->����Ҫ���ҵ�Ԫ��j����arr�����һ��λ�ã����������һ�Σ�
	//�ʱ�临�Ӷȣ�O(n) ->����Ҫ���ҵ�Ԫ��J,��arr����ĩβ���ǲ��������У���Ҫ����n�Σ�����
	//ƽ��ʱ�临�Ӷȣ�O(n) ->����Ԫ��j���ܳ��ֵ�1��2��������n�������ڣ��ܼ�n+1���������ô�ۼӣ�Ȼ��ȡƽ��ֵ
	//				   ->1+2+3+...+n+n /(n+1)  ->ȥ��ϵ�����ͽס�����   -> ʱ�临�Ӷ�
	//				   ->��������ۺ󣬴��������еķ����ĸ�����  (1/n) *(1/2) ,�����������з����ĸ��� 1/2
	//			       -��1 * 1/2n + 2* 1/2n +....+n * 1/2n + n*1/2  ->ʱ�临�Ӷ�o(n)
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
	
	//���ʱ�临�Ӷȣ�o(1) ->����Ҫ�����Ԫ��data������λ��insertPos�պ�С�ڻ����arr���ȣ���ôֱ�Ӳ��룬ʱ�临�Ӷ�Ϊ1
	//�ʱ�临�Ӷȣ�O(n) ->����Ҫ�����Ԫ��data������λ��InsertPos�պ�=arr���ȣ���ô����Arr���õ��ۼ�ֵ���ٲ��룬ʱ�临�Ӷ�n
	//ƽ��ʱ�临�Ӷȣ�O(1) ->����Ҫ�����Ԫ��data,����λ��InsertPos������arr[0]��arr[1]...arr[arr.length]
	//				   ->��������ۺ󣬷����ĸ��ʶ���  1/(n+1) , �����ʱ�临�Ӷ��� o(1)��o(1)...o(n)
	//			       -��1 * 1/(n+1)��1 * 1/(n+1).....n * 1/(n+1)  ->ʱ�临�Ӷ�o(1)
	/**
	 * @param arr     ����
	 * @param data    Ҫ���������ֵ
	 * @param insertPos  //insertPos����Ϊarr.length
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
		System.out.println("����λ�ã�" + getPosition(new int[]{1,2,3 }, 3, 8));
		System.out.println("�������飺" + Arrays.toString(insertArr(new int[]{1,2,3}, 8 , 2)));
	}
	
}
