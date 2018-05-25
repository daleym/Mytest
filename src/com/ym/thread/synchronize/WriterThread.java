package com.ym.thread.synchronize;

public class WriterThread  extends Thread{

	private Buffer buff;   
	
	 
	
	    public WriterThread(Buffer buff) {
	
	        this.buff = buff;
	
	    }   
	
	 
	
	    @Override
	
	    public void run() {
	
	        buff.write();
	
	    }
	
}
