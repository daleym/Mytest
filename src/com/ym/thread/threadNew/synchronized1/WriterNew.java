package com.ym.thread.synchronized1;

public class WriterNew extends Thread{

	private BufferInterruptibly buff;   
	
	 
	
	    public WriterNew(BufferInterruptibly buff) {
	
	        this.buff = buff;
	
	    }   
	
	 
	
	    @Override
	
	    public void run() {
	
	        buff.write();
	
	    } 
	
}
