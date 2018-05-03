package com.ym.equalsAndHashCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 重写equals方法，一般也要重写hashCode方法
 * 注意：如在hashSet添加自定义对象时，首先根据HashCode值来判断元素是否可以添加。
 * eg：hashSet是不允许重复的集合！！！
 * 往hashSet中添加“自定义对象”时，首先会拿hashcode值作比较（效率高，优先比较）；
 * 若不相同，直接添加；
 * 若相同（不完全信任原则），拿equals比较（最信任原则），若不相同则添加到集合中，否则不添加！！！
 * @author ym
 *
 */
public class TestHashcodeAndEquals {
	
	public static void main(String[] args) {
		Set<User> s = new HashSet<User>();
		s.add(new User("110"));
		s.add(new User("111"));
		s.add(new User("110"));
		System.out.println(s);
	}
	
	
}

class User{
	private String identifyId;
	
	public User(String identifyId){
		this.identifyId = identifyId;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof User){
			User user = (User)obj;
			return user.identifyId.equals(this.identifyId);
		}else{
			return obj.equals(this);
		}
	}
	
	@Override
	public int hashCode(){
		return this.identifyId.hashCode();
	}
	
	@Override
	public String toString(){
		return "identifyId:"+this.identifyId;
	}
}
