package com.ym.dataStructuresAndAlgorithms.binarySearch;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * @description ���ֲ����㷨��			          
 * Ӧ�ó�������ƽ������sqrt����ʵ��
 * Ҫ��1.����С�������λ 
 * 	   2.������0.00001����(��λ)
 * eg:16.0��ƽ�����ǣ�4.000000636692939
 *    49.0��ƽ�����ǣ�7.000000141269659
 *    51.0��ƽ�����ǣ�7.141428637096297
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
			System.out.println(i + "��ƽ�����ǣ�" + a);
			System.out.println(String.format("����6λС��(����ȡ��)����%s��", new BigDecimal(a).setScale(6 , RoundingMode.DOWN).doubleValue() ));
		}
		
	}
}
