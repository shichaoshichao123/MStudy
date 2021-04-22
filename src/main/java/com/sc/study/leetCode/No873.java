package com.sc.study.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/22 11:11 上午
 * @desc 如果序列X_1, X_2, ..., X_n满足下列条件，就说它是斐波那契式的：
 * <p>
 * n >= 3
 * 对于所有i + 2 <= n，都有X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回0 。
 * <p>
 * （回想一下，子序列是从原序列 A中派生出来的，它从 A中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如，[3, 5, 8] 是[3, 4, 5, 6, 7, 8]的一个子序列）
 */
public class No873 {

    /**
     * 示例 1：
     * <p>
     * 输入: [1,2,3,4,5,6,7,8]
     * 输出: 5
     * 解释:
     * 最长的斐波那契式子序列为：[1,2,3,5,8] 。
     * 示例 2：
     * <p>
     * 输入: [1,3,7,11,12,14,18]
     * 输出: 3
     * 解释:
     * 最长的斐波那契式子序列有：
     * [1,11,12]，[3,11,14] 以及 [7,11,18] 。
     *
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        int maxLen = 0;
        if (null == arr) {
            return maxLen;
        }
        //初始化，用于判断需要的值是否在数组中
        Set<Integer> arrSet = new HashSet<>();
        for (int ite : arr) {
            arrSet.add(ite);
        }
        //进行遍历求解
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int x = arr[j];
                int target = arr[i] + arr[j];
                int length = 2;
                //如果预料的值包含在原数组中的化，就更新x以及预料的targrt
                while (arrSet.contains(target)) {
                    int temp = target;
                    target = target + x;
                    x = temp;
                    maxLen = Math.max(maxLen, ++length);
                }
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }

    public static void main(String[] args) {
        No873 no873 = new No873();
        System.out.println(no873.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }

}
