package com.sc.study.concurrency;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-10-17 16:56
 * @desc Synchronized使用方式
 */
public class SynchronizedDemo {

    private Object object = new Object();

    /**
     * 用在代码块上
     *
     * 当关键字修饰代码块的时候是通过字节码指令 monitorenter，以及monitorexit来实现同步的
     */
    public void method() {
        synchronized (object) {
            //do something
        }
    }

    /**
     * 用在实例方法
     * 当关键字修饰实例方法的时候是通过是通过字节码中的方法标识（flags ACC_synchronized）来体现的。
     * 线程调用方法的时候会先检验这个flags如果有这个标识就会尝试去获取对象锁，获取到了才执行方法体
     */
    public synchronized void method1() {
        //do something

    }

    /**
     * 用在静态方法
     * 当关键字修饰
     */
    public synchronized static void method2() {
        //do something

    }

    public static void main(String[] args) {

    }


}
