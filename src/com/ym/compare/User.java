package com.ym.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @description ��������֧��MAP��LIST��SET���Զ��������User��������
 * @ע�⣺String,Integer��֧���Զ�����
 * @author ym
 *
 */
public class User implements Comparable<User> {
	
	private String name ;
	private Integer age;
	
	public User(String name ,int age){
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(User user){
		if(this.age < user.age){
			return -1;
		}else if(this.age == user.age){
			return 0;
		}else if(this.age > user.age){
			return 1;
		}else{
			return this.name.compareTo(user.name);
		}
	}
	
	@Override
	public String toString(){
		return "��"+"name:"+this.name+",age:"+this.age+"��";
	}
	
	public static void main(String[] args) {
//		compareObject();
//		compareList();
//		compareSet();
//		compareMap();
		compareStringOrInteger();
	}
	
	/**
	 * ����Ƚ�
	 */
	private static void compareObject(){
		User user1 = new User("lily",23); 
		User user2 = new User("dale",23); 
		User user3 = new User("linda",24); 
		System.out.println("name:"+user1.name+",name:"+user2.name+"->"+(user1.compareTo(user2)==0?"����һ����":(user1.compareTo(user2)==1?"ǰ�������":"ǰ������С")));
		System.out.println("name:"+user1.name+",name:"+user3.name+"->"+(user1.compareTo(user3)==0?"����һ����":user1.compareTo(user3)==1?"ǰ�������":"ǰ������С"));
		System.out.println("name:"+user3.name+",name:"+user1.name+"->"+(user3.compareTo(user1)==0?"����һ����":user3.compareTo(user1)==1?"ǰ�������":"ǰ������С"));
	}
	
	/**
	 * List���ϱȽ�
	 */
	private static void compareList(){
		User user1 = new User("lily",23); 
		User user2 = new User("dale",23); 
		User user3 = new User("linda",24);
		
		List<User> list = new ArrayList<User>();
		list.add(user3);
		list.add(user2);
		list.add(user1);
		
		System.out.println("list����ǰ��"+list);
		Collections.sort(list);
		System.out.println("list�����"+list);
		
		//----------------------------------------------------
		
		List<User> list2 = new ArrayList<User>();
		list2.add(user3);
		list2.add(user2);
		list2.add(user1);
		
		System.out.println("list2����ǰ��"+list2);
		long startTime = System.nanoTime();
		Collections.sort(list2,new Comparator<User>() {

			@Override
			public int compare(User o,User user) {
				if(o.age < user.age){
					return -1;
				}else if(o.age == user.age){
					return 0;
				}else if(o.age > user.age){
					return 1;
				}else{
					return o.name.compareTo(user.name);
				}
			}
		});
		long endTime = System.nanoTime();
		System.out.println("list2�����"+list2+",����ʱ��(���뼶)��"+(endTime  - startTime));
	}
	
	/**
	 * Set��������
	 */
	private static void compareSet(){
		Set<User> s = new HashSet<User>();
		s.add(new User("Lily",23));
		s.add(new User("dale",23));
		s.add(new User("Linda",28));
		
		List<User> list = new ArrayList<User>(s);
		System.out.println("Set����ǰ:"+list);
		Collections.sort(list);
		System.out.println("Set�����:"+list);
	}
	
	/**
	 * Map����
	 */
	private static void compareMap(){
		Map<String,User> map = new HashMap<String,User>();
		map.put("2", new User("Lily", 23));
		map.put("3", new User("Dale", 23));
		map.put("1", new User("Linda", 25));
		
		System.out.println("HashMap����ǰ��"+map);
		System.out.println("treeMap�Զ�����"+new TreeMap<String,User>(map));
		
		//------------------------------------------------------------------
		Map<String,User> map2 = new HashMap<String,User>();
		map2.put("2", new User("Lily", 23));
		map2.put("3", new User("Dale", 23));
		map2.put("1", new User("Linda", 25));
		Set<Entry<String, User>> set = map2.entrySet();
		List<Entry<String,User>> list = new ArrayList<Entry<String,User>>(set);
		System.out.println("Map2����ǰ��"+map2);
		Collections.sort(list,new Comparator<Entry<String, User>>() {

			@Override
			public int compare(Entry<String, User> e1, Entry<String, User> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		System.out.println("Map2�����"+list);
		
	}
	
	/**
	 * �ַ�������
	 */
	private static void compareStringOrInteger(){
		List<String> list = new ArrayList<String>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 5284736630987089618L;

			{
				this.add("1");
				this.add("5");
				this.add("3");
			}
		};
		System.out.println("����ǰ"+list);
		Collections.sort(list);
		System.out.println("�����"+list);
	}
	
}
