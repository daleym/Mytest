package com.ym.dataStructuresAndAlgorithms.binarySearch;

/**
 * @description 二分查找：开平方根的实现
 * @author ming.yang
 */
public class TestSquareRootByBinarySearch {

	public static void main(String[] args) {
		for (double i = 1; i <= 100; i++) {
			Double a = binSearchSqrt(i, 1d, i);
			System.out.println(i + "的平方根是：" + a);
		}
	}

	private static double binSearchSqrt(Double num, Double left, Double right) {
		if (num == null) {
			throw new IllegalArgumentException("input invalid");
		}

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

}
