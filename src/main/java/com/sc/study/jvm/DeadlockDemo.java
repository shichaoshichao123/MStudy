package com.sc.study.jvm;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/10/21 3:50 下午
 * @desc 死锁示例
 */
public class DeadlockDemo {
    static Object lockA = new Object();
    static Object lockB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            System.out.println("尝试获取锁A");
            synchronized (lockA) {
                System.out.println("拿到锁A");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("尝试获取锁B");
                synchronized (lockB) {
                    System.out.println("拿到锁B");
                }
            }
        });
        Thread threadB = new Thread(() -> {
            System.out.println("尝试获取锁B");
            synchronized (lockB) {
                System.out.println("拿到锁B");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("尝试获取锁A");
                synchronized (lockA) {
                    System.out.println("拿到锁A");
                }
            }
        });

        threadA.start();
        threadB.start();
        Thread.sleep(5000);
    }

}
