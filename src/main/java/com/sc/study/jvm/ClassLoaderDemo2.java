package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-23 20:55
 * @desc
 */
public class ClassLoaderDemo2 {

    static{
        System.out.println("this is ClassLoaderDemo2 static code block");
    }
    public static void main(String[] args) {
        System.out.println(Children1.b);
    }
}

class Parent1 {
    static  int a = 1;

    static {
        System.out.println("this is Parent1 static code block");
    }
}

class Children1 extends Parent1 {
    static  int b = 1;

    static {
        System.out.println("this is Children1 static code block");

    }

}
