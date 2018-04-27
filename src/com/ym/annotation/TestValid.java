package com.ym.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description ע��Ӧ�ã�ͨ������У�� �ǿ��ֶ�ֵ  
 * @author ming.yang
 * @attention  ͨ��������� ��Ա�����ʶ�����Ҫ���ģ������ɷ��ʣ�
 * @eg ���Ǵ���  @see NotAllowBlankע��ĳ�Ա��������ֵ����Ϊ��~~~
 */
public class TestValid {
	
	private static final Map<String,Object> notBlankFieldMaps = new HashMap<String,Object>();
	private static final Map<String,Object> blankFieldMaps = new HashMap<String,Object>();
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Student s = new Student(26,"����");
		getFieldBeforeValid(s);
		valid(s);
	}
	
	/**
	 * �õ�ԭʼ��Աֵ������ǰ��
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
				System.out.println(String.format("�ֶ����ƣ���%s��,�ֶ�ֵ��%s��,�ֶ�������%s��,�ֶ�Ĭ��ֵ��%s��", e.getName(),e.get(o),notAllowBlank.desc(),notAllowBlank.value()));
			}
			
			if(ifModify){
				e.setAccessible(false);
			}
			System.out.println(String.format("�Ƿ�ɷ��ʡ�%s��", e.isAccessible()?"�ɷ�������":"���ɷ�������"));
		}
	}
	
	//У�飬������ǿ�  �� ���ֶ�
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
		
		System.out.println(String.format("�ǿ�map:��%s��,��map��%s��", notBlankFieldMaps,blankFieldMaps));
	}
	
}
 