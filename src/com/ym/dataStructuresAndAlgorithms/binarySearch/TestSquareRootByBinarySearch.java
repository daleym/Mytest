package com.ym.dataStructuresAndAlgorithms.binarySearch;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * @description 二分查找算法：			          
 * 应用场景：开平方根（sqrt）的实现
 * 要求：1.保留小数点后六位 
 * 	   2.误差精度在0.00001以内(六位)
 * eg:16.0的平方根是：4.000000636692939
 *    49.0的平方根是：7.000000141269659
 *    51.0的平方根是：7.141428637096297
 */
public class TestSquareRootByBinarySearch {
	private static double binSearchSqrt(Double num, Double left, Double right) {
		if (num == null) throw new IllegalArgumentException("input invalid");
		while (left < right) {
			double middle = (left + right) / 2.0;
			if (Math.abs(middle * middle - num) < 0.00001) {
				return middle;
			}
			if (middle * middle < num) {
				left = middle;
				right = num / middle;
			} else if (middle * middle > num) {
				right = middle;
				left = num / middle;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		for (double i = 1; i <= 100; i++) {
			Double a = binSearchSqrt(i, 1d, i);
			System.out.println(i + "的平方根是：" + a);
			System.out.println(String.format("保留6位小数(向下取整)：【%s】", new BigDecimal(a).setScale(6 , RoundingMode.DOWN).doubleValue() ));
		}
		
	}
}
