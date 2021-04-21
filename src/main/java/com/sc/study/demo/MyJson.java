package com.sc.study.demo;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-17 15:33
 * @desc
 */
public class MyJson extends Json {
    public static int a = 3;

    public MyJson() {
        System.out.println("MyJson被虚拟机初始化了");
    }

    static {
        System.out.println("MyJson被虚拟机初始化了");

    }

}
