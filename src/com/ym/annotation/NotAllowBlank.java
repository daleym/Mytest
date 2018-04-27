package com.ym.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @description��������ע�� :������Ϊ��
 * @author ming.yang
 * @attention  targetָ��ע���ʹ�÷�Χ����Ա������������...
 			   Retention ָ��Ӧ�õĳ����� ����ʱ��...
 */
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotAllowBlank {
	
	 public int value()default 000;
	 
	 public String desc()default "hello world...";
	 
	 public String alias()default "����";
	
}
