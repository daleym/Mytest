package com.ym.thread.synchronized1;

public class Reader  extends Thread{

	private Buffer buff;   
	
	 
	
	    public Reader(Buffer buff) {
	
	        this.buff = buff;
	
	    }   
	
	 
	
	    @Override
	
	    public void run() {   
	
	 
	
	        buff.read();//������ƻ�һֱ����   
	
	 
	
	        System.out.println("������");   
	
	 
	
	    }
	
}
