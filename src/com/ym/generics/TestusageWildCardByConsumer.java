package com.ym.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.ym.generics.entity.Apple;
import com.ym.generics.entity.Fruit;
import com.ym.generics.entity.Orange;

/**
 * ���ͣ�ͨ�����ʹ��(�޶�ͨ��� �� ���޶�ͨ���)  -> ?  ��   ? extends List 
 * eg��? super T ,��ΪT�����T�ĸ��༴��
 * 
 * !!!���Ͳ���!!!���������ڣ��������Ͳ����ᱻObject��߽����extends��super������ࣩȡ��
 * eg:No3ʾ���У����Ͳ����󣬿���ͨ��������ʵ�����Ԫ�ص�List�У�
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
        //���Ͳ�����,��������  -> ԭʼ����
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2); // true
        
        //No3--------------------------------------------
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //����ֱ����ӻᱨ��
//        list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //����ͨ��������ӣ��ǿ��Ե�
        add.invoke(list, "kl");

        System.out.println(list);
    }
    
    //�ۺ�ʹ��
    class Collections {
        public  <T> void copy(List<? super T> dest, List<? extends T> src) {
            for (int i=0; i<src.size(); i++)
                dest.set(i, src.get(i));
        }
    }
	
}
