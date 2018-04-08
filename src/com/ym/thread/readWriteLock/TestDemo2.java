package com.ym.thread.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description 读写锁 模拟缓存器
 * @author ym
 */
public class TestDemo2 {
	
	private static Map<String,String> maps = new HashMap<String,String>();
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	static {
		maps.put("name", "lily");
		maps.put("address", "shenzhen");
		maps.put("age", "18");
	}
	
	public static String getValueFromMap(String key){
		
		//模拟休息5s
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try{
			//加读锁
			readWriteLock.readLock().lock();
			if(maps.containsKey(key)){
				return maps.get(key);
			}else{
				try{
					//加写锁（先减读锁）
					readWriteLock.readLock().unlock();
					readWriteLock.writeLock().lock();
					if(! maps.containsKey(key)){
						maps.put(key, key);
						
					}
				}finally{
					//减写锁
					readWriteLock.writeLock().unlock();
				}
				
				//加读锁
				readWriteLock.readLock().lock();
				return maps.get(key);
			}
		}finally{
			//减读锁
			readWriteLock.readLock().unlock();
		}
		
	}
	
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run(){
				while(true){
					System.out.println("键：【name】,值：【"+getValueFromMap("name") +"】,当前的线程名称：【"+Thread.currentThread().getName()+"】");
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				while(true){
					System.out.println("键：【address】,值：【"+getValueFromMap("address") +"】,当前的线程名称：【"+Thread.currentThread().getName()+"】");
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				while(true){
					System.out.println(getValueFromMap("键：【ages】,值：【"+getValueFromMap("ages")+"】") +",当前的线程名称：【"+Thread.currentThread().getName()+"】");
				}
			}
		}.start();
	}
	
}
