package com.sc.study.check;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/3 2:14 下午
 * @desc
 */
public class CheckClass {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService threadPool = Executors.newFixedThreadPool(30);

        threadPool.submit(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1开始提交任务");
            for (int i = 0; i < 10; i++) {
                System.out.println("线程1" + ImageUtil.getUrl("/path/thread1.jpg"));
            }
            System.out.println("线程1结束提交任务");

        });
        threadPool.submit(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2开始提交任务");
            for (int i = 0; i < 10; i++) {
                System.out.println("线程2" + ImageUtil.getUrl("/path/thread2.jpg"));
            }
            System.out.println("线程2结束提交任务");

        });

        Thread.sleep(2000);
        countDownLatch.countDown();
        threadPool.shutdown();


    }


}
