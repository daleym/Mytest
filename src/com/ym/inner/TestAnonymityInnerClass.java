package com.ym.inner;

import com.ym.thread.daemon.Test;

/** 
* @author ym: 
* @version ����ʱ�䣺2019��7��30�� ����3:34:51 
* @description �����ڲ��� 
* 					ʵ�ַ�ʽ���ӿ�ʵ��     InnerClass 
* 						         ��ͨ��ʵ�� Inner2Class
* 						         ������ʵ��  Inner3Class
* 					�ô������಻�ؼ̳С�ʵ�֣�ʵ�����⻯����~~~
* 
* �����:
* 	Inner2Class.class
* 	Inner3Class.class
* 	InnerClass.class
* TestAnonymityInnerClass$1.class  �����ڲ��� 
* TestAnonymityInnerClass$2.class   �����ڲ��� 
* TestAnonymityInnerClass$3.class    �����ڲ��� 
* TestAnonymityInnerClass.class
*/

public class TestAnonymityInnerClass {

	public void output(){
		//InnerClass -------start
		//�����ڲ���
		InnerClass innerClass = new InnerClass() {
			
			@Override
			public void outputAddress() {
				System.out.println("hello world~~~");
			}
		};
		innerClass.outputAddress();
		//InnerClass -------end
		
		//Inner2Class --------start
		Inner2Class inner2Class = new Inner2Class(){
			@Override
			public void outputAddress(){
				System.out.println("hello anan~~~");
			}
		};
		inner2Class.outputAddress();
		//Inner2Class --------end
		
		//Inner3Class ------start
		Inner3Class inner3Class = new Inner3Class() {
			
			@Override
			public void outputAddress() {
				System.out.println("hello anan && lily~~~");
			}
		};
		inner3Class.outputAddress();
		//Inner3Class ------end
		
	}
	
	public static void main(String[] args) {
		/**���н����
		 *  hello world~~~
			hello anan~~~
			hello anan && lily~~~
		 */
		new TestAnonymityInnerClass().output();
	}
	
}

interface InnerClass{
	public void outputAddress();
	
}

class Inner2Class{
	public void outputAddress(){
		System.out.println("hello original anan~~~");
	};
}

 abstract class Inner3Class{
	public abstract void outputAddress();
}


