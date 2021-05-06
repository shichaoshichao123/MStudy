package com.sc.study.leetCode;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/5/6 6:14 下午
 * @desc 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 */
public class No1004 {
    /**
     * 示例 1：
     * <p>
     * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
     * 输出：6
     * 解释：
     * [1,1,1,0,0,1,1,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
     * 示例 2：
     * <p>
     * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
     * 输出：10
     * 解释：
     * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 20000
     * 0 <= K <= A.length
     * A[i] 为0或1
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }
        //滑动窗口
        int start = 0;
        int end = 0;
        int zeroNum = 0;
        int maxLen = 0;
        boolean isOver = false;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            end++;
            if (0 == current) {
                zeroNum++;
            }
            if (zeroNum > k) {
                isOver = true;
                maxLen = Math.max(maxLen, end - start - 1);
                while (zeroNum > k) {
                    if (nums[start] == 0) {
                        zeroNum--;
                    }
                    start++;
                }
            }

        }
        //防止最后一个不为0导致的最大子串数量没有更新的情况
        maxLen = Math.max(maxLen, end - start);
        //防止0的数量小于可替换为1的次数的情况
        if (!isOver) {
            maxLen = nums.length;
        }
        return maxLen;

    }

    public static void main(String[] args) {
        No1004 no1004 = new No1004();
        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(no1004.longestOnes(nums, 0));
    }
}
