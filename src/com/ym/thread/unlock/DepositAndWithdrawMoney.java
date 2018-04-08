package com.ym.thread.unlock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description ��ȡ�� ����  :  ���� atomic* ԭ���̰߳�ȫ���ܣ�ģ���ȡ�������
 * @author ym
 * @ע��㣺���У���ʼ�����50��Ȼ����1000,����100���̣߳�ͬʱȡ��50����ô�����21���߳�ȡ��ɹ���79���߳�ȡ��ʧ��!!!
 */
public class DepositAndWithdrawMoney {
	
	private AtomicInteger atomicInteger ;
	
	public DepositAndWithdrawMoney(int amount){
		atomicInteger = new AtomicInteger(amount);
	}
	
	//���
	public void deposit(Integer amount){
		atomicInteger.addAndGet(amount);
	}
	
	//����
	public void withdraw(Integer amount) throws InterruptedException{
		//����ѭ��... ....
		for(;;){
			int value = atomicInteger.get();
			if(atomicInteger.get() < amount){
				System.out.println("���㣬���У�����"+atomicInteger.get()+"��,ȡ���"+amount+"��,��ǰ�߳����ƣ���"+Thread.currentThread().getName()+"��");
				break;
			}
			
			//ģ��ȡ��ʱ��
			Thread.sleep(5000);
			
			if(atomicInteger.compareAndSet(value, value - amount)){
				System.out.println("ȡ��ɹ�����������"+atomicInteger.get()+"����ȡ�����"+amount+"����ԭ����"+value+"��,��ǰ�߳����ƣ���"+Thread.currentThread().getName()+"��");
				break;
			}
			System.out.println("ǰ�滹������ȡ��ȴ����ٴ�ȡ��,��ǰ�߳����ƣ���"+Thread.currentThread().getName()+"��... ...");
		}
	}
	
	public static void main(String[] args) {
		DepositAndWithdrawMoney depositAndWithdrawMoney = new DepositAndWithdrawMoney(50);
		depositAndWithdrawMoney.deposit(1000);
		for(int i = 0 ; i< 100 ; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						depositAndWithdrawMoney.withdraw(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
