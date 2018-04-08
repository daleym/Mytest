package com.ym.JVM;

/**
 * Created by zejian on 2017/6/11.
 * Blog : http://blog.csdn.net/javazejian [ԭ�ĵ�ַ,������ԭ��]
 * ���̰߳�ȫ����ָ���������£�
 * ���� ����˫����漰ģʽ
 */
public class DoubleCheckLock {

    private static DoubleCheckLock instance;

    private DoubleCheckLock(){}

    public static DoubleCheckLock getInstance(){

        //��һ�μ��
        if (instance==null){
            //ͬ��
            synchronized (DoubleCheckLock.class){
                if (instance == null){
                    //���̻߳����¿��ܻ��������ĵط�
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
    
    public static void main(String[] args) {
    	new Thread(() -> {
    		try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println(DoubleCheckLock.getInstance().hashCode());
		}).start();
    	
    	new Thread(() -> {
    		try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println(DoubleCheckLock.getInstance().hashCode());
		}).start();
	}
}
