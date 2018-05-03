package com.ym.generics;

import com.ym.generics.biz.Part;

/**
 * 泛型，工厂模式的运用
 * @author Administrator
 *
 */
public class RegisteredFactories {

	public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
	
}
