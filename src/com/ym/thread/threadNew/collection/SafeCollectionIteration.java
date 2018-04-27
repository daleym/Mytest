package com.ym.thread.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SafeCollectionIteration {

	public static void main(String[] args) {
        //Ϊ�˰�ȫ�������ʹ��ͬ���б��һ�����ã���������ȷ�����������з���
        //���ϱ���ͬ������������һ��List
        List wordList = Collections.synchronizedList(new ArrayList());
 
        //wordList�е�add������ͬ�����������ȡwordListʵ���Ķ�����
        wordList.add("Iterators");
        wordList.add("require");
        wordList.add("special");
        wordList.add("handling");
 
        //��ȡwordListʵ���Ķ�������
        //����ʱ�����������̵߳���add��remove�ȷ����޸�Ԫ��
        synchronized ( wordList ) {
            Iterator iter = wordList.iterator();
            while ( iter.hasNext() ) {
                String s = (String) iter.next();
                System.out.println("found string: " + s + ", length=" + s.length());
            }
        }
    }
	
}
