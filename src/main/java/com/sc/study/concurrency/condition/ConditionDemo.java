package com.sc.study.concurrency.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/15 11:09 上午
 * @desc
 */
public class ConditionDemo {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void method1() {
        lock.lock();
        try {
            System.out.println("开始等待条件被满足.....");
            condition.await();
            System.out.println("条件满足，继续向下执行.....");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void method2() {
        lock.lock();
        try {
            condition.signal();
            System.out.println("满足条件，唤醒等待的条件满足的线程");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ConditionDemo condition = new ConditionDemo();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.method2();
        }).start();
        condition.method1();
    }
}
