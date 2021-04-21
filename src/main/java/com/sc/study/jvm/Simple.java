package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-24 22:19
 * @desc
 */
public class Simple {

    public Simple() {
        System.out.println(this.getClass().getClassLoader());
        new Cat();
    }
}
