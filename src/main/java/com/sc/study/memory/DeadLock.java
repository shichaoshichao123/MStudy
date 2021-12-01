package com.sc.study.memory;

import lombok.SneakyThrows;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-08 22:27
 * @desc
 */
public class DeadLock {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    /**
     * getLock1
     *
     * @throws InterruptedException
     */
    public void getLock1() throws InterruptedException {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "拿到了1号锁，现在尝试去获取2号锁");
            Thread.sleep(5000);
            getLock2();

        }
    }

    /**
     * getLock2
     *
     * @throws InterruptedException
     */
    public void getLock2() throws InterruptedException {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + "拿到了2号锁，现在尝试去获取1号锁");
            Thread.sleep(5000);
            getLock1();
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(new Runnable() {

            @SneakyThrows
            @Override
            public void run() {
                deadLock.getLock1();
            }
        },"线程1").start();
        new Thread(new Runnable() {

            @SneakyThrows
            @Override
            public void run() {
                deadLock.getLock2();
            }
        },"线程2").start();
    }



}
