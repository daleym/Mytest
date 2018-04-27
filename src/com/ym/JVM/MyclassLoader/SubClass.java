package com.ym.JVM.MyclassLoader;

public class SubClass extends SuperClass
{
    static
    {
        System.out.println("SubClass static block... ");
    }
 
    static int a;
 
    public SubClass()
    {
        System.out.println("init SubClass");
    }
    
    
}

