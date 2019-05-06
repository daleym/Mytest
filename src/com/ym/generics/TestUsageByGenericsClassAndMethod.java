package com.ym.generics;

/**
 * ���͵�ʹ��:K,V����ͨ�õķ�������ռλ��
 * �������ʹ�ã�
 *            eg:36�� Pair<K,V>�����������ڳ�Ա����������ʹ��~~~
 * ���ͷ�����ʹ�ã�
 * 			  eg:15�У��ڷ�������ֵǰ ����  �� <P,V> �������󣬿�ֱ�����ڷ����β�ʹ��~~~
 * 
 * @author Administrator
 *
 */
public class TestUsageByGenericsClassAndMethod {

	public static <P , V>  boolean compare(Pair<P , V> p1, Pair<P , V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
	
	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<>(1, "apple");
		Pair<Integer, String> p2 = new Pair<>(2, "pear");
		Pair<Integer , Integer> p3 = new Pair<>(3,3);
		boolean same = TestUsageByGenericsClassAndMethod.compare(p1, p2);
//		boolean another = Util.compare(p1, p3);
		
		System.out.println(same);
		
	}
	
	
	
}

class Pair<K, V> {
	
    private  K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}

 
