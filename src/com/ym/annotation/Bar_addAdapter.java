package com.ym.annotation;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��11��19�� ����5:15:59 
* @description ͨ��ע�⴦���������ɵ�javaԴ�ļ�
*/

import java.util.function.IntBinaryOperator;

public class Bar_addAdapter implements IntBinaryOperator {
  @Override
  public int applyAsInt(int arg0, int arg1) {
    return Bar.add(arg0, arg1);
  }
}