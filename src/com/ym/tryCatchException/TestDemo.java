package com.ym.tryCatchException;

/**
 * @description 异常块  finally执行顺序
 * 				打印自定义异常信息.eg:BaseException
 * @author ming.yang
 */
public class TestDemo {
		
	public static void main(String[] args) {
		try{
			System.out.println(TestDemo.class.getSimpleName());
			
			throw new BaseException( 110 , "空指针");
		}catch(Exception e){
			System.out.println(String.format("e.getMessage()【%s】,具体异常信息【%s】" , e.getMessage() , e));
			return ;
		}finally{
			System.out.println("异常发生时，finally块 还是先执行了...");
		}
	}
	
}
