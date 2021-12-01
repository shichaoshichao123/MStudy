package com.sc.study.demo;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/27 8:47 下午
 * @desc
 */
public class Zd {


    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程被中断");
                    break;

                }
                try {
                    Thread.sleep(122);
                } catch (InterruptedException e) {
                    //在sleep join wait状态下的线程被中断的时候会抛出中断异常并且重置中断状态为false，所以在这个情况下需要捕获异常并重新设置中断
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println("-------doSomething------");
            }

        });
        t1.start();
        Thread.sleep(3);
        new Thread(() -> {
            t1.interrupt();

        }).start();
    }
}
