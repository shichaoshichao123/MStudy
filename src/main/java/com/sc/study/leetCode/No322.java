package com.sc.study.leetCode;

import java.util.Arrays;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/22 4:13 下午
 * @desc 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class No322 {
    public static void main(String[] args) {
        No322 no322 = new No322();
        int[] coins = new int[]{1, 2, 5};
        System.out.println(no322.coinChange(coins, 11));

    }

    /**
     * 示例1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：coins = [1], amount = 1
     * 输出：1
     * 示例 5：
     * <p>
     * 输入：coins = [1], amount = 2
     * 输出：2
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount <= 0) {
            return 0;
        }
        //定义状态保持数组
        int[] dp = new int[amount + 1];
        //使用特殊的值进行标记
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //根据不同的硬币面额进行循环对比取最小值
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return Integer.MAX_VALUE == dp[amount] ? -1 : dp[amount];
    }
}
