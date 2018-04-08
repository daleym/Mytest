package com.ym.equalsAndHashCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 重写equals方法，一般也要重写hashCode方法
 * 注意：如在hashSet添加自定义对象时，根据HashCode值来判断元素是否添加的。
 * @author ym
 *
 */
public class TestDemo {
	
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
