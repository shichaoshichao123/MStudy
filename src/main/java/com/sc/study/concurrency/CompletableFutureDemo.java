package com.sc.study.concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-10-31 16:46
 * @desc
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> "shichao").thenApplyAsync(value -> value + " gogo").join();
        System.out.println(result);

        System.out.println("----------------------");
        CompletableFuture.supplyAsync(() -> "shichao").thenAccept(value -> System.out.println(value + " gogo"));

        System.out.println("-----------------------");

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("start to do run");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish run");
        });

        future.whenCompleteAsync((a, b) -> System.out.println("a+b=" + a + b));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
