package com.ym.designMode.proxy;

//1.具体主题  
public class TestTrain{  
  public void move(){  
      System.out.println("火车行驶中…");  
  }
  
  //3.测试  
  public static void main(String[] args) {  
      CGLibProxy proxy = new CGLibProxy();  
      TestTrain t = (TestTrain) proxy.getProxy(TestTrain.class);  
      t.move();  
  }
}  
 
  
