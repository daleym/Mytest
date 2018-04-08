package com.ym.thread.synchronizednew;

/**
 * ������:synchronized
 * �ɼ��ԡ�������Դ����������
 * eg��No.1 ��������Դi����������ʱ���ܵ�synchronized��ȡʵ������������ϣ�
 *     No.2 �Ƿ��̰߳�ȫ��,��Ϊsynchronized��ȡ���ǲ�ͬʵ������������
 * @author Administrator
 *
 */
public class AccountingSync implements Runnable {

	//������Դ(�ٽ���Դ)
    static int i=0;

    /**
     * synchronized ����ʵ������
     */
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run() {
        for(int j=0;j<1000000;j++){
            increase();
        }
    }
    public static void main(String[] args) throws InterruptedException {
    	//**********No.1 start
    	/*AccountingSync instance=new AccountingSync();
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);*/
        //***********No.2 end
    	
    	//*************No.2 start
    	//new��ʵ��
        Thread t1=new Thread(new AccountingSync());
        //new��ʵ��
        Thread t2=new Thread(new AccountingSync());
        t1.start();
        t2.start();
        //join����:��ǰ�߳�A�ȴ�thread�߳���ֹ֮����ܴ�thread.join()����
        t1.join();
        t2.join();
        System.out.println(i);
    	//*************No.2 end
    }
	
}
