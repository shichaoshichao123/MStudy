package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-28 10:50
 * @desc
 */
public class Demo3 implements Runnable{
    Thread thread;

    public Demo3() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);
        System.out.println("Class:"+classLoader.getClass());
        System.out.println("Parent:"+classLoader.getParent().getClass());

    }

    public static void main(String[] args) {
        new Demo3();
    }
}
