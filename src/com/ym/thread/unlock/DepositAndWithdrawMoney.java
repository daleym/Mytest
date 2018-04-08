package com.ym.thread.unlock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 存取款 操作  :  利用 atomic* 原子线程安全功能，模拟存取款操作。
 * @author ym
 * @注意点：其中，初始化存款50，然后存款1000,开启100个线程，同时取款50；那么结果，21个线程取款成功，79个线程取款失败!!!
 */
public class DepositAndWithdrawMoney {
	
	private AtomicInteger atomicInteger ;
	
	public DepositAndWithdrawMoney(int amount){
		atomicInteger = new AtomicInteger(amount);
	}
	
	//存款
	public void deposit(Integer amount){
		atomicInteger.addAndGet(amount);
	}
	
	//提现
	public void withdraw(Integer amount) throws InterruptedException{
		//无限循环... ....
		for(;;){
			int value = atomicInteger.get();
			if(atomicInteger.get() < amount){
				System.out.println("余额不足，其中，余额：【"+atomicInteger.get()+"】,取款金额【"+amount+"】,当前线程名称：【"+Thread.currentThread().getName()+"】");
				break;
			}
			
			//模拟取款时间
			Thread.sleep(5000);
			
			if(atomicInteger.compareAndSet(value, value - amount)){
				System.out.println("取款成功，其中余额：【"+atomicInteger.get()+"】，取款金额：【"+amount+"】，原金额：【"+value+"】,当前线程名称：【"+Thread.currentThread().getName()+"】");
				break;
			}
			System.out.println("前面还有人在取款，等待并再次取款,当前线程名称：【"+Thread.currentThread().getName()+"】... ...");
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
