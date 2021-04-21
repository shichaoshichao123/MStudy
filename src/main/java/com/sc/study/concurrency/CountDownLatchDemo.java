package com.sc.study.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-10-31 12:19
 * @desc
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        IntStream.range(0, 5).forEach(item -> new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("sub-thread"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }

        }).start());
        System.out.println("所有子线程都已经启动");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
}
