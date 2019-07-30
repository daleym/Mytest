package com.ym.inner;

import com.ym.thread.daemon.Test;

/** 
* @author ym: 
* @version 创建时间：2019年7月30日 下午3:34:51 
* @description 匿名内部类 
* 					实现方式：接口实现     InnerClass 
* 						         普通类实现 Inner2Class
* 						         抽象类实现  Inner3Class
* 					好处：主类不必继承、实现，实现特殊化处理~~~
* 
* 编译后:
* 	Inner2Class.class
* 	Inner3Class.class
* 	InnerClass.class
* TestAnonymityInnerClass$1.class  匿名内部类 
* TestAnonymityInnerClass$2.class   匿名内部类 
* TestAnonymityInnerClass$3.class    匿名内部类 
* TestAnonymityInnerClass.class
*/

public class TestAnonymityInnerClass {

	public void output(){
		//InnerClass -------start
		//匿名内部类
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
		/**运行结果：
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


