package com.ym.exception;

/**
 * @description �쳣��  finallyִ��˳��
 * @author ming.yang
 */
public class TestDemo {
		
	public static void main(String[] args) {
		try{
			System.out.println(TestDemo.class.getSimpleName());
			
			throw new Exception("��ָ��");
		}catch(Exception e){
			System.out.println(e.getMessage());
			return ;
		}finally{
			System.out.println("�쳣����ʱ��finally�� ������ִ����...");
		}
	}
	
}
