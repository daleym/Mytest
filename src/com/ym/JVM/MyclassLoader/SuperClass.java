package com.ym.JVM.MyclassLoader;

public class SuperClass extends SSClass
{
	static
    {
        System.out.println("SuperClass static block!");
    }
 
    public static int value = 123;
 
    public SuperClass()
    {
        System.out.println("init SuperClass");
    }
}

