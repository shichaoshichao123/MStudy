package com.sc.study.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-05 15:26
 * @desc 动态代理对象
 */
public class DynamicSubject implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Subject subject;

    public DynamicSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("do proxy before...");
        //执行被代理的逻辑
        method.invoke(subject, args);
        System.out.println("do proxy after...");
        return null;
    }
}
