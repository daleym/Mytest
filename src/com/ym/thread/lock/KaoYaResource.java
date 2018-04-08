package com.ym.thread.lock;

public class KaoYaResource {

	private String name;
    private int count = 1;//��Ѽ�ĳ�ʼ����
    private boolean flag = false;//�ж��Ƿ�����Ҫ�̵߳ȴ��ı�־
    /**
     * ������Ѽ
     */
    public synchronized void product(String name){
        while(flag){
            //��ʱ�п�Ѽ���ȴ�
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name=name+count;//���ÿ�Ѽ������
        count++;
        System.out.println(Thread.currentThread().getName()+"...������..."+this.name);
        flag=true;//�п�Ѽ��ı��־
        notifyAll();//֪ͨ�����߳̿���������
    }

    /**
     * ���ѿ�Ѽ
     */
    public synchronized void consume(){
        while(!flag){//���û�п�Ѽ�͵ȴ�
            try{this.wait();}catch(InterruptedException e){}
        }
        System.out.println(Thread.currentThread().getName()+"...������........"+this.name);//���ѿ�Ѽ1
        flag = false;
        notifyAll();//֪ͨ������������Ѽ
    }
	
}
