package com.ym.thread.synchronize;

public class ReaderThread  extends Thread{

	private Buffer buff;   
	
	 
	
	    public ReaderThread(Buffer buff) {
	
	        this.buff = buff;
	
	    }   
	
	 
	
	    @Override
	
	    public void run() {   
	
	 
	
	        buff.read();//������ƻ�һֱ����   
	
	 
	
	        System.out.println("������");   
	
	 
	
	    }
	
}
