package com.sc.study.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-14 13:44
 * @desc
 */
public class  ReadWriteLockDemo {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        //十个线程同时进行，不存在竞争
        IntStream.range(0, 10).forEach(i -> new Thread(readWriteLockDemo::read).start());
        //十个线程串行进行，存在竞争
        IntStream.range(0, 10).forEach(i -> new Thread(readWriteLockDemo::write).start());
    }


    /**
     * 读锁使用
     */
    public void read() {
        //加读锁
        readWriteLock.readLock().lock();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放读锁
            readWriteLock.readLock().unlock();
        }
        System.out.println("读取结束");
    }

    /**
     * 写锁使用
     */
    public void write() {
        //加读锁
        readWriteLock.writeLock().lock();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放读锁
            readWriteLock.writeLock().unlock();
        }
        System.out.println("写入结束");
    }
}
