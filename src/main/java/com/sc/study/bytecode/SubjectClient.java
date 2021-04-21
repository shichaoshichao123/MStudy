package com.sc.study.bytecode;


import java.lang.reflect.Proxy;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-05 15:28
 * @desc
 */
public class SubjectClient {
    public static void main(String[] args) {
        //更改上下文配置，保存代理类的磁盘
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
        //被代理的真是对象
        RealSubject realSubject = new RealSubject();
        //动太代理对象
        DynamicSubject dynamicSubject = new DynamicSubject(realSubject);
        //获取真是对象的类信息用于获取在生成代理对象的时候加载被代理类的相关信息
        Class<?> clazz = realSubject.getClass();
        //获取代理对象
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), dynamicSubject);
        subjectProxy.doRequest();

        System.out.println(subjectProxy.getClass());
        System.out.println(subjectProxy.getClass().getSuperclass());

    }
}
