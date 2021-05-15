package com.sc.study.concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/15 11:00 上午
 * @desc
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 30; i++) {
            executorService.submit(new TaskMan());
        }
        executorService.shutdown();

    }

    public static class TaskMan implements Runnable {
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("taskMan do work.....");
                Thread.sleep(2000);
                semaphore.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
