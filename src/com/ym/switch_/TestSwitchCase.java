package com.ym.switch_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description swith...case���
 * @author ming.yang 2017-09-25
 * @attention 1.��case���治��break���ʱ��������߼��鶼��õ�ִ�С�
 *             eg:switch(1) ... case 1...print 1;case 2...print 2;default ...print 3;  ->  1 2 3  
 */
public class TestSwitchCase {
	
	private static void executeSwitchCaseBlock(Fruit fruit){
		switch (fruit) {
		case BANANA:
		case WATERMELON:
			System.out.println(String.format("Ԥ��ˮ����%s�� , ˮ����������%s,%s��",fruit, Fruit.BANANA , Fruit.WATERMELON));
			break;
		case APPLE:
			System.out.println(String.format("Ԥ��ˮ����%s�� , ˮ����������%s��",fruit, Fruit.APPLE ));
			break;
		case DURIAN:
			System.out.println(String.format("Ԥ��ˮ����%s�� , ˮ����������%s��",fruit, Fruit.DURIAN));
		case GRAPE:
			System.out.println(String.format("Ԥ��ˮ����%s�� , ˮ����������%s��",fruit, Fruit.GRAPE));
		case ORANGE:
		default:
			System.out.println(String.format("Ԥ��ˮ����%s�� , ���е�ˮ����������%s��", fruit,Arrays.toString(Fruit.values())));
			break;
		}
	}
	
	public static void main(String[] args) {
//		executeSwitchCaseBlock(Fruit.APPLE);
//		executeSwitchCaseBlock(Fruit.BANANA);
//		executeSwitchCaseBlock(Fruit.WATERMELON);
//		
//		executeSwitchCaseBlock(Fruit.PEAR);
//		executeSwitchCaseBlock(Fruit.ORANGE);
//		executeSwitchCaseBlock(Fruit.DURIAN);
//		executeSwitchCaseBlock(Fruit.GRAPE);
		
		List<Fruit> fruits = new LinkedList<>();
		fruits.add(Fruit.PEAR);
		fruits.add(Fruit.BANANA);
		
		for(Fruit f : fruits){
			executeSwitchCaseBlock(f);
		}
	}
	
}
