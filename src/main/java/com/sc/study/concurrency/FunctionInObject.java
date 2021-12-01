package com.sc.study.concurrency;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-10-17 14:51
 * @desc 讲解Object中与线程相关的方法
 */
public class FunctionInObject {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        synchronized (lock) {
            lock.wait();

        }

    }

}
