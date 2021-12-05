package com.sc.study.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-10-31 14:51
 * @desc
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        /**
         * 定义屏障
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("这是在最后一个线程到达Barrier之后才会触发的哦");
        });
        IntStream.range(0, 3).forEach(item -> new Thread(() -> {
            try {
                Thread.sleep((long) Math.round(2) * 1000);
                System.out.println("sub-thread" + Thread.currentThread().getName() + "start");
                cyclicBarrier.await();
                System.out.println("sub-thread" + Thread.currentThread().getName() + "end");

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

        }).start());
    }
}
