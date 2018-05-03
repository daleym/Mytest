package com.ym.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * HashMap遍历方式之 Entry<K,V>
 * 1.相比取出遍历key，再去集合中取值，效率高！
 * 2.元素无序！
 * 3.线程不安全
 * 4.可以放入null键值
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
			System.out.println(String.format("key【%s】:value【%s】", e.getKey() , e.getValue()));
		}
 	}
}
