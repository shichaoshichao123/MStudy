package com.sc.study.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-21 11:08
 * @desc
 */
public class ForkJoinDemo {

    public static void main(String[] args) {

        //创建一个4线程并发的ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        Mytask mytask = new Mytask(5, 1, 10);
        int result = forkJoinPool.invoke(mytask);
        System.out.println("结果：" + result);
        //关闭线程池
        forkJoinPool.shutdown();

    }

}

class Mytask extends RecursiveTask<Integer> {

    private int cellNum;
    private int start;
    private int end;

    public Mytask(int cellNum, int start, int end) {
        this.cellNum = cellNum;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        boolean isCell = (end - start) <= cellNum;
        int result = 0;
        if (isCell) {
            //符合任务Fork最小细粒度进入真正的计算逻辑
            System.out.println("线程：" + Thread.currentThread().getName() + "执行的区间：" + start + "-" + end);
            for (int i = start; i <= end; i++) {
                result += i;
            }
        } else {
            //任务还未达到最小细粒度，需要进行拆分
            int mid = (end + start) / 2;
            Mytask myTask1 = new Mytask(cellNum, start, mid);
            Mytask myTask2 = new Mytask(cellNum, mid + 1, end);
            //进行两个任务的Fork调用（多线程）
            invokeAll(myTask1, myTask2);
            //合并结果，如果没执行完会阻塞等待
            int result1 = myTask1.join();
            int result2 = myTask2.join();

            result = result1 + result2;
        }
        return result;
    }
}

