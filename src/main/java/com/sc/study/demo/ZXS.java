package com.sc.study.demo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/29 3:08 下午
 * @desc 自旋锁
 */
public class ZXS {
    public static void main(String[] args) {
        ZXS zxs = new ZXS();
        new Thread(() -> {
            zxs.lock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            zxs.unlock();
        },"threadA").start();
        new Thread(() -> {
            zxs.lock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            zxs.unlock();
        },"threadB").start();
    }

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        //进行自旋加锁
        while (!atomicReference.compareAndSet(null, Thread.currentThread())) {
            System.out.println(Thread.currentThread().getName()+"自旋中.....");
        }
        System.out.println(Thread.currentThread().getName() + "获得锁");
    }


    public void unlock() {
        //这里就不进行自旋了，如果不是锁持有者直接通过
        atomicReference.compareAndSet(Thread.currentThread(), null);
        System.out.println(Thread.currentThread().getName() + "释放锁");
    }
}
