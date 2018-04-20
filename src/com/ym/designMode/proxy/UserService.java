package com.ym.designMode.proxy;

public interface UserService {

	/** 
     * 目标方法  
     */  
    public abstract void add(String content); 
    
    /** 
     * 目标方法  
     */  
    public abstract void addSpecial(String content); 
	
}
