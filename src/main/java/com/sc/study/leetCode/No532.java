package com.sc.study.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/4/19 3:30 下午
 * @desc 给定一个整数数组和一个整数 k，你需要在数组里找到不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * <p>
 * 这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：
 * <p>
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 */
public class No532 {

    public static void main(String[] args) {
        No532 no532 = new No532();
        System.out.println(no532.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(no532.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(no532.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(no532.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3));
        System.out.println(no532.findPairs(new int[]{-1,-2,-3}, 1));
    }

    /**
     * 示例 1：
     * <p>
     * 输入：nums = [3, 1, 4, 1, 5], k = 2
     * 输出：2
     * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     * 示例 2：
     * <p>
     * 输入：nums = [1, 2, 3, 4, 5], k = 1
     * 输出：4
     * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     * 示例 3：
     * <p>
     * 输入：nums = [1, 3, 1, 5, 4], k = 0
     * 输出：1
     * 解释：数组中只有一个 0-diff 数对，(1, 1)。
     * 示例 4：
     * <p>
     * 输入：nums = [1,2,4,4,3,3,0,9,2,3], k = 3
     * 输出：2
     * 示例 5：
     * <p>
     * 输入：nums = [-1,-2,-3], k = 1
     * 输出：2
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (null == nums) {
            return 0;
        }
        List<String> olds = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (olds.contains(nums[i] + nums[j] + "")) {
                    continue;
                }
                if (isMatch(nums[i], nums[j], k)) {
                    olds.add(nums[i] + nums[j] + "");
                    result++;
                }
            }
        }

        return result;
    }


    /**
     * 绝对值是否等于指定值
     *
     * @param num1
     * @param num2
     * @param target
     * @return
     */
    private boolean isMatch(int num1, int num2, int target) {
        return num1 - num2 == -target || num1 - num2 == target;
    }


}
