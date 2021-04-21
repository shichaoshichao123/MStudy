package com.sc.study.concurrency;

import lombok.SneakyThrows;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-10-17 15:53
 * @desc
 */
public class Demo1 {

    private int count;
    private volatile int max;

    /**
     * 进行加一操作
     */
    public synchronized void doAdd() throws InterruptedException {
        //用while的方式适用于防止虚假唤醒，需要重新校验一下条件
        while (count == 1) {
            this.wait();

        }
        System.out.print(++count);
        this.notify();


    }

    /**
     * 进行减一操作
     */
    public synchronized void doReReduce() throws InterruptedException {
        while (count == 0) {
            this.wait();
        }
        System.out.print(--count);
        this.notify();

    }

    public static void main(String[] args) {
        Demo1 mock = new Demo1();
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    mock.doAdd();

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    mock.doReReduce();

                }
            }
        });

        t1.start();
        t2.start();
    }


}
