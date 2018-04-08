package com.ym.JVM;

/**
 * 线程安全：volatile 共享变量内存可见性 、防止指令重排序
 * @author Administrator
 *
 */
public class MixedOrder{
    int a = 0;
    volatile boolean flag = false;
    public void writer(){
        a = 1;
        flag = true;
    }

    public int read(){
        if(flag){
            int i = a + 1;
            return i;
        }
        return -1;
        
    }
    
    public static void main(String[] args) {
    	MixedOrder mixedOrder = new MixedOrder();
    	
    	new Thread(() -> {
    		try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mixedOrder.writer();
		}).start();
    	
    	new Thread(() -> {
    		
			System.out.println(mixedOrder.read());
		}).start();
		
		
	}
}
