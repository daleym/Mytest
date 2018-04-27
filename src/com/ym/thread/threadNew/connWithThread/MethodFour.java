package com.ym.thread.connWithThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程通信之 栅栏
 * @author Administrator
 *
 */
public class MethodFour {

	 private final CyclicBarrier barrier;  
     private final List<String> list;  
     public MethodFour() {  
         list = Collections.synchronizedList(new ArrayList<String>());//集合对象线程安全化
         barrier = new CyclicBarrier(2,newBarrierAction());  
     }  
     public Runnable newThreadOne() {  
         final String[] inputArr = Helper.buildNoArr(52);  
         return new Runnable() {  
             private String[] arr = inputArr;  
             public void run() {  
                 for (int i = 0, j=0; i < arr.length; i=i+2,j++) {  
                     try {  
                         list.add(arr[i]);  
                         list.add(arr[i+1]);  
                         barrier.await();  
                     } catch (InterruptedException | BrokenBarrierException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
         };  
     }  
     public Runnable newThreadTwo() {  
         final String[] inputArr = Helper.buildCharArr(26);  
         return new Runnable() {  
             private String[] arr = inputArr;  
             public void run() {  
                 for (int i = 0; i < arr.length; i++) {  
                     try {  
                         list.add(arr[i]);  
                         barrier.await();  
                     } catch (InterruptedException | BrokenBarrierException e) {  
                         e.printStackTrace();  
                     }  
                 }  
             }  
         };  
     }  
     private Runnable newBarrierAction(){  
         return new Runnable() {  
             @Override  
             public void run() {  
                 Collections.sort(list);  
//                 list.forEach(c->System.out.print(c));
                 for(String c : list){
                	 System.out.println(c);
                 }
                 list.clear();  
             }  
         };  
     }  
     public static void main(String args[]){  
         MethodFour four = new MethodFour();  
         Helper.instance.run(four.newThreadOne());  
         Helper.instance.run(four.newThreadTwo());  
         Helper.instance.shutdown();  
     }
	
}
