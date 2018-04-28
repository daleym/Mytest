package com.ym.spring.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)         
@Retention(value = RetentionPolicy.RUNTIME) 
@Documented                                 
public @interface AuthValidate {            
                                            
    /**                                     
     *                                      
     * ������Ȩ�޶���                       
     * @author mao2080@sina.com             
     * @created 2017��5��8�� ����11:36:41   
     * @since                               
     * @return Ȩ�޴���                     
     */                                     
    AuthCode value() default AuthCode.Allow;
                                            
}                                           
