package com.ym.JVM.MyclassLoader;

/**
 * 类加载机制：实例初始化不一定晚于类初始化，若实例初始化嵌入到静态变量中，那么就会发生！
 * eg：第13行。
 * 类实例化和实例初始化主要是在准备、初始化两阶段完成的，若静态块为final类型，则在准备阶段赋值，否则为0；
 * Java中赋值顺序： 
1. 父类的静态变量赋值 
2. 自身的静态变量赋值 
3. 父类成员变量赋值和父类块赋值 
4. 父类构造函数赋值 
5. 自身成员变量赋值和自身块赋值 
6. 自身构造函数赋值
 * @author Administrator
 *
 */
public class StaticTest {

	
	
	static StaticTest st = new StaticTest();
	 
    
 
    
    
    public static void staticFunction(){
        System.out.println("4");
    }
    
    static
    {
        System.out.println("1");
    }
    
    public StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }
    {
        System.out.println("2");
    }
	
	
	
	public static void main(String[] args)
    {
        staticFunction();
    }
	
	int a=110;
    static int b =112;
	
}
