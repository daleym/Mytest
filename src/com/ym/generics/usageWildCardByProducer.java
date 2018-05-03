package com.ym.generics;

import java.util.Arrays;
import java.util.List;

import com.ym.generics.entity.Apple;
import com.ym.generics.entity.Fruit;

/**
 * ���ͣ�ͨ�����ʹ��
 * eg��? extends T ,��ΪT�����T�����༴��
 * @author Administrator
 *
 */
public class usageWildCardByProducer {

	static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }
    static void f2() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }
    public static void main(String[] args) {
        f2();
    }
    
    
	
}

