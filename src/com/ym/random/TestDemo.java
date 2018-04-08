package com.ym.random;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 * @description ����� Ӧ�� 
 * @ע�⣺  SecureRandom���Random����ȫ�����ɵ������ֵ �ظ��ʴ�󽵵�... ...
 * @author ym
 */
public class TestDemo {

	public static void main(String[] args) {
		System.out.println("Integer�����ֵ����"+Integer.MAX_VALUE+"��");
		System.out.println(getRandom(new Date().getTime(),100));
		System.out.println(getRandom(new Date().getTime(),100));
		System.out.println(getRandom(new Date().getTime(),100));
		
		System.out.println("--------------");
		
		System.out.println(getSecureRandom());
		System.out.println(getSecureRandom());
		System.out.println(getSecureRandom());
	}
	
	//���������ֵ����ֵΨһ�ԣ�
	public static int getSecureRandom(){
		SecureRandom secureRandom = new SecureRandom();
		return secureRandom.nextInt();
	}
	
	/**
	 * ���������ֵ����ֵ���ܻ��ظ���
	 * @param seed
	 * @param bound  �����ֵ�ķ�Χ ��С�� bound
	 * @return
	 */
	public static int getRandom(long seed,int bound){
		Random random = new Random(seed);
		return bound == 0 ?random.nextInt():random.nextInt(bound);
	}
	
}
