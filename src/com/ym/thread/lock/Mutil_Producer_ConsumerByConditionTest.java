package com.ym.thread.lock;

/**
 * ����QAS����������ģʽ����ռ��-�ȴ�����ConditionObject(�ȴ����ѻ���)
 * @author Administrator
 *
 */
public class Mutil_Producer_ConsumerByConditionTest {

	 public static void main(String[] args) {
	        ResourceByCondition r = new ResourceByCondition();
	        Mutil_Producer pro = new Mutil_Producer(r);
	        Mutil_Consumer con = new Mutil_Consumer(r);
	        //�������߳�
	        Thread t0 = new Thread(pro);
	        Thread t1 = new Thread(pro);
	        //�������߳�
	        Thread t2 = new Thread(con);
	        Thread t3 = new Thread(con);
	        //�����߳�
	        t0.start();
	        t1.start();
	        t2.start();
	        t3.start();
	    }
	}

	/**
	 * @decrition �������߳�
	 */
	class Mutil_Producer implements Runnable {
	    private ResourceByCondition r;

	    Mutil_Producer(ResourceByCondition r) {
	        this.r = r;
	    }

	    public void run() {
	        while (true) {
	            r.product("������Ѽ");
	        }
	    }
	}

	/**
	 * @decrition �������߳�
	 */
	class Mutil_Consumer implements Runnable {
	    private ResourceByCondition r;

	    Mutil_Consumer(ResourceByCondition r) {
	        this.r = r;
	    }

	    public void run() {
	        while (true) {
	            r.consume();
	        }
	    }
	
}
