package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/7/17 11:53 上午
 * @desc
 */
public class Duihuan2 {

    public static void main(String[] args) {
        int[] coins = new int[]{2, 5, 7};
//        System.out.println(doDuihuan2(coins,1));
        System.out.println(doDuihuan2(coins, 27));
//        System.out.println(doDuihuan2(coins,7));

        System.out.println(ways(new int[10][10]));
        System.out.println(canArrive(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canArrive(new int[]{3, 2, 1, 0, 4}));

    }

    /**
     * 进行兑换求解
     *
     * @param coins  拥有的硬币面额
     * @param target 目标面额
     * @return 0表示无法拼出该指定面额
     */
    public static int doDuihuan2(int[] coins, int target) {
        if (null == coins || target <= 0) {
            return 0;
        }
        //由于计算是从下标0开始的所以申请了target+1的长度
        int[] dp = new int[target + 1];
        //从1开始计算
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            //进行最后一枚硬币选择 target = dp[target-coins[j]]+1;注意数组下标问题
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            System.out.println("dp[" + i + "]=" + dp[i]);
        }
        if (dp[target] == Integer.MAX_VALUE) {
            return 0;
        } else {
            return dp[target];
        }
    }

    /**
     * 二维棋盘求左上角到目标位置可以到达的总数
     * 注意：只能向下或向左移动
     *
     * @param board
     * @return
     */
    public static int ways(int[][] board) {
        //计算顺序要符合动态规划的取之时机
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0) {
                    board[i][j] = 1;
                    continue;
                }
                board[i][j] = board[i - 1][j] + board[i][j - 1];
            }
        }
        return board[board.length - 1][board[0].length - 1];
    }


    /**
     * 是否能到达最后一块石头
     *
     * @param stores
     * @return
     */
    public static boolean canArrive(int[] stores) {
        if (null == stores) {
            return true;
        }
        boolean[] dp = new boolean[stores.length];
        //出事条件，青蛙本身就站在第一块石头上，所以dp[0] = true;
        dp[0] = true;
        //根据石头的顺序计算
        for (int i = 1; i < stores.length; i++) {
            //计算最后一步的前一步，根据前面有多少块石头就有多少种可能
            for (int j = 0; j < i; j++) {
                //首先青蛙要能在这颗石头上，并且这颗石头的序号+这颗石头上可跳的步数要大于目标石头序号
                if (dp[j] && stores[j] + j >= i) {
                    dp[i] = true;
                    //退出本次子问题
                    break;
                }
            }
        }
        return dp[stores.length - 1];
    }
}
