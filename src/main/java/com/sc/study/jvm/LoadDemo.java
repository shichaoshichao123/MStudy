package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-24 22:20
 * @desc
 */
public class LoadDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

      Class<?> clazz =  classLoader.loadClass("com.sc.study.jvm.Simple");

      clazz.newInstance();


    }
}
