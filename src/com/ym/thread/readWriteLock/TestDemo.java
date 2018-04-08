package com.ym.thread.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description 读写锁：支持读大于写的并发场景,提高系统处理速度... ...
 * @author ym
 */
public class TestDemo {
	
	public static void main(String[] args) {
		//定义用于读写的数据对象 MyData
		final MyData myData = new MyData();
		//启动三个读线程
		for(int i = 0;i<3;i++){
			new Thread(){
				@Override
				public void run(){
					while(true){
						myData.getName();
					}
				}
			}.start();
		}
		
//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//启动三个写线程
		for(int i=0 ; i < 3;i++){
			new Thread(){
				@Override
				public void run(){
					while(true){
						myData.setName();
					}
				}
			}.start();
		}
		
	}
	
}

class MyData{
	private String name = null;
	private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	
	/**
	 * 读取name值
	 * @return
	 */
	public String getName(){
		reentrantReadWriteLock.readLock().lock();
		System.out.println("准备读取name值,当前线程名称：【"+Thread.currentThread().getName()+"】... ...");
		try {
			//模拟执行时间 5s
			Thread.sleep(5000L );
			System.out.println("读取到name的值：【"+this.name+"】,当前线程名称：【"+Thread.currentThread().getName()+"】... ...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			reentrantReadWriteLock.readLock().unlock();
		}
		//模拟休息时间 3s
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.name;
	}
	
	/**
	 * 写入name的值
	 */
	public void setName(){
		reentrantReadWriteLock.writeLock().lock();
		System.out.println("准备写入name的值，当前值为：【"+this.name+"】,当前线程名称：【"+Thread.currentThread().getName()+"】");
		try {
			//模拟执行时间5s
			Thread.sleep(5000L);
			this.name = "lily";
			System.out.println("写入后的name值为：【"+this.name+"】,当前线程名称：【"+Thread.currentThread().getName()+"】");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			reentrantReadWriteLock.writeLock().unlock();
		}
		//模拟休息时间5s
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}