package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-24 22:18
 * @desc
 */
public class Cat {

    public Cat() {
        System.out.println(this.getClass().getClassLoader());
    }
}
