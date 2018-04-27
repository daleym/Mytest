package com.ym.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description 注解应用：通过反射校验 非空字段值  
 * @author ming.yang
 * @attention  通过反射访问 成员，访问都是需要检查的（即不可访问）
 * @eg 若是带有  @see NotAllowBlank注解的成员变量，，值不能为空~~~
 */
public class TestValid {
	
	private static final Map<String,Object> notBlankFieldMaps = new HashMap<String,Object>();
	private static final Map<String,Object> blankFieldMaps = new HashMap<String,Object>();
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Student s = new Student(26,"张三");
		getFieldBeforeValid(s);
		valid(s);
	}
	
	/**
	 * 得到原始成员值（检验前）
	 * @param o
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void getFieldBeforeValid(Object o) throws IllegalArgumentException, IllegalAccessException{
		Field []  fields = o.getClass().getDeclaredFields();
		for(Field e : fields){
			boolean ifModify = false;
			if(! e.isAccessible()){
				ifModify  = true;
				e.setAccessible(true);
			}
			NotAllowBlank notAllowBlank = e.getAnnotation(NotAllowBlank.class);
			if(null != notAllowBlank){
				System.out.println(String.format("字段名称：【%s】,字段值【%s】,字段描述【%s】,字段默认值【%s】", e.getName(),e.get(o),notAllowBlank.desc(),notAllowBlank.value()));
			}
			
			if(ifModify){
				e.setAccessible(false);
			}
			System.out.println(String.format("是否可访问【%s】", e.isAccessible()?"可访问属性":"不可访问属性"));
		}
	}
	
	//校验，并输出非空  和 空字段
	public static void valid(Object o) throws IllegalArgumentException, IllegalAccessException{
		Field [] fields =  o.getClass().getDeclaredFields();
		for(Field f: fields){
			
			boolean ifModify = false;
			if(! f.isAccessible()){
				ifModify = true;
				f.setAccessible(true);
			}
			
			NotAllowBlank notAllowBlank = f.getAnnotation(NotAllowBlank.class);
			if(null != notAllowBlank  && f.get(o) != null ){
				notBlankFieldMaps.put(f.getName(),notAllowBlank.desc() );
			}else{
				blankFieldMaps.put(notAllowBlank.alias(), notAllowBlank.desc());
			}
			
			if(ifModify){
				f.setAccessible(false);
			}
			
		}
		
		System.out.println(String.format("非空map:【%s】,空map【%s】", notBlankFieldMaps,blankFieldMaps));
	}
	
}
 