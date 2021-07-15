package com.sc.study.leetCode;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/7/15 7:41 下午
 * @desc 给一组固定面值的硬币，使用最少的硬币数合成一个指定的面额
 */
public class Duihuan {


    public static void main(String[] args) {
        Duihuan duihuan = new Duihuan();
        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(2);
        coins.add(5);
        System.out.println(duihuan.doDuihuan(coins, 11));
    }

    /**
     * 求解最少硬币数
     * 不存在返回-1
     *
     * @param coins
     * @param target
     * @return
     */
    private int doDuihuan(List<Integer> coins, Integer target) {
        if (CollectionUtils.isEmpty(coins) || null == target) {
            return -1;
        }
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[1] = 0;
        for (int i = 1; i <= target; i++) {
            //硬币的种类数
            for (int j = 0; j < coins.size(); j++) {
                if (coins.get(j) <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins.get(j)] + 1);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }

}
