package com.ym.tryCatchException;

/**
 * @description �쳣��  finallyִ��˳��
 * 				��ӡ�Զ����쳣��Ϣ.eg:BaseException
 * @author ming.yang
 */
public class TestDemo {
		
	public static void main(String[] args) {
		try{
			System.out.println(TestDemo.class.getSimpleName());
			
			throw new BaseException( 110 , "��ָ��");
		}catch(Exception e){
			System.out.println(String.format("e.getMessage()��%s��,�����쳣��Ϣ��%s��" , e.getMessage() , e));
			return ;
		}finally{
			System.out.println("�쳣����ʱ��finally�� ������ִ����...");
		}
	}
	
}
