package com.ym.annotation;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��11��19�� ����4:36:35 
* ��˵�� ~~~
*/


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Adapt {
  Class<?> value();
}
