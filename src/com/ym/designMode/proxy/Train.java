package com.ym.designMode.proxy;

//1.��������  
public class Train{  
  public void move(){  
      System.out.println("����ʻ�С�");  
  }
  
  //3.����  
  public static void main(String[] args) {  
      CGLibProxy proxy = new CGLibProxy();  
      Train t = (Train) proxy.getProxy(Train.class);  
      t.move();  
  }
}  
 
  
