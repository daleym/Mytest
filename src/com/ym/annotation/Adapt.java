package com.ym.annotation;

/** 
* @author ym: 
* @version 创建时间：2019年11月19日 下午4:36:35 
* 类说明 ~~~
*/


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Adapt {
  Class<?> value();
}
