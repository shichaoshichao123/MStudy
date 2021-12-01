package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/24 3:46 下午
 * @desc 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class No279 {
    /**
     * 示例1：
     * <p>
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     * 示例 2：
     * <p>
     * 输入：n = 13
     * 输出：2
     * 解释：13 = 4 + 9
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 104
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int leftNum = n;
        List<Integer> result = new ArrayList<>();
        while (leftNum != 0) {
            for (int i = leftNum; i >= 1; i--) {
                if (i * i == n) {
                    result.add(i);
                    leftNum = 0;
                    break;
                } else if (i * i < n) {
                    leftNum = n - i * i;
                    result.add(i);
                }
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        No279 no279 = new No279();
//        System.out.println(no279.numSquares(1));
//        System.out.println(no279.numSquares(4));
        System.out.println(no279.numSquares(12));
//        System.out.println(no279.numSquares(13));
    }
}
