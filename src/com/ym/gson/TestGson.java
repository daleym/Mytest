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
* @version ����ʱ�䣺2019��8��21�� ����1:51:15 
* @description Gson�����Ŀ�
* 				>�����ڲ���,gson�������ˣ����No1��
* 				>>ʵ��listsû�о����������ͣ���ôgson����ʱ������ͨ����������õ�����ֵ~~~
* 				>�������ԣ�gson�������ˣ����No2��
* 				>>gson���䣬ͨ����Set<Entry<String,String>>��������ͣ���û������Ԫ�أ�<K,V>��,��ô��Ȼ�ò�������ֵ~~~
*/

public class TestGson {

	static Gson gson = MyGsonBuilder.createNewGson(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss"));
	
	/**
	 * ��������
	 *  null
		["anan~~~","lily~~~","anan~~~"]
		[{},{}]
	 * @param args
	 */
	public static void main(String[] args) {
		//No1
		List<String> lists = TestInitList.initByAnonymousInnerClass();
		System.out.println(gson.toJson(lists));
		//�����ʽ
		System.out.println(gson.toJson(new ArrayList<>(lists)));
		
		//No2
		Map<String,String> maps = TestInitMap.initByAnonymousInnerClass();
		Set<Entry<String ,String>> entrys = maps.entrySet();
		System.out.println(gson.toJson(entrys));
	}
	
}
