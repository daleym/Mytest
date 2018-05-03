package com.ym.equalsAndHashCode;

/**
 * ���⣺equals��==������
 * ǰ���ǱȽϵ����õ�ַ�������Ƿ���ͬ���������ǱȽ�ָ���ֵ���ڴ��ַ�Ƿ���ͬ
 * eg:No.1  ���� ���ֺ��ַ������Ƚ����⣬�ڡ����������У���ͬ�����ֻ��ַ���������Ψһ��һ��
 *    No.2  ����new String("XXX")��ÿ�ζ����ڡ��ѡ��У�����һ���µ�ʵ������
 * @author Administrator
 *
 */
public class TestEqualRelated {

	static int a1 = 1;
	static long a2 =1;
	static double a3=1;
	
	public static void main(String[] args) {
		//No.1-------------------------
		System.out.println(String.format("a1?=a2 [%s] ", a1==a2));
		System.out.println(String.format("a1?=a3 [%s] ", a1==a3));
		System.out.println(String.format("a2?=a3 [%s] ", a2==a3));
		
		//No.2--------------------------
		String a = new String("ab"); // a Ϊһ������
        String b = new String("ab"); // bΪ��һ������,���������һ��
        String aa = "ab"; // ���ڳ�������
        String bb = "ab"; // �ӳ������в���
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false����ͬһ����
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }
	}
	
}
