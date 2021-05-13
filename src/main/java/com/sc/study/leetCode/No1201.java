package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/13 2:28 下午
 * @desc 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
 * <p>
 * 丑数是可以被 a 或 b 或 c 整除的 正整数 。
 */
public class No1201 {
    /**
     * 示例 1：
     * <p>
     * 输入：n = 3, a = 2, b = 3, c = 5
     * 输出：4
     * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
     * 示例 2：
     * <p>
     * 输入：n = 4, a = 2, b = 3, c = 4
     * 输出：6
     * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
     * 示例 3：
     * <p>
     * 输入：n = 5, a = 2, b = 11, c = 13
     * 输出：10
     * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
     * 示例 4：
     * <p>
     * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
     * 输出：1999999984
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n, a, b, c <= 10^9
     * 1 <= a * b * c <= 10^18
     * 本题结果在[1,2 * 10^9]的范围内
     *
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int nthUglyNumber(int n, int a, int b, int c) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = getUglyNumber(result, a, b, c);
        }
        return result;
    }

    public static void main(String[] args) {
        No1201 no1201 = new No1201();
        System.out.println(no1201.nthUglyNumber(3, 2, 3, 5));
        System.out.println(no1201.nthUglyNumber(4, 2, 3, 4));
        System.out.println(no1201.nthUglyNumber(5, 2, 11, 13));
        System.out.println(no1201.nthUglyNumber(1000000000, 2, 217983653, 336916467));
    }

    private int getUglyNumber(int start, int a, int b, int c) {
        for (int i = start + 1; i < Integer.MAX_VALUE; i++) {
            if (i % a == 0 || i % b == 0 || i % c == 0) {
                return i;
            }

        }
        return 0;
    }


}
