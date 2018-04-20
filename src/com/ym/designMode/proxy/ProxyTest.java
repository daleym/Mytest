package com.ym.designMode.proxy;

/**
 * ��̬����jdk�̳�ʽ����
 * @author Administrator
 *
 */
public class ProxyTest {

    public void testProxy() throws Throwable {  
        // ʵ����Ŀ�����  
        UserService userService = new UserServiceImpl();  
          
        // ʵ����InvocationHandler  
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);  
          
        // ����Ŀ��������ɴ������  
        UserService proxy = (UserService) invocationHandler.getProxy();  
          
        // ���ô������ķ���  
        proxy.add("����");  
        proxy.addSpecial("����ķ���");
          
    }
    
    public static void main(String[] args) throws Throwable {
		new ProxyTest().testProxy();
	}
	
}
