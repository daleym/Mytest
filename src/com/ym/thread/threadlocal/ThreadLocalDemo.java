package com.ym.thread.threadLocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {

	public static void main(String []args){
        for(int i=0;i<5;i++){
            final Thread t = new Thread(){
                @Override
                public void run(){
                    System.out.println("��ǰ�߳�:"+Thread.currentThread().getName()+",�ѷ���ID:"+ThreadId.get());
                }
            };
            t.start();
        }
    }
    static   class ThreadId{
        //һ�����������У�ʹ��AtomicIngerԭ�ӱ�����֤�̰߳�ȫ
        private static final AtomicInteger nextId = new AtomicInteger(0);
        //�̱߳��ر�����Ϊÿ���̹߳���һ��Ψһ�����
        private static final ThreadLocal<Integer> threadId =
                new ThreadLocal<Integer>() {
                    @Override
                    protected Integer initialValue() {
                        return nextId.getAndIncrement();//�൱��nextId++,����nextId++���ֲ����Ǹ����ϲ�������ԭ�Ӳ����������̰߳�ȫ����(�����ڳ�ʼ��ʱ�ͻ�ȡ����ͬ��ID������ʹ��ԭ�ӱ���
                    }
                };

       //���ص�ǰ�̵߳�Ψһ�����У������һ��get�����ȵ���initialValue�����濴Դ����˽���
        public static int get() {
            return threadId.get();
        }
    }
	
}
