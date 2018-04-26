package com.ym.designMode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

	// Ŀ�����   
    private Object target;  
      
    /** 
     * ���췽�� 
     * @param target Ŀ�����  
     */  
    public MyInvocationHandler(Object target) {  
        super();  
        this.target = target;  
    }  
  
  
    /** 
     * ִ��Ŀ�����ķ��� 
     */  
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	String methodName = method.getName();
    	System.out.println(String.format("method��%s��", methodName));
    	if("addSpecial".equals(methodName)){
    		System.out.println("ִ������ķ���...");
    		method.invoke(target, args);
    		return null;
    	}
          
        // ��Ŀ�����ķ���ִ��֮ǰ�򵥵Ĵ�ӡһ��  
        System.out.println("------------------before------------------");  
          
        // ִ��Ŀ�����ķ���  
        Object result = method.invoke(target, args);  
          
        // ��Ŀ�����ķ���ִ��֮��򵥵Ĵ�ӡһ��  
        System.out.println("-------------------after------------------");  
          
        return result;  
    }  
  
    /** 
     * ��ȡĿ�����Ĵ������� 
     * @return �������� 
     */  
    public Object getProxy() {  
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),   
                target.getClass().getInterfaces(), this);  
    }  

}