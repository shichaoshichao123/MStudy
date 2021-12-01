package com.sc.study.dtgh;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/8/7 11:08 上午
 * @desc
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] origin = new int[]{1, 2, 3, 4, 3, 4, 6, 7, 8, 9};
        System.out.println(getMaxUp(origin));

    }


    /**
     * 求一个数组的最长连续递增子序列
     *
     * @param origin
     * @return
     */
    public static int getMaxUp(int[] origin) {
        if (null == origin || origin.length == 0) {
            return 0;
        }
        if (origin.length == 1) {
            return 1;
        }
        //定义数组存放转移方程内容
        int[] dp = new int[origin.length + 1];
        dp[0] = 1;
        for (int i = 1; i < origin.length; i++) {
            if (origin[i] > origin[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        //获取dp数组中的最大值进行返回
        int result = 1;
        for (int j : dp) {
            result = Math.max(result, j);
        }
        return result;
    }
}
