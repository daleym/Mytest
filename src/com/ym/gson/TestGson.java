package com.ym.gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ym.collection.TestInitList;
import com.ym.collection.TestInitMap;
import com.ym.utils.MyGsonBuilder;

/** 
* @author ym: 
* @version 创建时间：2019年8月21日 下午1:51:15 
* @description Gson常见的坑
* 				>匿名内部类,gson解析不了（详见No1）
* 				>>实例lists没有具体的类的类型，那么gson反射时，不能通过类的类型拿到属性值~~~
* 				>匿名属性，gson解析不了（详见No2）
* 				>>gson反射，通过类Set<Entry<String,String>>的类的类型，但没有数组元素（<K,V>）,那么依然拿不到属性值~~~
*/

public class TestGson {

	static Gson gson = MyGsonBuilder.createNewGson(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss"));
	
	/**
	 * 输出结果：
	 *  null
		["anan~~~","lily~~~","anan~~~"]
		[{},{}]
	 * @param args
	 */
	public static void main(String[] args) {
		//No1
		List<String> lists = TestInitList.initByAnonymousInnerClass();
		System.out.println(gson.toJson(lists));
		//解决方式
		System.out.println(gson.toJson(new ArrayList<>(lists)));
		
		//No2
		Map<String,String> maps = TestInitMap.initByAnonymousInnerClass();
		Set<Entry<String ,String>> entrys = maps.entrySet();
		System.out.println(gson.toJson(entrys));
	}
	
}
