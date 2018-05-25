package com.ym.thread.synchronize;

public class WriterByReentrantLockThread extends Thread{

	private BufferInterruptibly buff;   
	
	 
	
	    public WriterByReentrantLockThread(BufferInterruptibly buff) {
	
	        this.buff = buff;
	
	    }   
	
	 
	
	    @Override
	
	    public void run() {
	
	        buff.write();
	
	    } 
	
}
