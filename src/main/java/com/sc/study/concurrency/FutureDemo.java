package com.sc.study.concurrency;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-10-31 15:59
 * @desc
 */
public class FutureDemo {

    public static void main(String[] args) {
        Integer response = null;
        Callable<Integer> callable = () -> {
            System.out.println("callable start");
            Integer result = new Random().nextInt(1000);
            Thread.sleep(5000);
            System.out.println("callable end");

            return result;

        };
        FutureTask<Integer> futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println("主线程继续执行");
        try {
            response = futureTask.get();
            Thread.sleep(1000);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(response);
    }
}
