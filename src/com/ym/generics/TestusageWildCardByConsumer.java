package com.ym.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.ym.generics.entity.Apple;
import com.ym.generics.entity.Fruit;
import com.ym.generics.entity.Orange;

/**
 * 泛型：通配符的使用(限定通配符 和 非限定通配符)  -> ?  和   ? extends List 
 * eg：? super T ,作为T本身或T的父类即可
 * 
 * !!!类型擦除!!!：在运行期，泛型类型参数会被Object或边界符（extends、super后面的类）取代
 * eg:No3示例中，类型擦除后，可以通过反射来实现添加元素到List中！
 * @author Administrator
 *
 */
public class TestusageWildCardByConsumer {

	static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();
    static List<Orange> oranges = new ArrayList<>();
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }
    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Apple());
//        writeWithWildcard(oranges , new Apple());
    }
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        f2();
        
        //No2-------------------------------------------
        //类型擦除后,泛型类型  -> 原始类型
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2); // true
        
        //No3--------------------------------------------
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //这里直接添加会报错
//        list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);
    }
    
    //综合使用
    class Collections {
        public  <T> void copy(List<? super T> dest, List<? extends T> src) {
            for (int i=0; i<src.size(); i++)
                dest.set(i, src.get(i));
        }
    }
	
}
