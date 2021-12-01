package com.sc.study.concurrency.condition;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/15 11:15 上午
 * @desc 演示生产消费者模式
 */
public class ConditionDemo2 {
    Lock lock = new ReentrantLock(false);
    /**
     * 有空闲位置的条件，表示可以进行生产
     */
    Condition notFull = lock.newCondition();
    /**
     * 有元素的条件，表示可以进行消费
     */
    Condition notEmpty = lock.newCondition();
    Integer size = 20;
    Queue<Integer> taskQueue = new LinkedBlockingQueue<>(size);

    /**
     * 消费者类
     */
    class Consumer implements Runnable {
        @Override
        public void run() {
            do {
                lock.lock();
                try {
                    while (taskQueue.isEmpty()) {
                        System.out.println("仓库空了，等待生产产品....");
                        notEmpty.await();
                    }
//                    Thread.sleep(1000);
                    System.out.println("消费者消费了产品：" + taskQueue.poll());
                    notFull.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } while (true);
        }
    }

    /**
     * 生产者类
     */
    class Producer implements Runnable {
        @Override
        public void run() {
            do {
                lock.lock();
                try {
                    while (taskQueue.size() == size) {
                        System.out.println("仓库满了等待被消费....");
                        notFull.await();
                    }
//                    Thread.sleep(2000);
                    Integer cell = new Random().nextInt(100);
                    System.out.println("生产者生产了产品：" + cell);
                    taskQueue.offer(cell);
                    notEmpty.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } while (true);
        }
    }

    public static void main(String[] args) {
        ConditionDemo2 conditionDemo2 = new ConditionDemo2();
        Consumer consumer = conditionDemo2.new Consumer();
        Producer producer = conditionDemo2.new Producer();

        new Thread(consumer).start();
        new Thread(producer).start();

    }
}
