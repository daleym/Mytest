package com.ym.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @description　定义新注解 :不允许为空
 * @author ming.yang
 * @attention  target指代注解的使用范围：成员变量、构造器...
 			   Retention 指代应用的场景： 运行时、...
 */
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotAllowBlank {
	
	 public int value()default 000;
	 
	 public String desc()default "hello world...";
	 
	 public String alias()default "无名";
	
}
