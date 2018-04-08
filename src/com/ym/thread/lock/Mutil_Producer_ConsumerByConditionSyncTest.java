package com.ym.thread.lock;

/**
 * 生产消费模式：synchronized 结合notify和wait使用
 * @author Administrator
 *
 */
public class Mutil_Producer_ConsumerByConditionSyncTest {

	 public static void main(String[] args) {
		    KaoYaResource r = new KaoYaResource();
	        Mutil_ProducerNew pro = new Mutil_ProducerNew(r);
	        Mutil_ConsumerNew con = new Mutil_ConsumerNew(r);
	        //生产者线程
	        Thread t0 = new Thread(pro);
	        Thread t1 = new Thread(pro);
	        //消费者线程
	        Thread t2 = new Thread(con);
	        Thread t3 = new Thread(con);
	        //启动线程
	        t0.start();
	        t1.start();
	        t2.start();
	        t3.start();
	    }
	}

	/**
	 * @decrition 生产者线程
	 */
	class Mutil_ProducerNew implements Runnable {
	    private KaoYaResource r;

	    Mutil_ProducerNew(KaoYaResource r) {
	        this.r = r;
	    }

	    public void run() {
	        while (true) {
	            r.product("北京烤鸭");
	        }
	    }
	}

	/**
	 * @decrition 消费者线程
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
