package com.ym.designMode.proxy;

//1.��������  
public class TestTrain{  
  public void move(){  
      System.out.println("����ʻ�С�");  
  }
  
  //3.����  
  public static void main(String[] args) {  
      CGLibProxy proxy = new CGLibProxy();  
      TestTrain t = (TestTrain) proxy.getProxy(TestTrain.class);  
      t.move();  
  }
}  
 
  
