package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-25 22:09
 * @desc
 */
public class Demo2 {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("根加载器加载的路径："+System.getProperty("sun.boot.class.path"));
        System.out.println("扩展类载加载的路径："+System.getProperty("java.ext.dirs"));
        System.out.println("应用加载器加载的路径："+System.getProperty("java.class.path"));

        Class.forName("");
    }
}
