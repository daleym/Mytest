package com.ym.thread.threadNew.synchronized1;

public class Writer  extends Thread{

	private Buffer buff;   
	
	 
	
	    public Writer(Buffer buff) {
	
	        this.buff = buff;
	
	    }   
	
	 
	
	    @Override
	
	    public void run() {
	
	        buff.write();
	
	    }
	
}
