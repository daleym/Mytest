package com.ym.dataStructuresAndAlgorithms.LinkedList;

import java.util.Scanner;

/**
 * 两个有序链表合并
 * @author Administrator
 *
 */
public class MergeSortLinkedList {
    public static void main(String args[]) {
        NewNode la, lb, lc;
        la = creat_list(5);
        lb = creat_list(4);
        lc = la;
       // print_list(la);
        //PRINT_LIST(LB);
       // merge_list(la, lb);
        print_list(merge_list(la, lb));
    }
    // 链表创建方法
    static NewNode creat_list(int n) {
        System.out.println("input "+n+" values:");
        Scanner scn = new Scanner(System.in);
        NewNode p, head = null,t = null;
        //head = new NewNode();
        //head.next = null;
        for (int i = 0; i < n; i++) {
            if(i==0){
                head =new NewNode();
                head.data=scn.nextInt();
                head.next=null;
                t=head;
                continue;
            }
           // while (t.next!=null) t=t.next;
            p = new NewNode();
            p.data = scn.nextInt();
            p.next=null;
            t.next = p;
            t=p;
        }
        return head;
    }
    static NewNode merge_list(NewNode la, NewNode lb) {
        NewNode pa, pb, pc=null,lc=null,pt;
        pa = la;
        pb = lb;
        //lc = pc;
        int i=0;
        while ((pa != null) && (pb != null)) {
            if(i==0) {
                if (pa.data <= pb.data) {
                    pc = pa;
                    pa = pa.next;
                } else {
                    pc = pb;
                    pb = pb.next;
                }
                lc=pc;
                i++;
                continue;
            }
            if (pa.data <= pb.data) {
                pc.next = pa;
                pc=pa;
                pa = pa.next;
            } else {
                pc.next = pb;
                pc=pb;
                pb = pb.next;
            }

        }
        pc.next = (pa==null)?pb:pa;
        return lc;
    }
    // 链表打印输出方法
    static void print_list(NewNode head) {
        NewNode p;
        p = head;
        while (p != null) {
            System.out.print("[" + p.data + "]");
            p = p.next;
        }
    }
}
//节点类声明
class NewNode {
    int data;
    NewNode next;
}
