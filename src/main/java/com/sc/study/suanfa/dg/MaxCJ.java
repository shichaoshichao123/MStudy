package com.sc.study.suanfa.dg;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/13 2:28 下午
 * @desc 求一个数组的最大乘积
 */
public class MaxCJ {

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 9, 3, -1, 5};
        System.out.println(getMaxCJByDP(data));
        System.out.println(getMaxCJByDG(data, 0, 1));
    }

    /**
     * 通过递归的方式获取最大乘积
     *
     * @return
     */
    private static long getMaxCJByDG(int[] data, int index, long currentResult) {
        long res = currentResult;
        if (index == data.length - 1) {
             Math.max(currentResult, currentResult * data[index]);

        }
        if (index == 0) {
            res = data[0];
            getMaxCJByDG(data, ++index, res);
        }
        if (res * data[index] >= res) {
            res = res * data[index];
            getMaxCJByDG(data, ++index, res);
        } else {
            getMaxCJByDG(data, ++index, 1);
        }

        return res;
    }

    /**
     * 动态规划的方式获取最大乘积
     * 状态转移方程：if(data[i]>0):dp[i] = data[i-1][1] * data[i]
     * else:dp[i] = data[i-1][0] * data[i]
     *
     * @param data
     * @return
     */
    private static long getMaxCJByDP(int[] data) {
        if (null == data) {
            return 0;
        }
        //用于保存每个位置的结果（max）
        int[] res = new int[data.length];
        //用于保存指定未知的最小负值
        int[] min = new int[data.length];
        //用于保存指定未知的最大负值
        int[] max = new int[data.length];
        res[0] = data[0];
        min[0] = data[0];
        max[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            int tempMax = data[i] * max[i - 1];
            int tempMin = data[i] * min[i - 1];
            max[i] = Math.max(Math.max(data[i], tempMax), tempMin);
            min[i] = Math.min(Math.max(data[i], tempMax), tempMin);
            if (res[i - 1] > max[i]) {
                res[i] = res[i - 1];
            } else {
                res[i] = max[i];
            }
        }
        return res[data.length - 1];
    }


}
