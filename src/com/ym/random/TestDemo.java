package com.ym.random;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 * @description 随机数 应用 
 * @注意：  SecureRandom相比Random更安全，生成的随机数值 重复率大大降低... ...
 * @author ym
 */
public class TestDemo {

	public static void main(String[] args) {
		System.out.println("Integer的最大值：【"+Integer.MAX_VALUE+"】");
		System.out.println(getRandom(new Date().getTime(),100));
		System.out.println(getRandom(new Date().getTime(),100));
		System.out.println(getRandom(new Date().getTime(),100));
		
		System.out.println("--------------");
		
		System.out.println(getSecureRandom());
		System.out.println(getSecureRandom());
		System.out.println(getSecureRandom());
	}
	
	//生成随机数值（数值唯一性）
	public static int getSecureRandom(){
		SecureRandom secureRandom = new SecureRandom();
		return secureRandom.nextInt();
	}
	
	/**
	 * 生成随机数值（数值可能会重复）
	 * @param seed
	 * @param bound  随机数值的范围 ，小于 bound
	 * @return
	 */
	public static int getRandom(long seed,int bound){
		Random random = new Random(seed);
		return bound == 0 ?random.nextInt():random.nextInt(bound);
	}
	
}
