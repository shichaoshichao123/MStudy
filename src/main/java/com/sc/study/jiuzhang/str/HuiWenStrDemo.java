package com.sc.study.jiuzhang.str;

import org.springframework.util.StringUtils;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/11/6 3:15 下午
 * @desc 求字符串中最长回文子串
 */
public class HuiWenStrDemo {

    public static void main(String[] args) {
        System.out.println(getMaxHw("aabaa1"));
        System.out.println(getMaxHwWithN2("aabaa1"));
        System.out.println(getMaxHwWithDp("112aabaa112"));
    }

    /**
     * 获取给定字符串的最回文子串
     * O(n3)
     *
     * @param origin
     * @return
     */
    public static String getMaxHw(String origin) {
        if (StringUtils.isEmpty(origin)) {
            return null;
        }
        int length = origin.length();
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > 0; j--) {
                int left = i;
                int right = j;
                while (left < right && origin.charAt(left) == origin.charAt(right)) {
                    left++;
                    right--;
                }
                if (left >= right) {
                    return origin.substring(i, j + 1);
                }
            }
        }
        return null;
    }

    /**
     * O(n2)复杂度下求最大回文串
     * 基于中心点的枚举比较
     *
     * @param origin
     * @return
     */
    public static String getMaxHwWithN2(String origin) {
        String result = "";
        if (null == origin) {
            return result;
        }
        //奇数长度
        for (int i = 0; i < origin.length(); i++) {
            String long1 = getSubMax(origin, i, i);
            if (result.length() < long1.length()) {
                result = long1;
            }

            String long2 = getSubMax(origin, i, i + 1);
            if (result.length() < long2.length()) {
                result = long2;
            }
        }
        return result;
    }

    /**
     * 获取以某个/两个点向外扩的最大回文子串
     *
     * @param origin
     * @param left
     * @param right
     * @return
     */
    private static String getSubMax(String origin, int left, int right) {
        while (left >= 0 && right < origin.length()) {
            if (origin.charAt(left) != origin.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return origin.substring(left + 1, right);
    }

    /**
     * 使用动态规划的方式求解最大回文子串
     *
     * @param origin
     * @return
     */
    public static String getMaxHwWithDp(String origin) {
        if (StringUtils.isEmpty(origin)) {
            return null;
        }
        int length = origin.length();
        boolean[][] dp = new boolean[length][length];
        //初始化所有长度为1的子串都为回文
        int longMax = 1, start = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        //初始化所有长度为2的子串的回文情况
        for (int i = 0; i < length - 1; i++) {
            dp[i][i + 1] = origin.charAt(i) == origin.charAt(i + 1);
            //为true的情况更新数据
            if (dp[i][i + 1]) {
                longMax = 2;
                start = i;
            }
        }
        //进行长度大于等于3的子串回文情况统计
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + longMax; j < length; j++) {
                dp[i][j] = dp[i + 1][j - 1] && origin.charAt(i)
                        == origin.charAt(j);
                if (dp[i][j] && j - i + 1 > longMax) {
                    longMax = j - i + 1;
                    start = i;
                }
            }
        }
        //返回结果
        return origin.substring(start, start + longMax);
    }


}
