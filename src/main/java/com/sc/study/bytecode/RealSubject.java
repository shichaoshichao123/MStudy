package com.sc.study.bytecode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-05 15:22
 * @desc
 */
public class RealSubject implements Subject {

    @Override
    public void doRequest() {
        System.out.println("do real subject success");
    }
}
