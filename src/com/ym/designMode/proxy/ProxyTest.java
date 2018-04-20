package com.ym.designMode.proxy;

/**
 * 动态代理：jdk继承式代理
 * @author Administrator
 *
 */
public class ProxyTest {

    public void testProxy() throws Throwable {  
        // 实例化目标对象  
        UserService userService = new UserServiceImpl();  
          
        // 实例化InvocationHandler  
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);  
          
        // 根据目标对象生成代理对象  
        UserService proxy = (UserService) invocationHandler.getProxy();  
          
        // 调用代理对象的方法  
        proxy.add("世界");  
        proxy.addSpecial("特殊的方法");
          
    }
    
    public static void main(String[] args) throws Throwable {
		new ProxyTest().testProxy();
	}
	
}
