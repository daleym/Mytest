package com.ym.thread.unlock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description 计数器：原子级线程安全
 * @author ym
 */
public class Counter {
	
	private static final AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(1);
	private static  AtomicInteger atomicInteger = new AtomicInteger(0);
	//增加
	public Integer increase(){
		atomicReference.set(atomicInteger.incrementAndGet());
		return atomicReference.get();
	}
	
	public static void main(String[] args) {
		final Counter counter = new Counter();
		for(int i = 0 ;i < 1000 ; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(counter.increase());
				}
			}).start();
		}
	}
}
