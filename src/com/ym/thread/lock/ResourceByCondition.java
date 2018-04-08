package com.ym.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ��������ģʽ��conditionӦ��
 * @author Administrator
 *
 */
public class ResourceByCondition {

	private String name;
    private int count = 1;
    private boolean flag = false;

    //����һ��������
    Lock lock = new ReentrantLock();

    //ͨ�����е�����ȡ�����������һ����������ߣ�һ����������ߡ�
    Condition producer_con = lock.newCondition();
    Condition consumer_con = lock.newCondition();

    /**
     * ����
     * @param name
     */
    public  void product(String name)
    {
        lock.lock();
        try
        {
            while(flag){
                try{producer_con.await();}catch(InterruptedException e){}
            }
            this.name = name + count;
            count++;
            System.out.println(Thread.currentThread().getName()+"...������5.0..."+this.name);
            flag = true;
            consumer_con.signal();//ֱ�ӻ��������߳�
        }
        finally
        {
            lock.unlock();
        }
    }

    /**
     * ����
     */
    public  void consume()
    {
        lock.lock();
        try
        {
            while(!flag){
                try{consumer_con.await();}catch(InterruptedException e){}
            }
            System.out.println(Thread.currentThread().getName()+"...������.5.0......."+this.name);//���ѿ�Ѽ1
            flag = false;
            producer_con.signal();//ֱ�ӻ��������߳�
        }
        finally
        {
            lock.unlock();
        }
    }
	
}
