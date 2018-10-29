package com.ym.dataStructuresAndAlgorithms.LinkedList;
/**************************************************************      
* Copyright (c) 2016, 
* All rights reserved.                   
* �� �� �ţ�v1.0                   
* ��Ŀ�����������л�����ڽڵ�
*   	        һ�������а�����������ҳ�������ڽڵ㣿���磬��ͼ�е���ڽڵ���3.
*   		1->2->3->4->5->6
*   			  ^  	   |
*   			  | 	   |
*   			  ----------	   
*   
* ������������
* ������������нڵ����ǣ� 4
*			�����л�����ڽڵ��ǣ�3
* ��������� ��
* �㷨����������������ָ�������������⡣�ȶ�������ָ��P1��P2ָ�������ͷ��㡣��������л���n����㣬
* 			ָ��P1����������ǰ�ƶ�n����Ȼ������ָ������ͬ���ٶ���ǰ�ƶ������ڶ���ָ��ָ�򻷵���ڽ��ʱ��
* 			��һ��ָ���Ѿ�Χ���Ż�����һȦ�ֻص�����ڽ�㡣
*		����ʣ�µ����������εõ����н�����Ŀ��������������15�ĵڶ��������Ŀʱ�õ���һ��һ��������ָ�롣
*			�������ָ�����������������д��ڻ�������ָ�������Ľ��һ�����ڻ��С����Դ������������
*			һ�߼�����ǰ�ƶ�һ�߼��������ٴλص�������ʱ�Ϳ��Եõ����н�����ˡ�
* ������ڣ�2016-10-13
***************************************************************/ 
 
	/*
	����һ���ڵ�
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
	�ҵ������������ڽڵ㺯��
	@param head:ͷ�ڵ�
	*/
	public ListNode EntryFunction(ListNode head){
		if(head == null){
			return null;
		}
		
		ListNode p1 = head;				//��������ָ�룬ʹ���ڳ���ָ��ͷ�ڵ�
		ListNode p2 = head;				//��������ָ�룬ʹ���ڳ���ָ��ͷ�ڵ�
		
		/*
		circleNode1��circleNode2��ָ��������һ���ڵ㣬ͨ��whileѭ����
		����������������Ľڵ���
		circleNode1�ȹ̶�ָ����һ���ڵ㲻�䣬circleNode2��������ƶ���ֱ��
		circleNode1��circleNode2�ٴ���������ʱcircleNode2���߹��Ľڵ�����Ϊ���а����Ľڵ���
		*/
		ListNode circleNode1 = CircleNodeFunction(head);			
		ListNode circleNode2 = CircleNodeFunction(head).next;
		int count = 1;				//���ڼ��㻷�нڵ�������1��ʼ����
		
		while(circleNode1 != circleNode2){
			count++;
			circleNode2 = circleNode2.next;
		}
		System.out.println("���нڵ����ǣ� " + count);				//������еĽڵ���
		/*
		ʹ�� forѭ����p2����count����Ȼ����ʹp1��p2����ͬ���ٶ�����������ǰ�ƶ�
		ֱ�������������������Ľڵ㼴Ϊ������ڽڵ�
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
		
		return p1;			//���ػ�����ڽڵ�
	}
	/*
	�жϻ��нڵ���Ŀ���������ж��������Ƿ���ڻ�
	��������ָ�룬һ���ߵĿ죬һ���ߵ������������ָ���ܹ���������˵�������д��ڻ���
	���������Ľڵ㼴Ϊ���е�һ���ڵ㡣
	*/
	public ListNode CircleNodeFunction(ListNode head){			//����ListNode�ͺ���
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
				pFast = pFast.next;		//ʹpFast�ߵ��ٶȱ�pSlow�죬���������ڵ�������
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
		System.out.println("�����л�����ڽڵ��ǣ�" + solution1.EntryFunction(n1));
		
		System.out.println();
	}
}
