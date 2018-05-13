package com.ym.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;


/**
 * ��Ҫ����curator-client��curator-framework��curator-recipes����jar����
 * ʹ��zk�Ŀͻ��˿�Դ��  Curator
 * �ֲ�ʽ����ʹ�ã�
 *            �ص��ǻ�ȡ����mutex.acquire���ͷ�����mutex.release
 * Դ�������
 * driver.createsTheLock��������ʱ��������ӽڵ㣬����ʵ�ֱȽϼ򵥲���չ������Ҫ��ע���ֽڵ��ģʽ��
 * 1��PERSISTENT�����ã���2��PERSISTENT_SEQUENTIAL�����������򣩣�
 * 3��EPHEMERAL����ʱ����4��EPHEMERAL_SEQUENTIAL����ʱ�����򣩡�
     internalLockLoop�������ȴ�ֱ���������
             ��������������ȴ���ʱ��
             �ȴ�ʱ�䵽�ɾ����Ӧ���ӽڵ�
     
 * @author Administrator
 *
 */
public class TestCurator {

	public static void main(String[] args) throws Exception {

		//����zookeeper�Ŀͻ���

		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

		CuratorFramework client = CuratorFrameworkFactory.newClient("10.21.41.181:2181,10.21.42.47:2181,10.21.49.252:2181", retryPolicy);

		client.start();

		//�����ֲ�ʽ��, ���ռ�ĸ��ڵ�·��Ϊ/curator/lock

		InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");

		mutex.acquire();

		//�������, ����ҵ������

		System.out.println("Enter mutex");

		//���ҵ������, �ͷ���

		mutex.release();

		//�رտͻ���

		client.close();

		}
	
}
