package com.ym.thread.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description ��д�� ģ�⻺����
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
		
		//ģ����Ϣ5s
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try{
			//�Ӷ���
			readWriteLock.readLock().lock();
			if(maps.containsKey(key)){
				return maps.get(key);
			}else{
				try{
					//��д�����ȼ�������
					readWriteLock.readLock().unlock();
					readWriteLock.writeLock().lock();
					if(! maps.containsKey(key)){
						maps.put(key, key);
						
					}
				}finally{
					//��д��
					readWriteLock.writeLock().unlock();
				}
				
				//�Ӷ���
				readWriteLock.readLock().lock();
				return maps.get(key);
			}
		}finally{
			//������
			readWriteLock.readLock().unlock();
		}
		
	}
	
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run(){
				while(true){
					System.out.println("������name��,ֵ����"+getValueFromMap("name") +"��,��ǰ���߳����ƣ���"+Thread.currentThread().getName()+"��");
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				while(true){
					System.out.println("������address��,ֵ����"+getValueFromMap("address") +"��,��ǰ���߳����ƣ���"+Thread.currentThread().getName()+"��");
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				while(true){
					System.out.println(getValueFromMap("������ages��,ֵ����"+getValueFromMap("ages")+"��") +",��ǰ���߳����ƣ���"+Thread.currentThread().getName()+"��");
				}
			}
		}.start();
	}
	
}
