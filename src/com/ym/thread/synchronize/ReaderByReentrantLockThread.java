package com.ym.thread.synchronize;

public class ReaderByReentrantLockThread extends Thread {

	private BufferInterruptibly buff;   
	
	 
	
	    public ReaderByReentrantLockThread(BufferInterruptibly buff) {
	
	        this.buff = buff;
	
	    }   
	
	 

	    @Override
	
	    public void run() {   
	
	 
	
	        try {
	
	            buff.read();//�����յ��жϵ��쳣���Ӷ���Ч�˳�
	
	        } catch (InterruptedException e) {
	
	            System.out.println("�Ҳ�����");
	
	        }   
	
	 
	
	        System.out.println("������");   
	
	 
	
	    }
	
}