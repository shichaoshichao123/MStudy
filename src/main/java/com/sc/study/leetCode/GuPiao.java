package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/9/4 10:37 上午
 * @desc 股票买卖相关题型
 */
public class GuPiao {
    public static void main(String[] args) {
        int[] gp = new int[]{1, 3, 4, 2, 7};
        System.out.println(doGuPiao1(gp));
    }


    /**
     * 已知后面n天的股票价格，只能进行一手买卖求能获得的最大收益
     *
     * @return
     */
    private static int doGuPiao1(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //利润
        int res = 0;
        //用户暂时存放前n天的股票最低价
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(minPrice, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return res;
    }
}
