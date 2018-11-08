package com.ym.dataStructuresAndAlgorithms.binarySearch;

/**
 * @description ���ֲ��ң���ƽ������ʵ��
 * @author ming.yang
 */
public class TestSquareRootByBinarySearch {

	public static void main(String[] args) {
		for (double i = 1; i <= 100; i++) {
			Double a = binSearchSqrt(i, 1d, i);
			System.out.println(i + "��ƽ�����ǣ�" + a);
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
