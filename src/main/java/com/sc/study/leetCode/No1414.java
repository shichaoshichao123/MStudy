package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/28 10:47 上午
 * @desc 给你数字 k，请你返回和为k的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * <p>
 * 斐波那契数字定义为：
 * <p>
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2， 其中 n > 2 。
 * 数据保证对于给定的 k，一定能找到可行解。
 */
public class No1414 {
    /**
     * 示例 1：
     * <p>
     * 输入：k = 7
     * 输出：2
     * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
     * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
     * 示例 2：
     * <p>
     * 输入：k = 10
     * 输出：2
     * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
     * 示例 3：
     * <p>
     * 输入：k = 19
     * 输出：3
     * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
     *
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= 10^9
     *
     * @param args
     */


    public static void main(String[] args) {
        No1414 no1414 = new No1414();
//        System.out.println(no1414.findMinFibonacciNumbers(1));
//        System.out.println(no1414.findMinFibonacciNumbers(7));
//        System.out.println(no1414.findMinFibonacciNumbers(10));
        System.out.println(no1414.findMinFibonacciNumbers(1));

    }

    public int findMinFibonacciNumbers(int k) {
        int i = 1;
        int j = 1;
        int count = 0;
        while (k != 0) {
            int sum = i + j;
            if (sum > k) {
                k = k - i;
                count++;
                i = 1;
                j = 1;
            } else {
                j = i;
                i = sum;

            }
        }
        return count;


    }
}
