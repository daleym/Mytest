package com.ym.dataStructuresAndAlgorithms.LinkedList;
/**************************************************************      
* Copyright (c) 2016, 
* All rights reserved.                   
* 版 本 号：v1.0                   
* 题目描述：链表中环的入口节点
*   	        一个链表中包含环，如何找出环的入口节点？例如，下图中的入口节点是3.
*   		1->2->3->4->5->6
*   			  ^  	   |
*   			  | 	   |
*   			  ----------	   
*   
* 输入描述：无
* 程序输出：环中节点数是： 4
*			链表中环的入口节点是：3
* 问题分析： 无
* 算法描述：可以用两个指针来解决这个问题。先定义两个指针P1和P2指向链表的头结点。如果链表中环有n个结点，
* 			指针P1在链表上向前移动n步，然后两个指针以相同的速度向前移动。当第二个指针指向环的入口结点时，
* 			第一个指针已经围绕着环走了一圈又回到了入口结点。
*		　　剩下的问题就是如何得到环中结点的数目。我们在面试题15的第二个相关题目时用到了一快一慢的两个指针。
*			如果两个指针相遇，表明链表中存在环。两个指针相遇的结点一定是在环中。可以从这个结点出发，
*			一边继续向前移动一边计数，当再次回到这个结点时就可以得到环中结点数了。
* 完成日期：2016-10-13
***************************************************************/ 
 
	/*
	定义一个节点
	*/
class ListNode{
	int val;
	ListNode next;
	public ListNode(){
		
	}
	public ListNode(int val){
		this.val = val;
	}
	public String toString(){
		return val + "";
	}
}
 
class SolutionMethod1{
	/*
	找到带环链表的入口节点函数
	@param head:头节点
	*/
	public ListNode EntryFunction(ListNode head){
		if(head == null){
			return null;
		}
		
		ListNode p1 = head;				//设置两个指针，使其期初都指向头节点
		ListNode p2 = head;				//设置两个指针，使其期初都指向头节点
		
		/*
		circleNode1和circleNode2都指向环中任意一个节点，通过while循环，
		计算出环中所包含的节点数
		circleNode1先固定指向环中一个节点不变，circleNode2依次向后移动，直到
		circleNode1和circleNode2再次相遇，此时circleNode2所走过的节点数即为环中包含的节点数
		*/
		ListNode circleNode1 = CircleNodeFunction(head);			
		ListNode circleNode2 = CircleNodeFunction(head).next;
		int count = 1;				//用于计算环中节点数，从1开始计数
		
		while(circleNode1 != circleNode2){
			count++;
			circleNode2 = circleNode2.next;
		}
		System.out.println("环中节点数是： " + count);				//输出环中的节点数
		/*
		使用 for循环让p2先走count步，然后再使p1和p2以相同的速度在链表上向前移动
		直到他们相遇，则相遇的节点即为环的入口节点
		*/
		for(int i = 0; i < count;i++){
			if(p2.next != null){
				p2 = p2.next;
			}
		}
		
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;			//返回环的入口节点
	}
	/*
	判断环中节点数目，可用于判断链表中是否存在环
	设置两个指针，一个走的快，一个走的慢，如果两个指针能够相遇，则说明链表中存在环，
	并且相遇的节点即为环中的一个节点。
	*/
	public ListNode CircleNodeFunction(ListNode head){			//定义ListNode型函数
		if(head == null){
			return null;
		}
		ListNode pFast = head.next.next;
		ListNode pSlow = head.next;
		
		if(pSlow == null){
			return null;
		}
		
		while(pFast != null && pSlow != null){
			if(pFast == pSlow){
				return pFast;
			}
			pSlow = pSlow.next;
			pFast = pFast.next;
			
			if(pFast != null){
				pFast = pFast.next;		//使pFast走的速度比pSlow快，这样两个节点便会相遇
			}
		}
		return null;
	}
	
}


public class CircleLinkedList {
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n3;
		 
		SolutionMethod1 solution1 = new SolutionMethod1();
		System.out.println("链表中环的入口节点是：" + solution1.EntryFunction(n1));
		
		System.out.println();
	}
}
