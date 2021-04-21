package com.sc.study.demo;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-17 15:33
 * @desc
 */
public class Json {

    public Json() {
        System.out.println("Json 被虚拟机初始化啦。。。。。");
    }
    static{
        System.out.println("Json 被虚拟机初始化啦。。。。。");

    }

    static void doSomething(String name) {
        System.out.println("Json start to doSomething for" + name);
    }
}
