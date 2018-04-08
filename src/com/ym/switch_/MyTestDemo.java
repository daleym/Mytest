package com.ym.switch_;

/**
 * @description switch...应用，break关键字起到终止效果；default位置可以随意！！！
 * @attention   枚举值不能为空，否则发生空指针异常！！！
 * @author Administrator
 *
 */
public class MyTestDemo {
	
	public static void main(String[] args) {
//		switchExecutive(1);
//		switchExecutive(2);
//		switchExecutive(3);
//		switchExecutive(null);
		
		Long amount = null;
		System.out.println(String.format("分子为0,转换为字符串测试,结果【%s】", String.valueOf( amount / 100)));
	}
	
	//switch执行体
	private static  void switchExecutive(Integer number){
		switch(number){
		case 1:
			System.out.println("1");
			break;
		default:
			System.out.println("default");
			return ;//终止流程...
		case 2:
			System.out.println("2");
			break;
		}
		System.out.println("switch块已结束... ...");
	}
	
}
