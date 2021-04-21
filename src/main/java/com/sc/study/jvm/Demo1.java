package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-22 15:25
 * @desc
 */
public class Demo1 {

    public static void main(String[] args) {
        System.out.println(Children.a);
    }
}

class Children extends Parent {
    static int a = 11;

}

class Parent {
    /**
     * 如果接口被初始化那么该静态变量也会被初始化
     */
   static Thread thread = new Thread() {
        //只要Thread被创建该代码快就会被执行
        {
            System.out.println("Parent 接口被初始化了");
        }
    };

}
