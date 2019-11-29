package com.ym.annotation;

/** 
* @author ym: 
* @version 创建时间：2019年11月19日 下午1:48:58 
* 类说明 ~~~
*/
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.SOURCE)
public @interface CheckGetter {
}
