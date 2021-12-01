package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-23 20:50
 * @desc
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        //由根加载器加载
        Class<?>  clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        //由应用类加载器加载
        Class<?> clazz1 = Class.forName("com.sc.study.jvm.C");
        System.out.println(clazz1.getClassLoader());

    }

}

class C{

}
