package com.ym.annotation;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��11��19�� ����1:48:58 
* ��˵�� ~~~
*/
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.SOURCE)
public @interface CheckGetter {
}
