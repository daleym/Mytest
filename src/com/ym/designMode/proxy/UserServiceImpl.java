package com.ym.designMode.proxy;

public class UserServiceImpl implements UserService {

	/* (non-Javadoc) 
     * @see dynamic.proxy.UserService#add() 
     */
	@Override
    public void add(String content) {  
        System.out.println("--------------------add---------------" + content);  
    }  

}
