package com.ym.annotation;

/** 
* @author ym: 
* @version 创建时间：2019年11月19日 下午5:15:59 
* @description 通过注解处理器，生成的java源文件
*/

import java.util.function.IntBinaryOperator;

public class Bar_addAdapter implements IntBinaryOperator {
  @Override
  public int applyAsInt(int arg0, int arg1) {
    return Bar.add(arg0, arg1);
  }
}