package com.sc.study.concurrency.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/15 10:45 上午
 * @desc
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(8);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 8; i++) {
            Runnable runnable = () -> {
                System.out.println("选手" + Thread.currentThread().getName() + "准备起跑");
                try {
                    start.await();
                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }

            };
            threadPool.submit(runnable);
        }
        start.countDown();
        System.out.println("裁判鸣枪...");
        try {
            end.await();
            System.out.println("比赛结束...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();

    }
}
