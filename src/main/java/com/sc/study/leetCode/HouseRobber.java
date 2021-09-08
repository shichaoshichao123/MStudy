package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/4 10:09 上午
 * @desc 小偷偷金币，不能连续房子偷，求能偷盗的最多金币数
 */
public class HouseRobber {

    public static void main(String[] args) {
        long[] houses = new long[]{3, 8, 5, 10};
        System.out.println(doHouseRobber(houses));
    }


    /**
     * 进行算法
     *
     * @param houses 代表房子及没动房子可盗取的金币数
     * @return
     */
    private static long doHouseRobber(long[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        if (houses.length == 1) {
            return houses[0];
        }
        //定义状态数组
        long[] dp = new long[houses.length + 1];
        //边界
        dp[0] = 0;
        dp[1] = houses[0];
        //计算
        for (int i = 2; i <= houses.length; i++) {
            //如果最后一个房子不偷就是求dp(n-1),若最后一栋房子被偷就是求house[house.length-1]+dp(n-2),取两者最大值
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i - 1]);
        }
        //最佳值就是dp[n]
        return dp[houses.length];
    }
}

