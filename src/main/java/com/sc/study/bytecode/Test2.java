package com.sc.study.bytecode;

import java.io.IOException;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-02 21:54
 * @desc
 */
public class Test2 {
    private static int a = 12;
    private int b = 13;
    public  void method() throws NullPointerException,IOException

    {
        synchronized(this){
            System.out.println("修饰实例方法");

        }
    }
}
