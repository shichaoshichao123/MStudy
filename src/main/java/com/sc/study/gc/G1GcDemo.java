package com.sc.study.gc;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-26 15:31
 * @desc G1垃圾回收实例
 */
public class G1GcDemo {

    public static void main(String[] args) {
        int size = 1024*1024;

        byte[] b1 = new byte[size];
        byte[] b2 = new byte[size];
        byte[] b3 = new byte[size];
        byte[] b4 = new byte[size];
        System.out.println("执行完毕");
    }
}
