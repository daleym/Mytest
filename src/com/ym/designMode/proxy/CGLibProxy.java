package com.ym.designMode.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 代理模式：动态代理，目标对象没有实现接口的情况
 * @author Administrator
 *
 */
public class CGLibProxy implements MethodInterceptor {  
    private Enhancer enhancer = new Enhancer();  
    public Object getProxy(Class<?> clazz){  
        enhancer.setSuperclass(clazz);  
        enhancer.setCallback(this);  
        return enhancer.create();  
    }  
    /** 
     * 拦截所有目标类方法的调用 
     * 参数： 
     * obj目标实例对象 
     *method 目标方法的反射对象 
     * args方法的参数 
     * proxy代理类的实例 
     */  
    @Override
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
        //代理类调用父类的方法  
        System.out.println("日志开始");  
        proxy.invokeSuper(obj, args);  
        System.out.println("日志结束");  
        return null;  
    }  
}
