package com.ym.exception;

/**
 * @description 异常块  finally执行顺序
 * @author ming.yang
 */
public class TestDemo {
		
	public static void main(String[] args) {
		try{
			System.out.println(TestDemo.class.getSimpleName());
			
			throw new Exception("空指针");
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ;
		}finally{
			System.out.println("异常发生时，finally块 还是先执行了...");
		}
	}
	
}
