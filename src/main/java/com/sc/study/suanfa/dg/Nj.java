package com.sc.study.suanfa.dg;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/3/16 8:29 下午
 * @desc
 */
public class Nj {

    public static void main(String[] args) {
//        System.out.println(getNj(6));
//        System.out.println(getPow(2, 4));
//
//        System.out.println(10140370%100);
//        System.out.println(10140371%100);
//
//        System.out.println(getMaxMoney(new int[]{1, 2, 3, 4, 5}));

        ConcurrentHashMap<String, Integer> temp = new ConcurrentHashMap<>(8);
        temp.put("test1",1);
        temp.put("test2",3);
        temp.put("test1",3);
        System.out.println(temp);
    }

    /**
     * 用于求出指定数值的阶层
     * result = 1*2*3.....*n
     *
     * @param n
     * @return
     */
    private static long getNj(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return n * (getNj(n - 1));
    }

    /**
     * 计算n的j次方的值
     * 使用分治的方式
     *
     * @param n
     * @param j
     * @return
     */
    private static long getPow(int n, int j) {
        if (j == 0) {
            return 1;
        }
        // return n * (getPow(n, j - 1));
        if (j % 2 == 0) {
            return getPow(n, j / 2) * getPow(n, j / 2);
        } else {
            return n * getPow(n, j / 2) * getPow(n, j / 2);
        }
    }

    /**
     * 使用贪心算法计算出一段时间内某股票可以得到的最大收益
     * 具体思想是：对每一天的股价都与其后一天的价格进行对比，如果后一天的价格比前一天的高，那我们就进行买入，碰到后一天的价格比前一天低的情况如果现在手中持有这手股票那就卖出，如果没持有就不进行买卖。
     *
     * @param prices
     * @return
     */
    private static Integer getMaxMoney(int[] prices) {
        if (null == prices) {
            return 0;
        }
        //标识当前手中的股票(其实只是起到标识的作用并不一定是真的买)
        int currentPrice = prices[0];
        //标识利润
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (currentPrice > prices[i]) {
                currentPrice = prices[i];
            } else {
                //在真正出现后一天比前一天价格高的时候进行一次买入卖出操作
                profit += prices[i] - currentPrice;
                //将买入的基准调整到后一天
                currentPrice = prices[i];
            }
        }
        return profit;
    }
}
