package com.ym.tryCatchException;

/**
 * @description 异常处理
 * 				若异常被捕获，且不再次抛出新的异常，则后续流程功能将不受影响
 * 				eg:若仅打印17行代码，则22行会继续执行；若抛出新的异常，如18行，则22行代码不会得到执行！！！
 * @description 占位符的使用 %% 转义为 %
 * @author ming.yang
 */
public class TestDemoAnother {
		
	public static void main(String[] args) throws Exception {
		try{
			System.out.println(TestDemoAnother.class.getSimpleName());
			
			throw new Exception("空指针");
		}catch(Exception e){
			System.out.println(String.format("e.getMessage()【%s】", e.getMessage()));
			e.printStackTrace();
//			throw new Exception(String.format("发生异常啦，具体异常为：【%s】", e.getMessage()));
		}finally{
			System.out.println("异常发生时，finally块 还是先执行了...");
		}
		String tmp = "【test-借款0002（等额本息6个月9%）-勿动2】第【4】期回款金额%s元】";
		tmp        = tmp.replaceAll("%", "%%");
		tmp       = tmp.replaceAll("%%s", "%s");
		
		System.out.println(String.format("tmp:%s" , tmp ));
		System.out.println(String.format(tmp ,33586));
		System.out.println(String.format("【test-借款0002（等额本息6个月9%%）-勿动2】第【4】期回款金额%s元】" , 1000));
	}
	
}
