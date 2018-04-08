package com.ym.designMode.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * ����ģʽ����̬����Ŀ�����û��ʵ�ֽӿڵ����
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
     * ��������Ŀ���෽���ĵ��� 
     * ������ 
     * objĿ��ʵ������ 
     *method Ŀ�귽���ķ������ 
     * args�����Ĳ��� 
     * proxy�������ʵ�� 
     */  
    @Override
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
        //��������ø���ķ���  
        System.out.println("��־��ʼ");  
        proxy.invokeSuper(obj, args);  
        System.out.println("��־����");  
        return null;  
    }  
}
