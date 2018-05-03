package com.ym.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap������ʽ֮ Entry<K,V>
 * 1.���ȡ������key����ȥ������ȡֵ��Ч�ʸߣ�
 * 2.Ԫ������
 * 3.�̲߳���ȫ
 * 4.���Է���null��ֵ
 * @author Administrator
 *
 */
public class TestMap {

	public static void main(String[] args) {
		
		Map<String,String> maps = new HashMap<>();
		maps.put("second", "dale");
		maps.put("first", "lily");
		maps.put(null, null);
		Set<Entry<String ,String>> entrySet = maps.entrySet();
		for(Entry< String , String > e : entrySet){
			System.out.println(String.format("key��%s��:value��%s��", e.getKey() , e.getValue()));
		}
 	}
}
