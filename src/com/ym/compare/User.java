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
 * @description 排序器，支持MAP、LIST、SET、自定义对象（如User）的排序
 * @注意：String,Integer已支持自动排序
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
		return "【"+"name:"+this.name+",age:"+this.age+"】";
	}
	
	public static void main(String[] args) {
//		compareObject();
//		compareList();
//		compareSet();
//		compareMap();
		compareStringOrInteger();
	}
	
	/**
	 * 对象比较
	 */
	private static void compareObject(){
		User user1 = new User("lily",23); 
		User user2 = new User("dale",23); 
		User user3 = new User("linda",24); 
		System.out.println("name:"+user1.name+",name:"+user2.name+"->"+(user1.compareTo(user2)==0?"年龄一样大":(user1.compareTo(user2)==1?"前者年龄大":"前者年龄小")));
		System.out.println("name:"+user1.name+",name:"+user3.name+"->"+(user1.compareTo(user3)==0?"年龄一样大":user1.compareTo(user3)==1?"前者年龄大":"前者年龄小"));
		System.out.println("name:"+user3.name+",name:"+user1.name+"->"+(user3.compareTo(user1)==0?"年龄一样大":user3.compareTo(user1)==1?"前者年龄大":"前者年龄小"));
	}
	
	/**
	 * List集合比较
	 */
	private static void compareList(){
		User user1 = new User("lily",23); 
		User user2 = new User("dale",23); 
		User user3 = new User("linda",24);
		
		List<User> list = new ArrayList<User>();
		list.add(user3);
		list.add(user2);
		list.add(user1);
		
		System.out.println("list排序前："+list);
		Collections.sort(list);
		System.out.println("list排序后："+list);
		
		//----------------------------------------------------
		
		List<User> list2 = new ArrayList<User>();
		list2.add(user3);
		list2.add(user2);
		list2.add(user1);
		
		System.out.println("list2排序前："+list2);
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
		System.out.println("list2排序后："+list2+",花费时间(纳秒级)："+(endTime  - startTime));
	}
	
	/**
	 * Set集合排序
	 */
	private static void compareSet(){
		Set<User> s = new HashSet<User>();
		s.add(new User("Lily",23));
		s.add(new User("dale",23));
		s.add(new User("Linda",28));
		
		List<User> list = new ArrayList<User>(s);
		System.out.println("Set排序前:"+list);
		Collections.sort(list);
		System.out.println("Set排序后:"+list);
	}
	
	/**
	 * Map排序
	 */
	private static void compareMap(){
		Map<String,User> map = new HashMap<String,User>();
		map.put("2", new User("Lily", 23));
		map.put("3", new User("Dale", 23));
		map.put("1", new User("Linda", 25));
		
		System.out.println("HashMap排序前："+map);
		System.out.println("treeMap自动排序"+new TreeMap<String,User>(map));
		
		//------------------------------------------------------------------
		Map<String,User> map2 = new HashMap<String,User>();
		map2.put("2", new User("Lily", 23));
		map2.put("3", new User("Dale", 23));
		map2.put("1", new User("Linda", 25));
		Set<Entry<String, User>> set = map2.entrySet();
		List<Entry<String,User>> list = new ArrayList<Entry<String,User>>(set);
		System.out.println("Map2排序前："+map2);
		Collections.sort(list,new Comparator<Entry<String, User>>() {

			@Override
			public int compare(Entry<String, User> e1, Entry<String, User> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		System.out.println("Map2排序后："+list);
		
	}
	
	/**
	 * 字符串排序
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
		System.out.println("排序前"+list);
		Collections.sort(list);
		System.out.println("排序后"+list);
	}
	
}
