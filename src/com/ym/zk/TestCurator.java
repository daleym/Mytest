package com.ym.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;


/**
 * 需要引入curator-client、curator-framework、curator-recipes三个jar包！
 * 使用zk的客户端开源库  Curator
 * 分布式锁的使用：
 *            重点是获取锁：mutex.acquire，释放锁：mutex.release
 * 源码分析：
 * driver.createsTheLock：创建临时且有序的子节点，里面实现比较简单不做展开，主要关注几种节点的模式：
 * 1）PERSISTENT（永久）；2）PERSISTENT_SEQUENTIAL（永久且有序）；
 * 3）EPHEMERAL（临时）；4）EPHEMERAL_SEQUENTIAL（临时且有序）。
     internalLockLoop：阻塞等待直到获得锁。
             如果设置了阻塞等待的时间
             等待时间到达，删除对应的子节点
     
 * @author Administrator
 *
 */
public class TestCurator {

	public static void main(String[] args) throws Exception {

		//创建zookeeper的客户端

		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

		CuratorFramework client = CuratorFrameworkFactory.newClient("10.21.41.181:2181,10.21.42.47:2181,10.21.49.252:2181", retryPolicy);

		client.start();

		//创建分布式锁, 锁空间的根节点路径为/curator/lock

		InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");

		mutex.acquire();

		//获得了锁, 进行业务流程

		System.out.println("Enter mutex");

		//完成业务流程, 释放锁

		mutex.release();

		//关闭客户端

		client.close();

		}
	
}
