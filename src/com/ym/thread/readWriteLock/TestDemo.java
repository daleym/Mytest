package com.ym.thread.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description ��д����֧�ֶ�����д�Ĳ�������,���ϵͳ�����ٶ�... ...
 * @author ym
 */
public class TestDemo {
	
	public static void main(String[] args) {
		//�������ڶ�д�����ݶ��� MyData
		final MyData myData = new MyData();
		//�����������߳�
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
		
		//��������д�߳�
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
	 * ��ȡnameֵ
	 * @return
	 */
	public String getName(){
		reentrantReadWriteLock.readLock().lock();
		System.out.println("׼����ȡnameֵ,��ǰ�߳����ƣ���"+Thread.currentThread().getName()+"��... ...");
		try {
			//ģ��ִ��ʱ�� 5s
			Thread.sleep(5000L );
			System.out.println("��ȡ��name��ֵ����"+this.name+"��,��ǰ�߳����ƣ���"+Thread.currentThread().getName()+"��... ...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			reentrantReadWriteLock.readLock().unlock();
		}
		//ģ����Ϣʱ�� 3s
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.name;
	}
	
	/**
	 * д��name��ֵ
	 */
	public void setName(){
		reentrantReadWriteLock.writeLock().lock();
		System.out.println("׼��д��name��ֵ����ǰֵΪ����"+this.name+"��,��ǰ�߳����ƣ���"+Thread.currentThread().getName()+"��");
		try {
			//ģ��ִ��ʱ��5s
			Thread.sleep(5000L);
			this.name = "lily";
			System.out.println("д����nameֵΪ����"+this.name+"��,��ǰ�߳����ƣ���"+Thread.currentThread().getName()+"��");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			reentrantReadWriteLock.writeLock().unlock();
		}
		//ģ����Ϣʱ��5s
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}