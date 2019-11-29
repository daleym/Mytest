package com.ym.JVM.gc;

/**
 * @desc 添加了局部变量块，触发Full GC
 */
public class TestGC {

    public static final int size  = 64 * 1024 * 1024;

    public static void main(String[] args) {



        {
            int [] i = new int[size];
        }

        int a  = 0;

        System.gc();
    }

}
