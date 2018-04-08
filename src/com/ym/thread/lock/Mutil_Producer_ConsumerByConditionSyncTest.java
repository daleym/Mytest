package com.ym.thread.lock;

/**
 * ��������ģʽ��synchronized ���notify��waitʹ��
 * @author Administrator
 *
 */
public class Mutil_Producer_ConsumerByConditionSyncTest {

	 public static void main(String[] args) {
		    KaoYaResource r = new KaoYaResource();
	        Mutil_ProducerNew pro = new Mutil_ProducerNew(r);
	        Mutil_ConsumerNew con = new Mutil_ConsumerNew(r);
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
	class Mutil_ProducerNew implements Runnable {
	    private KaoYaResource r;

	    Mutil_ProducerNew(KaoYaResource r) {
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
	class Mutil_ConsumerNew implements Runnable {
	    private KaoYaResource r;

	    Mutil_ConsumerNew(KaoYaResource r) {
	        this.r = r;
	    }

	    public void run() {
	        while (true) {
	            r.consume();
	        }
	    }
	
}
