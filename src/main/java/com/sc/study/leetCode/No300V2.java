package com.sc.study.leetCode;

import java.util.Arrays;

/**
 * @author yingqi
 * @version 1.0
 * @date 2021/6/30 3:23 下午
 * @desc 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class No300V2 {
    /**
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     * <p>
     * 进阶：
     * <p>
     * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
     * 你能将算法的时间复杂度降低到O(n log(n)) 吗?
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return doLengthOfLISV2(nums);
    }

    public static void main(String[] args) {
        No300V2 no300V2 = new No300V2();
        //System.out.println(no300V2.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(no300V2.lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
        //System.out.println(no300V2.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
    }

    /**
     * 使用动态规划的方式
     *
     * @param nums
     * @return
     */
    private static int doLengthOfLISV1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int[] dps = new int[nums.length + 1];
        Arrays.fill(dps, 1);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dps[i] = Math.max(dps[j], dps[j] + 1);
                }
            }
            res = Math.max(res, dps[i]);

        }
        return res;
    }

    /**
     * 通过二分查找的方式
     *
     * @param nums
     * @return
     */
    private static int doLengthOfLISV2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = 1;
        int[] d = new int[nums.length + 1];
        d[len] = nums[0];
        for (int num : nums) {
            if (d[len] < num) {
                d[++len] = num;
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (d[mid] < num) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = num;
            }
        }
        return len;
    }


}
