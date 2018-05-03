package com.ym.equalsAndHashCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description ��дequals������һ��ҲҪ��дhashCode����
 * ע�⣺����hashSet����Զ������ʱ�����ȸ���HashCodeֵ���ж�Ԫ���Ƿ������ӡ�
 * eg��hashSet�ǲ������ظ��ļ��ϣ�����
 * ��hashSet����ӡ��Զ������ʱ�����Ȼ���hashcodeֵ���Ƚϣ�Ч�ʸߣ����ȱȽϣ���
 * ������ͬ��ֱ����ӣ�
 * ����ͬ������ȫ����ԭ�򣩣���equals�Ƚϣ�������ԭ�򣩣�������ͬ����ӵ������У�������ӣ�����
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
